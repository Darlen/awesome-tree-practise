/*
 * COPYRIGHT Beijing NetQin-Tech Co.,Ltd.                                   *
 ****************************************************************************
 * 源文件名:  web.core.CP_SimpleMappingExceptionResolver.java 													       
 * 功能: cpframework框架													   
 * 版本:	@version 1.0	                                                                   
 * 编制日期: 2014年8月27日 下午5:51:32 						    						                                        
 * 修改历史: (主要历史变动原因及说明)		
 * YYYY-MM-DD |    Author      |	 Change Description		      
 * 2014年8月27日    |    Administrator     |     Created 
 */
package com.tree.core;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

/** 
 *Description: <类功能描述>. <br>
 *<p>
	处理error的地方
 </p>
 *Makedate:2014年8月27日 下午5:51:32 
 * @author Administrator  
 * @version V1.0                             
 */
public class SimpleMappingExceptionResolver extends org.springframework.web.servlet.handler.SimpleMappingExceptionResolver {
	private static final Logger logger = Logger
			.getLogger(SimpleMappingExceptionResolver.class);
	@Override
	protected ModelAndView getModelAndView(String viewName, Exception ex,
			HttpServletRequest request) {

		logger.error("runtime exception:", ex);//将异常信息打印到日志中
		return super.getModelAndView(viewName, ex, request);
	}

	

	
}

