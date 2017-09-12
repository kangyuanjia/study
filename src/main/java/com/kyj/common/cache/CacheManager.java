package com.kyj.common.cache;

public class CacheManager {
  public static final int CACHE_SCHEMA_REMOTE = 1;
  public static final int CACHE_SCHEMA_LOCAL = 0;
  private static CacheService cacheService = null;

  public static void createCacheManager(int cache_schema) {
    if (cacheService != null) {
      return;
    }
    if (cache_schema == 1)
      cacheService = new RemoteCacheManager();
    else
      cacheService = new LocalCacheManager();
  }

  public static CacheService getCacheService()
  {
    return cacheService;
  }
}
