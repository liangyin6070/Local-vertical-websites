package com.liupro.web.manage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.framwork.core.spring.BaseRestController;
import com.framwork.utils.ResponseUtils;
import com.liupro.web.manage.model.Demo;
/**
 * 
 * @description 
 * @author ldw
 * @datetime 2016年12月27日 上午9:49:56
 */
@Controller
public class CommonController extends BaseRestController {
	
	private static Logger log = LoggerFactory.getLogger(CommonController.class);
	
	@RequestMapping(value="/common/blank",method=RequestMethod.GET)
	public String toBlank() {
		return "/admin/blank";
	}
	
	@RequestMapping(value="/common/upload/demo",method=RequestMethod.POST)
	public void upload(@RequestParam(value = "demo_file", required = false) MultipartFile file, 
			HttpServletRequest request, HttpServletResponse response) {
//    	String path = request.getSession().getServletContext().getRealPath("upload");  
//	      String fileName = file.getOriginalFilename();  
//	      File targetFile = new File(path, fileName);  
//	      if(!targetFile.exists()){  
//	          targetFile.mkdirs();  
//	      }  
//	      //保存  
//	      try {  
//	          file.transferTo(targetFile); 
//	      } catch (Exception e) {  
//	          e.printStackTrace();  
//	      }  
    //  model.addAttribute("fileUrl", request.getContextPath()+"/upload/"+fileName); 
		
		JSONObject obj = new JSONObject();
		ImportParams params = new ImportParams();
		params.setTitleRows(1);
		params.setHeadRows(1);
//		params.setNeedSave(true);
//		params.setSaveUrl("upload");
		try {
			List<Demo> list = ExcelImportUtil.importExcel(file.getInputStream(), Demo.class, params);
			for (Demo demo : list) {
				System.out.println(demo.getId() + "," + demo.getName() + "," + demo.getAddress());
			}
			obj.put("success", true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResponseUtils.renderJson(response, obj.toJSONString());
	}
}
