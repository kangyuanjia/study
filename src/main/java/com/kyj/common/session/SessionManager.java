 package com.kyj.common.session;
 
 import com.kyj.common.cache.CacheManager;
 import com.kyj.common.cache.CacheService;
 import com.kyj.common.utils.StringUtils;
 import java.io.IOException;
 import javax.servlet.ServletException;
 import javax.servlet.http.Cookie;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 
 public class SessionManager
 {
   private static CustomHttpSession systemSession = null;
 
   public static CustomHttpSession getSystemSession(String sessionId)
   {
     CacheService cache = CacheManager.getCacheService();
     return ((CustomHttpSession)cache.get("session@" + sessionId, CustomHttpSession.class));
   }
 
   public static String initSystemSession()
   {
     if (systemSession != null)
       return systemSession.getSessionId();
     String sessionId = StringUtils.getUUID() + "-" + System.currentTimeMillis();
     CacheService cache = CacheManager.getCacheService();
     systemSession = new CustomHttpSession(sessionId);
     cache.set("session@" + sessionId, systemSession, false);
     return sessionId;
   }
 
   public static CustomHttpSession getSession(HttpServletRequest request, HttpServletResponse response) throws Exception
   {
     CustomHttpSession cipSession = null;
     String sessionId = null;
 
     Cookie[] cookies = request.getCookies();
     if ((cookies != null) && (cookies.length > 0)) {
       for (Cookie cookie : cookies) {
         if (cookie.getName().equalsIgnoreCase("cip_sessionid")) {
           sessionId = cookie.getValue();
           break;
         }
       }
     }
 
     CacheService cache = CacheManager.getCacheService();
     if (sessionId == null) {
       sessionId = StringUtils.getUUID() + "-" + System.currentTimeMillis();
     }
     else {
       cipSession = (CustomHttpSession)cache.get("session@" + sessionId, CustomHttpSession.class);
       cache.resetExpireTime("session@" + sessionId);
     }
 
     if (cipSession == null)
     {
       writeCookie(response, "cip_sessionid", sessionId);
 
       cipSession = new CustomHttpSession(sessionId);
       cache.set("session@" + sessionId, cipSession, true);
     }
     return cipSession;
   }
 
   private static void writeCookie(HttpServletResponse response, String name, String value)
     throws ServletException, IOException
   {
     Cookie cookie = new Cookie(name, value);
 
     cookie.setPath("/");
     response.addCookie(cookie);
   }
 }
