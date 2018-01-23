package com.lti.studio;

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
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@RefreshScope
@EnableCaching
@EnableSwagger2
@SpringBootApplication
public class StudioApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudioApplication.class, args);
	}
}
