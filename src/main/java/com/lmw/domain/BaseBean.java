package com.lmw.domain;

import java.io.Serializable;

/**
 * 
 * <p> Description:  公共bean</p>
 * @Author LiuMingWei
 * @Date [2017年10月26日] 
 * @Version V1.0 
 * @修改记录  
 * <pre>
 * 版本号      修改人    修改时间     修改内容描述
 * ----------------------------------------
 * V1.0  刘明伟   2017年10月26日   新建文件.
 * 
 * </pre>
 */
public class BaseBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//	分页参数
	public Integer pageNumber;
	public Integer pageSize;

	public Integer getPageNumber() {
		return pageNumber == null ? 1 : pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getPageSize() {
		return pageSize == null ? 10 : pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "BaseBean [pageNumber=" + pageNumber + ", pageSize=" + pageSize + "]";
	}

}
