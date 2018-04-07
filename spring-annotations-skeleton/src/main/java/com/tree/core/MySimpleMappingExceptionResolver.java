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

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/** 
 *Description:
 * 全局异常：https://blog.csdn.net/butioy_org/article/details/78718405
 * <br>详解Spring全局异常处理的三种方式 <a>http://www.jb51.net/article/110776.htm</a>
 *<p>
	处理error的地方
 </p>
 * @author tree
 * @version V1.0                             
 */
public class MySimpleMappingExceptionResolver extends org.springframework.web.servlet.handler.SimpleMappingExceptionResolver {
	private static final Logger logger = Logger
			.getLogger(MySimpleMappingExceptionResolver.class);
	@Override
	protected ModelAndView getModelAndView(String viewName, Exception ex,
			HttpServletRequest request) {

		logger.error("runtime exception:", ex);//将异常信息打印到日志中
		return super.getModelAndView(viewName, ex, request);
	}

	

	
}

