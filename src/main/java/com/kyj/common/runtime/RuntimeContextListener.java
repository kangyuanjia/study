 package com.kyj.common.runtime;
 
 import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
 
 public class RuntimeContextListener
   implements ServletContextListener
 {
   public void contextInitialized(ServletContextEvent sce)
   {
     System.out.println("系统启动中" + System.currentTimeMillis());
   }
 
   public void contextDestroyed(ServletContextEvent sce)
   {
     System.out.println("系统关闭" + System.currentTimeMillis());
   }
 }
