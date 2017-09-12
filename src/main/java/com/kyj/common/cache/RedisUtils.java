package com.kyj.common.cache;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.kyj.common.conf.ConfigureManager;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtils {
	private static Logger log = Logger.getLogger(RedisUtils.class);

	private static JedisPool jedisPool = null;
	private static JedisPoolConfig poolConfig = null;
	private static String redisHost;
	private static int redisPort;
	public static int expireTime;

	public static Jedis getJedisResource() throws Exception {
		if (poolConfig == null) {
			loadConfig();
		}

		if (jedisPool == null)
			jedisPool = new JedisPool(poolConfig, redisHost, redisPort);
		try {
			return jedisPool.getResource();
		} catch (Exception e) {
			jedisPool = null;
			throw new Exception("Redis服务[" + redisHost + ":" + redisPort + "]无法正常使用!");
		}
	}

	public static void returnJedisResource(Jedis jedis, boolean isJedisConnectExeptionOccured) {
		if (jedis != null)
			if (isJedisConnectExeptionOccured) {
				jedisPool.returnBrokenResource(jedis);
			} else
				jedisPool.returnResource(jedis);
	}

	public static void resetJedisPool() {
		if (jedisPool != null)
			jedisPool.destroy();
		jedisPool = null;
		poolConfig = null;
	}

	private static void loadConfig() {
		InputStream stream = null;
		try {
			log.info("开始加载配置文件redis.properties...");
			Properties props = ConfigureManager.getConfigures("redis.properties");

			redisHost = props.getProperty("redis.host").trim();
			redisPort = Integer.parseInt(props.getProperty("redis.port").trim());

			poolConfig = new JedisPoolConfig();
			poolConfig.setMaxIdle(Integer.parseInt(props.getProperty("redis.pool.maxIdle").trim()));
			poolConfig.setMaxTotal(Integer.parseInt(props.getProperty("redis.pool.maxActive").trim()));
			poolConfig.setMaxWaitMillis(Long.parseLong(props.getProperty("redis.pool.maxWait").trim()));
			poolConfig.setMinEvictableIdleTimeMillis(Long.parseLong(props.getProperty("redis.pool.minEvictableIdleTimeMillis").trim()));
			poolConfig.setTimeBetweenEvictionRunsMillis(Long.parseLong(props.getProperty("redis.pool.timeBetweenEvictableRunsMillis").trim()));
			poolConfig.setTestOnBorrow(Boolean.parseBoolean(props.getProperty("redis.pool.testOnBorrow").trim()));
			poolConfig.setTestOnReturn(Boolean.parseBoolean(props.getProperty("redis.pool.testOnReturn").trim()));
			poolConfig.setTestWhileIdle(Boolean.parseBoolean(props.getProperty("redis.pool.testWhileIdle").trim()));

			expireTime = Integer.parseInt(props.getProperty("redis.expire.seconds").trim());

			log.info("配置文件redis.properties加载成功！");
		} catch (Exception e) {
			log.info("配置文件redis.properties加载失败！");
			log.error(e.getMessage());
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
					log.error(e.getMessage());
				}
				stream = null;
			}
		}
	}
}
