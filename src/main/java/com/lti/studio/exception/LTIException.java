package com.lti.studio.exception;

/*************************************************************************
 * 
 * LTI CONFIDENTIAL
 * __________________
 * 
 * NOTICE:  All information contained herein is, and remains 
 * the property of LTI.  The intellectual and technical
 * concepts contained herein are proprietary to LTI and 
 * are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from LTI.
 */
 
import java.util.ArrayList;
import org.springframework.util.StringUtils;

public class LTIException extends Exception {
	
	private static final long serialVersionUID = 3997767591342849528L;
	private String errorCode;
	private String[] valueParams;
	private Throwable absoluteExceptionTrace;

	public LTIException(String errorCode) {
		this.errorCode = errorCode;
	}
	
	public LTIException(ArrayList<?> list) {
		super("exception");
		this.errorCode="exception";
	}
	
	public LTIException(LTIException le) {
		
	}
	
	public LTIException(String errorCode, Throwable absoluteExceptionTrace) {
		super(absoluteExceptionTrace);
		this.errorCode = errorCode;
		this.absoluteExceptionTrace = absoluteExceptionTrace;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public Throwable getAbsoluteExceptionTrace() {
		return absoluteExceptionTrace;
	}

	public void setAbsoluteExceptionTrace(Throwable absoluteExceptionTrace) {
		super.setStackTrace(absoluteExceptionTrace.getStackTrace());
		this.absoluteExceptionTrace = absoluteExceptionTrace;
	}

	public String[] getValueParams() {
		return valueParams;
	}

	public void setValueParams(String[] valueParams) {
		
		this.valueParams = valueParams;
	}

	public String toString() {
		return errorCode;
	}

	public String getExceptionName() {
		return this.getClass().getName();
	}
	
	public String renderMessage(String message,String[] valueParams) {
		String messageString = "";
		messageString = PropertyLoader.getMessage(message,"Action Cannot be performed");
		
		if(valueParams != null){
			String messageParams []= (String[]) valueParams;
			byte paramCount=0;
			for(String str : messageParams){
	 		  messageString = StringUtils.replace(messageString, "{"+paramCount+"}", str);
	 		  paramCount++;	 		  
	 	  }
		}
		
		return messageString;
	}
	
	public String createErrorMessage() {
		String msg=renderMessage(getErrorCode(),getValueParams());
		return msg;
	}
}
