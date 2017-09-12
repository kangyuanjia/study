 package com.kyj.common.runtime;
 
 import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.kyj.common.session.CustomHttpSession;
import com.kyj.common.session.SessionManager;
import com.kyj.common.session.User;
import com.kyj.common.utils.DateUtils;
 
 public class Runtime
 {
   private static ThreadLocal<RuntimeOperator> subject = new ThreadLocal();
 
 
   public static Map<String, String> runtimeInfo = new HashMap();
 
   public static void setOperateSubject(RuntimeOperator operateSubject)
   {
     subject.set(operateSubject);
   }
 
   public static RuntimeOperator getOperateSubject() {
     return ((RuntimeOperator)subject.get());
   }
 
   public static void clear() {
     subject.remove();
   }
 
   public static RuntimeOperator getSystemOperateSubject()
   {
     String sessionId = (String)runtimeInfo.get("system_session_id");
     CustomHttpSession systemSession = SessionManager.getSystemSession(sessionId);
     User systemUser = (User)systemSession.getAttribute("login_user", User.class);
     RuntimeOperator operateSubject = new RuntimeOperator();
     operateSubject.setSubject_id(systemUser.getUserId());
     Date d = new Date();
     operateSubject.setOperate_tm(DateUtils.getDateTime(d));
 
     return operateSubject;
   }
 }
