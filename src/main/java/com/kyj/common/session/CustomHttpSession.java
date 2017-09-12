 package com.kyj.common.session;
 
 import com.kyj.common.cache.CacheManager;
 import com.kyj.common.cache.CacheService;
 import com.kyj.common.utils.JSONUtils;
 import java.util.HashMap;
 import java.util.Map;
 
 public class CustomHttpSession
 {
   private String sessionId;
   private Map<String, Object> attributes = new HashMap();
 
   public CustomHttpSession() { }
 
   public CustomHttpSession(String sessionId) {
     this.sessionId = sessionId;
   }
 
   public <T> T getAttribute(String key, Class<T> clazz) {
     Object value = this.attributes.get(key);
     return ((value == null) ? null : JSONUtils.convertJson2Object(value.toString(), clazz));
   }
 
   public void setAttributes(Map<String, Object> attrs) throws Exception
   {
     this.attributes.putAll(attrs);
     if (this.sessionId == null)
       return;
     CacheService cache = CacheManager.getCacheService();
     cache.set("session@" + this.sessionId, this, true);
   }
 
   public void setAttribute(String key, Object obj) throws Exception {
     this.attributes.put(key, obj);
     if (this.sessionId == null)
       return;
     CacheService cache = CacheManager.getCacheService();
     cache.set("session@" + this.sessionId, this, true);
   }
 
   public void setAttribute(String key, Object obj, boolean setExpireTime) throws Exception {
     this.attributes.put(key, obj);
     if (this.sessionId == null)
       return;
     CacheService cache = CacheManager.getCacheService();
     cache.set("session@" + this.sessionId, this, setExpireTime);
   }
 
   public void removeAttribute(String key) throws Exception {
     this.attributes.remove(key);
     if (this.sessionId == null)
       return;
     CacheService cache = CacheManager.getCacheService();
     cache.set("session@" + this.sessionId, this, true);
   }
 
   public void invalidate() throws Exception {
     CacheService cache = CacheManager.getCacheService();
     cache.remove("session@" + this.sessionId);
   }
 
   public String getSessionId() {
     return this.sessionId;
   }
 
   public void setSessionId(String sessionId) {
     this.sessionId = sessionId;
   }
 
   public Map<String, Object> getAttributes() {
     return this.attributes;
   }
 }
