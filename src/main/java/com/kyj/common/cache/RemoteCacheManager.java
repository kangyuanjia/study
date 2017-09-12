package com.kyj.common.cache;

import com.kyj.common.exception.CustomRuntimeException;
import com.kyj.common.runtime.CustomErrorCode;
import com.kyj.common.utils.JSONUtils;
import com.kyj.common.utils.SerializeUtil;

import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;

public class RemoteCacheManager implements CacheService {
	private Logger log;

	public RemoteCacheManager() {
		this.log = Logger.getLogger(RemoteCacheManager.class);
	}

	public void set(String key, Object data, boolean setExpireTime) {
		if (data == null)
			return;
		boolean isJedisConnectExceptionOccured = false;
		Jedis jedis = null;
		try {
			jedis = RedisUtils.getJedisResource();
			jedis.set(key.getBytes("UTF-8"), JSONUtils.convertObject2Json(data).getBytes("UTF-8"));
			if ((setExpireTime) && (RedisUtils.expireTime > 0))
				jedis.expire(key.getBytes("UTF-8"), RedisUtils.expireTime);
		} catch (JedisConnectionException e) {
			this.log.error(e.getMessage());

			throw new CustomRuntimeException(CustomErrorCode.ERROR_HTTP_REQUEST_IS_NOT_AVAILABLE, e);
		} catch (Exception e) {
			throw new CustomRuntimeException(CustomErrorCode.ERROR_TECHNICAL_ERROR, e);
		} finally {
			RedisUtils.returnJedisResource(jedis, isJedisConnectExceptionOccured);
		}
	}

	public <T> T get(String key, Class<T> clazz) {
		Object object = null;
		boolean isJedisConnectExceptionOccured = false;
		Jedis jedis = null;
		try {
			jedis = RedisUtils.getJedisResource();
			byte[] bytes = jedis.get(key.getBytes("UTF-8"));
			if (bytes != null) {
				String value = new String(bytes, "UTF-8");
				object = JSONUtils.convertJson2Object(value, clazz);
			}
		} catch (JedisConnectionException e) {
			this.log.error(e.getMessage());

			throw new CustomRuntimeException(CustomErrorCode.ERROR_HTTP_REQUEST_IS_NOT_AVAILABLE, e);
		} catch (Exception e) {
			throw new CustomRuntimeException(CustomErrorCode.ERROR_TECHNICAL_ERROR, e);
		} finally {
			RedisUtils.returnJedisResource(jedis, isJedisConnectExceptionOccured);
		}
		return (T) object;
	}

	public void hashset(String key, String field, Object data, boolean setExpireTime) {
		if (data == null)
			return;
		boolean isJedisConnectExceptionOccured = false;
		Jedis jedis = null;
		try {
			jedis = RedisUtils.getJedisResource();
			jedis.hset(key.getBytes("UTF-8"), field.getBytes("UTF-8"),
					JSONUtils.convertObject2Json(data).getBytes("UTF-8"));
			if ((setExpireTime) && (RedisUtils.expireTime > 0))
				jedis.expire(key.getBytes("UTF-8"), RedisUtils.expireTime);
		} catch (JedisConnectionException e) {
			this.log.error(e.getMessage());

			throw new CustomRuntimeException(CustomErrorCode.ERROR_HTTP_REQUEST_IS_NOT_AVAILABLE, e);
		} catch (Exception e) {
			throw new CustomRuntimeException(CustomErrorCode.ERROR_TECHNICAL_ERROR, e);
		} finally {
			RedisUtils.returnJedisResource(jedis, isJedisConnectExceptionOccured);
		}
	}

	public <T> T hashget(String key, String field, Class<T> clazz) {
		Object object = null;
		boolean isJedisConnectExceptionOccured = false;
		Jedis jedis = null;
		try {
			jedis = RedisUtils.getJedisResource();
			byte[] bytes = jedis.hget(key.getBytes("UTF-8"), field.getBytes("UTF-8"));
			if (bytes != null) {
				String value = new String(bytes, "UTF-8");
				object = JSONUtils.convertJson2Object(value, clazz);
			}
		} catch (JedisConnectionException e) {
			this.log.error(e.getMessage());

			throw new CustomRuntimeException(CustomErrorCode.ERROR_HTTP_REQUEST_IS_NOT_AVAILABLE, e);
		} catch (Exception e) {
			throw new CustomRuntimeException(CustomErrorCode.ERROR_TECHNICAL_ERROR, e);
		} finally {
			RedisUtils.returnJedisResource(jedis, isJedisConnectExceptionOccured);
		}
		return (T) object;
	}

	public void remove(String key) {
		boolean isJedisConnectExceptionOccured = false;
		Jedis jedis = null;
		try {
			jedis = RedisUtils.getJedisResource();
			jedis.del(key);
		} catch (JedisConnectionException e) {
			this.log.error(e.getMessage());

			throw new CustomRuntimeException(CustomErrorCode.ERROR_HTTP_REQUEST_IS_NOT_AVAILABLE, e);
		} catch (Exception e) {
			throw new CustomRuntimeException(CustomErrorCode.ERROR_TECHNICAL_ERROR, e);
		} finally {
			RedisUtils.returnJedisResource(jedis, isJedisConnectExceptionOccured);
		}
	}

	public void clear() {
		boolean isJedisConnectExceptionOccured = false;
		Jedis jedis = null;
		try {
			jedis = RedisUtils.getJedisResource();
			jedis.flushDB();
		} catch (JedisConnectionException e) {
			this.log.error(e.getMessage());

			throw new CustomRuntimeException(CustomErrorCode.ERROR_HTTP_REQUEST_IS_NOT_AVAILABLE, e);
		} catch (Exception e) {
			throw new CustomRuntimeException(CustomErrorCode.ERROR_TECHNICAL_ERROR, e);
		} finally {
			RedisUtils.returnJedisResource(jedis, isJedisConnectExceptionOccured);
		}
	}

	public void resetExpireTime(String key) {
		boolean isJedisConnectExceptionOccured = false;
		Jedis jedis = null;
		try {
			jedis = RedisUtils.getJedisResource();
			if (RedisUtils.expireTime > 0)
				jedis.expire(key.getBytes("UTF-8"), RedisUtils.expireTime);
		} catch (JedisConnectionException e) {
			this.log.error(e.getMessage());

			throw new CustomRuntimeException(CustomErrorCode.ERROR_HTTP_REQUEST_IS_NOT_AVAILABLE, e);
		} catch (Exception e) {
			throw new CustomRuntimeException(CustomErrorCode.ERROR_TECHNICAL_ERROR, e);
		} finally {
			RedisUtils.returnJedisResource(jedis, isJedisConnectExceptionOccured);
		}
	}

}
