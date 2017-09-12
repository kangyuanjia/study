package com.kyj.common.cache;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.apache.log4j.Logger;

import com.kyj.common.exception.CustomRuntimeException;
import com.kyj.common.runtime.CustomErrorCode;
import com.kyj.common.utils.SerializeUtil;

import redis.clients.jedis.Jedis;

public class MybatisRedisCache implements Cache {
	private static Logger log = Logger.getLogger(MybatisRedisCache.class);
	/** The ReadWriteLock. */
	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	private String id;

	public MybatisRedisCache(final String id) {
		if (id == null) {
			throw new IllegalArgumentException("必须传入ID");
		}
		log.debug("MybatisRedisCache:id=" + id);
		this.id = id;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public int getSize() {
		Jedis jedis = null;
		boolean isJedisConnectExceptionOccured = false;
		int result = 0;
		try {
			jedis = RedisUtils.getJedisResource();
			result = Integer.valueOf(jedis.dbSize().toString());
		} catch (Exception e) {
			this.log.error(e.getMessage());
			throw new CustomRuntimeException(CustomErrorCode.ERROR_TECHNICAL_ERROR, e);
		} finally {
			RedisUtils.returnJedisResource(jedis, isJedisConnectExceptionOccured);
		}
		return result;

	}

	@Override
	public void putObject(Object key, Object value) {
		if (log.isDebugEnabled())
			log.debug("putObject:" + key.hashCode() + "=" + value);
		if (log.isInfoEnabled())
			log.info("put to redis sql :" + key.toString());
		Jedis jedis = null;
		boolean isJedisConnectExceptionOccured = false;
		try {
			jedis = RedisUtils.getJedisResource();
			jedis.set(SerializeUtil.serialize(key.hashCode()), SerializeUtil.serialize(value));
			if (RedisUtils.expireTime > 0)
				jedis.expire(SerializeUtil.serialize(key.hashCode()), RedisUtils.expireTime);
		} catch (Exception e) {
			this.log.error(e.getMessage());
			throw new CustomRuntimeException(CustomErrorCode.ERROR_TECHNICAL_ERROR, e);
		} finally {
			RedisUtils.returnJedisResource(jedis, isJedisConnectExceptionOccured);
		}

	}

	@Override
	public Object getObject(Object key) {
		Jedis jedis = null;
		boolean isJedisConnectExceptionOccured = false;
		Object value = null;
		try {
			jedis = RedisUtils.getJedisResource();
			value = SerializeUtil.unserialize(jedis.get(SerializeUtil.serialize(key.hashCode())));
		} catch (Exception e) {
	    	this.log.error(e.getMessage());
	    	throw new CustomRuntimeException(CustomErrorCode.ERROR_TECHNICAL_ERROR, e);
	    } finally {
	    	  RedisUtils.returnJedisResource(jedis, isJedisConnectExceptionOccured);
	    }
		if (log.isDebugEnabled())
			log.debug("getObject:" + key.hashCode() + "=" + value);
		return value;
	}

	@Override
	public Object removeObject(Object key) {
		Jedis jedis = null;
		boolean isJedisConnectExceptionOccured = false;
		Object value = null;
		try {
			jedis =  RedisUtils.getJedisResource();
			value = jedis.expire(SerializeUtil.serialize(key.hashCode()), 0);
		} catch (Exception e) {
	    	this.log.error(e.getMessage());
	    	throw new CustomRuntimeException(CustomErrorCode.ERROR_TECHNICAL_ERROR, e);
	    } finally {
	    	  RedisUtils.returnJedisResource(jedis, isJedisConnectExceptionOccured);
	    }
		if (log.isDebugEnabled())
			log.debug("getObject:" + key.hashCode() + "=" + value);
		return value;
	}

	@Override
	public void clear() {
		Jedis jedis = null;
		boolean isJedisConnectExceptionOccured = false;
		try {
			jedis = RedisUtils.getJedisResource();
			jedis.flushDB();
			jedis.flushAll();
		} catch (Exception e) {
	    	this.log.error(e.getMessage());
	    	throw new CustomRuntimeException(CustomErrorCode.ERROR_TECHNICAL_ERROR, e);
	    } finally {
	    	  RedisUtils.returnJedisResource(jedis, isJedisConnectExceptionOccured);
	    }
	}

	@Override
	  public ReadWriteLock getReadWriteLock() {
	    return readWriteLock;
	  }
}