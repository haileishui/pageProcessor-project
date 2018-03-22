package com.lmw.util;

import com.github.pagehelper.PageHelper;
import com.lmw.domain.BaseBean;

/**
 * 
 * <p> Description: 分页工具类封装 </p>
 * @Author LiuMingWei
 * @Date [2017年9月21日] 
 * @Version V1.0 
 * @修改记录  
 * <pre>
 * 版本号      修改人    修改时间     修改内容描述
 * ----------------------------------------
 * V1.0  刘明伟   2017年9月21日   新建文件.
 * 
 * </pre>
 */

public class PageUtil {
	/**
	 * 
	 * startPage
	 * @方法描述: 对pageHelper分页方法进行封装，实体对象比继续继承BaseBean,否者不达到分页效果
	 * @逻辑描述: 
	 * @Author LiuMingWei
	 * @Date [2017年10月27日] 
	 * @Version V1.0 
	 * @param obj
	 * @since Ver 1.00
	 */
	public static void startPage(BaseBean obj) {
		if (null != obj) {
			PageHelper.startPage(obj.getPageNumber(), obj.getPageSize());
		}
	}
}
