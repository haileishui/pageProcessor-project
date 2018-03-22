package com.lmw.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

/**
 * 
 * <p> Description: properties文件获取工具类 </p>
 * @Author LiuMingWei
 * @Date [2017年10月17日] 
 * @Version V1.0 
 * @修改记录  
 * <pre>
 * 版本号      修改人    修改时间     修改内容描述
 * ----------------------------------------
 * V1.0  刘明伟   2017年10月17日   新建文件.
 * 
 * </pre>
 */
public class PropertyUtil {
	private static final Logger logger = LoggerFactory.getLogger(PropertyUtil.class);
	private static Properties props;
	static {
		loadProps();
	}

	synchronized static private void loadProps() {
		logger.info("开始加载properties文件内容.......");
		props = new Properties();
		InputStream in = null;
		try {
			//　　　　　　　<!--第一种，通过类加载器进行获取properties文件流-->
			in = PropertyUtil.class.getClassLoader().getResourceAsStream("properties/system.properties");
			//　　　　　　  <!--第二种，通过类进行获取properties文件流-->
			//in = PropertyUtil.class.getResourceAsStream("/jdbc.properties");
			props.load(in);
		} catch (FileNotFoundException e) {
			logger.error("system.properties文件未找到");
		} catch (IOException e) {
			logger.error("出现IOException");
		} finally {
			try {
				if (null != in) {
					in.close();
				}
			} catch (IOException e) {
				logger.error("system.properties文件流关闭出现异常");
			}
		}
		logger.info("加载properties文件内容完成...........");
		logger.info("properties文件内容：" + props);
	}

	public static String getProperty(String key) {
		if (null == props) {
			loadProps();
		}
		return props.getProperty(key);
	}

	public static String getProperty(String key, String defaultValue) {
		if (null == props) {
			loadProps();
		}
		return props.getProperty(key, defaultValue);
	}

	public static void main(String[] args) {
		System.out.println(PropertyUtil.getProperty("AppID"));
	}
}