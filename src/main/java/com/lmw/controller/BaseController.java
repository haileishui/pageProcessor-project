package com.lmw.controller;

import java.util.Date;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lmw.common.HttpConstants;
import com.lmw.json.JsonDateValueProcessor;

/**
 * 
 * <p> Description: Controller基类 </p>
 * @Author LiuMingWei
 * @Date [2017年9月20日] 
 * @Version V1.0 
 * @修改记录  
 * <pre>
 * 版本号      修改人    修改时间     修改内容描述
 * ----------------------------------------
 * V1.0  刘明伟   2017年9月20日   新建文件.
 * 
 * </pre>
 */
public class BaseController {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	protected final static String DATE_FORMATE = "yyyy-MM-dd";

	/**
	 * 返回服务端处理结果
	 * @param obj 服务端输出对象
	 * @return 输出处理结果给前段JSON格式数据
	 * @author YANGHONGXIA
	 * @since 2015-01-06
	 */
	public String responseResult(Object obj) {
		JSONObject jsonObj = null;
		if (obj != null) {
			//			logger.info("后端返回对象：{}", obj);
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
			jsonObj = JSONObject.fromObject(obj, jsonConfig);
			//			logger.info("后端返回数据：" + jsonObj);
		}
		if (HttpConstants.SERVICE_RESPONSE_SUCCESS_CODE.equals(jsonObj.getString(HttpConstants.SERVICE_RESPONSE_RESULT_FLAG))) {
			jsonObj.element(HttpConstants.RESPONSE_RESULT_FLAG_ISSUCCESS, true);
			jsonObj.element(HttpConstants.SERVICE_RESPONSE_RESULT_MSG, "");
		} else {
			jsonObj.element(HttpConstants.RESPONSE_RESULT_FLAG_ISSUCCESS, false);
			String errMsg = jsonObj.getString(HttpConstants.SERVICE_RESPONSE_RESULT_MSG);
			jsonObj.element(HttpConstants.SERVICE_RESPONSE_RESULT_MSG, errMsg == null ? HttpConstants.SERVICE_RESPONSE_NULL : errMsg);
		}
		logger.info("输出结果：{}", jsonObj.toString());
		return jsonObj.toString();
	}

	/**
	 * 返回成功
	 * @param obj 输出对象
	 * @return 输出成功的JSON格式数据
	 */
	public String responseSuccess(Object obj) {
		JSONObject jsonObj = null;
		if (obj != null) {
			//			logger.info("后端返回对象：{}", obj);
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
			jsonObj = JSONObject.fromObject(obj, jsonConfig);
			//			logger.info("后端返回数据：" + jsonObj);
		}
		jsonObj.element(HttpConstants.RESPONSE_RESULT_FLAG_ISSUCCESS, true);
		jsonObj.element(HttpConstants.SERVICE_RESPONSE_RESULT_MSG, "");
		logger.info("输出结果：{}", jsonObj.toString());
		return jsonObj.toString();
	}

	/**
	 * 返回成功
	 * @param obj 输出对象
	 * @return 输出成功的JSON格式数据
	 */
	public String responseArraySuccess(Object obj) {
		JSONObject jsonObj = new JSONObject();
		if (obj != null) {
			//			logger.info("后端返回对象：{}", obj);
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
			JSONArray jsonArray = JSONArray.fromObject(obj, jsonConfig);
			//			logger.info("后端返回数据：" + jsonArray);
			jsonObj.element("jsonArray", jsonArray);
		}
		jsonObj.element(HttpConstants.RESPONSE_RESULT_FLAG_ISSUCCESS, true);
		jsonObj.element(HttpConstants.SERVICE_RESPONSE_RESULT_MSG, "");
		logger.info("输出结果：{}", jsonObj.toString());
		return jsonObj.toString();
	}

	/**
	 * 
	 * responseObjectAndListSuccess
	 * @方法描述: 返回一个bean对象，已经dataList，和msg
	 * @逻辑描述: 
	 * @Author LiuMingWei
	 * @Date [2017年10月25日] 
	 * @Version V1.0 
	 * @param obj
	 * @param dataObj
	 * @param msg
	 * @return
	 * @since Ver 1.00
	 */
	public String responseObjectAndListSuccess(Object obj, Object dataObj, String msg) {
		JSONObject jsonObj = null;
		if (obj != null) {
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
			jsonObj = JSONObject.fromObject(dataObj, jsonConfig);
			jsonObj.element(HttpConstants.SERVICE_RESPONSE_OBJECT, obj);
		}
		jsonObj.element(HttpConstants.RESPONSE_RESULT_FLAG_ISSUCCESS, true);
		jsonObj.element(HttpConstants.SERVICE_RESPONSE_RESULT_MSG, msg);
		logger.info("输出结果：{}", jsonObj.toString());
		return jsonObj.toString();
	}

	/**
	 * 返回成功
	 * @param obj 输出对象
	 * @return 输出成功的JSON格式数据
	 */
	public String responseSuccess(Object obj, String msg) {
		JSONObject jsonObj = null;
		if (obj != null) {
			//			logger.info("后端返回对象：{}", obj);
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
			jsonObj = JSONObject.fromObject(obj, jsonConfig);
			//			logger.info("后端返回数据：" + jsonObj);
		}
		jsonObj.element(HttpConstants.RESPONSE_RESULT_FLAG_ISSUCCESS, true);
		jsonObj.element(HttpConstants.SERVICE_RESPONSE_RESULT_MSG, msg);
		logger.info("输出结果：{}", jsonObj.toString());
		return jsonObj.toString();
	}

	/**
	 * 返回成功
	 * @param obj 输出对象
	 * @return 输出成功的JSON格式数据
	 */
	public String responseSuccess(String msg) {
		JSONObject jsonObj = new JSONObject();
		jsonObj.element(HttpConstants.RESPONSE_RESULT_FLAG_ISSUCCESS, true);
		jsonObj.element(HttpConstants.SERVICE_RESPONSE_RESULT_MSG, msg);
		logger.info("输出结果：{}", jsonObj.toString());
		return jsonObj.toString();
	}

	/**
	 * 返回失败
	 * @param errorMsg 错误信息
	 * @return 输出失败的JSON格式数据
	 */
	public String responseFail(String errorMsg) {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put(HttpConstants.RESPONSE_RESULT_FLAG_ISSUCCESS, false);
		jsonObj.put(HttpConstants.SERVICE_RESPONSE_RESULT_MSG, errorMsg);
		logger.info("输出结果：{}", jsonObj.toString());
		return jsonObj.toString();
	}

	//	public void getUserNameBySession(){
	//		Subject currentUser = SecurityUtils.getSubject();
	//		if (null != currentUser) {
	//			Session session = currentUser.getSession();
	//			logger.info("Session默认超时时间为[" + session.getTimeout() + "]毫秒");
	//			if (null != session) {
	//				UserAndCustomerInfo userAndCustomerInfo = (UserAndCustomerInfo) session.getAttribute("currentUser");
	//				List<UserAndCustomerInfo> userAndCustomerInfoList= (List<UserAndCustomerInfo>) session.getAttribute("userAndCustomerInfo");
	//				List<String> salesErpIdList = (List<String>) session.getAttribute("salesErpId");
	//			}
	//		}
	//	}
}
