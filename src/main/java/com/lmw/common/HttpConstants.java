package com.lmw.common;
/**
 * 
 * <p> Description: 返回状态 </p>
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
public class HttpConstants {

	public static final String SYSTEM_ERROR_MSG = "系统错误";
	
	public static final String REQUEST_PARAMS_NULL = "请求参数为空";

	public static final String SERVICE_RESPONSE_NULL = "服务端返回结果为空";
	
	public static final String SERVICE_RESPONSE_OBJECT = "object";
	
	// 服务端返回成功的标志
	public static final String SERVICE_RESPONSE_SUCCESS_CODE = "AMS00000";
	
	// 服务端返回结果的标志
	public static final String SERVICE_RESPONSE_RESULT_FLAG = "returnCode";
	
	// 服务端返回结果的标志
	public static final String SERVICE_RESPONSE_RESULT_MSG = "resultMsg";
	
	// 返回给前段页面成功或失败的标志
	public static final String RESPONSE_RESULT_FLAG_ISSUCCESS = "isSuccess";
	
	// 执行删除操作
	public static final String OPERATION_TYPE_DELETE = "D";

	public static final String ENUM_PATH = "com.mucfc.msm.enumeration.";
	
}
