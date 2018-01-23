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
 
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {
	static Properties props = null;

	public PropertyLoader() throws FileNotFoundException, IOException {
		props = new Properties();
		props.load(this.getClass().getResourceAsStream("/message.properties"));
	}
	
	public static String getMessage(String messageCode, String defaultMessage) {
		defaultMessage = defaultMessage == null ? "" : defaultMessage;
		return props.getProperty(messageCode, defaultMessage);
	}
}
