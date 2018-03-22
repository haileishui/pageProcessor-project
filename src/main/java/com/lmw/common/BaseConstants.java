package com.lmw.common;

import java.util.Date;

import com.lmw.util.DateTimeFormat;

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
public class BaseConstants {

	public static final String SEND_WEIXIN_TEXT = ",您好,截止" + DateTimeFormat.getDateBillFormat(new Date()) + "您的客户有恶性超期订单，请登录销售员查询系统查看明细！";
	
	public static final String SEND_WEIXIN_OVERDUE_RECEIVABLES_TEXT = ",您好,截止" + DateTimeFormat.getDateBillFormat(new Date()) + "您名下的7日内到期应收，提醒客户尽快安排付款，避免逾期发生！";
	
}
