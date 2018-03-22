package com.lmw.util;

import java.util.List;

import com.github.pagehelper.Page;

/**
 * 
 * <p> Description:  </p>
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

@SuppressWarnings({ "unchecked", "rawtypes" })
public class BeanUtil {

	public static <T> PagedResult<T> toPagedResult(List<T> datas) {
		PagedResult<T> result = new PagedResult<T>();
		if (datas instanceof Page) {
			Page<T> page = (Page) datas;
			result.setPageNo(page.getPageNum());
			result.setPageSize(page.getPageSize());
			result.setDataList(page.getResult());
			result.setTotal(page.getTotal());
			result.setPages(page.getPages());
		} else {
			result.setPageNo(1);
			result.setPageSize(datas.size());
			result.setDataList(datas);
			result.setTotal(datas.size());
		}

		return result;
	}

}
