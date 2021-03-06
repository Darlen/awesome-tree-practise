/*
 * COPYRIGHT Beijing NetQin-Tech Co.,Ltd.                                   *
 ****************************************************************************
 * 源文件名:  web.function.controller.DemoController.java 													       
 * 功能: cpframework框架													   
 * 版本:	@version 1.0	                                                                   
 * 编制日期: 2014年8月15日 上午10:12:33 						    						                                        
 * 修改历史: (主要历史变动原因及说明)		
 * YYYY-MM-DD |    Author      |	 Change Description		      
 * 2014年8月15日    |    Administrator     |     Created 
 */
package com.tree.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.tree.model.User;
import com.tree.service.impl.UserService;
import com.tree.utils.HttpClientUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


/**
 * Description: <类功能描述>. <br>
 * <br> 1. list user --> list(demo.jsp)
 * <br> 2. add user --> presave(savedemo.jsp), save(demo.jsp) -->
 * <br> 3. get user  -->{id}(demo.jsp)
 * <br> 4. json  --> jsonmock
 * <br> 5. xml --> xmlmock
 * <br> 6. delete cache -->flashcache
 * <br> 7. 文件上传 --> uploadpic
 * 注意：配置Nas并映射上去
 *
 * Makedate:2014年8月15日 上午10:12:33
 * 
 * @author Administrator
 * @version V1.0
 */
@Controller
@RequestMapping("/user")
public class DemoController {

	private static final Logger logger = Logger.getLogger(DemoController.class);

    @Value("${nas.path}")
    private String nasPath;

	@Autowired
	private UserService userService;

    @RequestMapping("/list")
    public String listUser(Model model) {
        logger.info("  listUser ");
        List<User> list = userService.getAllUser();
        model.addAttribute("results", list);
        return "demo";
    }

    @RequestMapping(value = "/presave")
    public String handlePreSave(Model model) {
        logger.info("==========handlePreSave==============");
        return "savedemo";
    }


    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user , Model model) {
        logger.info("==========handleSave==============");
        userService.addUser(user);
        model.addAttribute("user", user);
        model.addAttribute("id", user.getId());
        return "demo";

    }

	@RequestMapping("/{id}")
	public String getUser(@PathVariable("id") Long id, Model model) {
		logger.info("demo01  id==" + id);
        User user = userService.getUserById(id);
		model.addAttribute("id", id);
        model.addAttribute("user", user);

        return "demo";
	}


	@RequestMapping("/jsonmock")
    @ResponseBody
	public String handleJsonMock() {
		// 因为使用了属性拦截器对日期字符串yyyy-MM-dd自动转换为date类型
		String requestBody = "{\"nickname\":\"王五\",\"email\":tree317035791@163.com,\"createDate\":\"2018-04-05\",\"modifyDate\":\"2018-04-05\"}";
        String result = "";
        try {
			 result = HttpClientUtil.httpPost(
					"http://localhost:8080/user/save", requestBody,
					MediaType.APPLICATION_JSON_VALUE);
			logger.info("result======" + result);

		} catch (Exception e) {
			e.printStackTrace();
		}
        return result;
	}

    @RequestMapping(value = "/savejson", produces = {MediaType.APPLICATION_JSON_VALUE})
    public User saveJson(@RequestBody User user) {
        // update by id
        userService.addUser(user);
        return user;
    }

//	@RequestMapping("/xmlmock")
//    @ResponseBody
//	public String handleXmlMock() {
//		// 因为使用了属性拦截器对日期字符串yyyy-MM-dd自动转换为date类型
//		String requestBody = "<user><email>tree3170@gmail.com</email><createTime>2014-08-20</createTime><modifyTime>2014-08-28</modifyTime><nickname>赵四</nickname></user>";
//		String result = "";
//        try {
//			result = HttpClientUtil.httpPost(
//					"http://localhost:8080/user/savexml",
//					requestBody, MediaType.APPLICATION_XML_VALUE);
//			logger.info("result======" + result);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//        return result;
//	}
//
//    @RequestMapping(value = "/savexml")
//    public User saveXml(@RequestBody User user) {
//        // update by id
//        userService.addUser(user);
//        return user;
//    }



	@RequestMapping("/evictUser/{id}")
    @ResponseBody
	public String handleFlashCache(@PathVariable("id") Long id) {
		logger.info("==========handleFlashCache==============");

        if(id == 0L){
            id = 1L;
        }
		userService.delete(userService.getUserById(id));
        return "delete user cache success:"+id;
	}

    @RequestMapping(value = "/uploadPic" ,method=RequestMethod.POST, params = "method=uploadPic")
    public String upload(HttpServletRequest request, @RequestParam(value = "file") MultipartFile multipartFile, ModelMap model) {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMddHH");
        /**得到图片保存目录的真实路径**/
        String logoRealPathDir = nasPath ;
        /**根据真实路径创建目录**/
        File logoSaveFile = new File(logoRealPathDir);
        if(!logoSaveFile.exists())
            logoSaveFile.mkdirs();
        /**使用UUID生成文件名称**/
        String logImageName = dateformat.format(new Date()) + "/" + UUID.randomUUID().toString()+ multipartFile.getOriginalFilename() ;//构建文件名称
        /**拼成完整的文件保存路径加文件**/
        String fileName = logoRealPathDir + File.separator   + logImageName;
        File file = new File(fileName);

        try {
            multipartFile.transferTo(file);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /**必须转化为静态文件映射的Nas地址才能访问*/
        String realUrl = "http://localhost:8080/upload/"+logImageName;
        logger.info("abs file path ："+fileName);
        logger.info("fileUrl："+realUrl);
        model.put("fileName", fileName);
        model.addAttribute("absFileUrl", ""+fileName);
        model.addAttribute("fileUrl", realUrl);
        return "uploadResult";

    }


}
