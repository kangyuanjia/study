 package com.kyj.common.exception;
 
 import com.kyj.common.runtime.CustomErrorCode;
 
 public class ServiceException extends RuntimeException
 {
   private static final long serialVersionUID = -8911841526915972591L;
   private CustomErrorCode errorCode;
 
   public ServiceException(CustomErrorCode msg)
   {
     super(msg.name);
     this.errorCode = msg;
   }
 
   public ServiceException(Throwable cause) {
     super(cause);
   }
 
   public ServiceException(CustomErrorCode msg, Throwable cause) {
     super(msg.name, cause);
     this.errorCode = msg;
   }
 
   public CustomErrorCode getErrorCode()
   {
     return this.errorCode;
   }
 
   public void setErrorCode(CustomErrorCode errorCode) {
     this.errorCode = errorCode;
   }
 
   public String getMessage() {
     if (super.getCause() == null) {
       return super.getMessage();
     }
     return super.getMessage() + ", nested exception is " + super.getCause().toString();
   }
 }
