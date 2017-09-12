 package com.kyj.common.exception;
 
 public abstract class BaseCheckedException extends Exception
 {
   private static final long serialVersionUID = -8137598391819394645L;
 
   public BaseCheckedException(String msg)
   {
     super(msg);
   }
 
   public BaseCheckedException(String msg, Throwable cause) {
     super(msg, cause);
   }
 
   public String getMessage()
   {
     return ExceptionUtils.buildMessage(super.getMessage(), getCause());
   }
 
   public Throwable getRootCause()
   {
     Throwable rootCause = null;
     Throwable cause = getCause();
     while ((cause != null) && (cause != rootCause)) {
       rootCause = cause;
       cause = cause.getCause();
     }
     return rootCause;
   }
 
   public Throwable getMostSpecificCause()
   {
     Throwable rootCause = getRootCause();
     return ((rootCause != null) ? rootCause : this);
   }
 
   public boolean contains(Class<?> exType)
   {
     if (exType == null) {
       return false;
     }
     if (exType.isInstance(this)) {
       return true;
     }
     Throwable cause = getCause();
     if (cause == this) {
       return false;
     }
     if (cause instanceof BaseCheckedException) {
       return ((BaseCheckedException)cause).contains(exType);
     }
 
     while (cause != null) {
       if (exType.isInstance(cause)) {
         return true;
       }
       if (cause.getCause() == cause) {
         break;
       }
       cause = cause.getCause();
     }
     return false;
   }
 
   static
   {
     ExceptionUtils.class.getName();
   }
 }
