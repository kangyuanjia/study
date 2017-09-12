 package com.kyj.common.exception;
 
 import com.kyj.common.runtime.CustomErrorCode;
 
 public class DaoException extends RuntimeException
 {
   private static final long serialVersionUID = -8911841526915972592L;
   private CustomErrorCode errorCode = null;
 
   public DaoException(CustomErrorCode error) { super(error.name);
     this.errorCode = error;
   }
 
   public DaoException(Throwable cause) {
     super(cause);
   }
 
   public DaoException(CustomErrorCode error, Throwable cause) {
     super(error.name, cause);
     this.errorCode = error;
   }
 
   public CustomErrorCode getErrorCode()
   {
     return this.errorCode;
   }
 
   public String getMessage() {
     if (super.getCause() == null) {
       return super.getMessage();
     }
     return super.getMessage() + ", nested exception is " + super.getCause().toString();
   }
 }
