package com.framwork.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.util.Base64Utils;

public class ImageUtils {	
	/**
	 * @Description: 根据图片地址转换为base64编码字符串
	 * @Author: 
	 * @CreateTime: 
	 * @return
	 */
	public static String getImageStr(String imgFile) {
		FileInputStream is = null;
	    byte[] data = null;
	    try {
	    	is = FileUtils.openInputStream(new File(imgFile));
	        data = new byte[is.available()];
	        is.read(data);
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	    	IOUtils.closeQuietly(is);
	    }
	    // 加密
	    return Base64Utils.encodeToString(data);
	}
	
	public static String imageToString(String imgFile) {
		FileInputStream is = null;
	    byte[] data = null;
	    try {
	    	File file = new File(imgFile);
	    	if(!file.exists()) {
	    		return "";
	    	}
	    	is = FileUtils.openInputStream(file);
	        data = new byte[is.available()];
	        is.read(data);
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	    	IOUtils.closeQuietly(is);
	    }
	    // 加密
	    
	    return Base64Utils.encodeToString(data);
	}
	
	public static void main(String []args) {
		System.out.println(imageToString("D:\\images\\s29105145.jpg"));
	}
}
