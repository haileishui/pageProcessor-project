package com.lmw.util;

import java.util.List;

import com.lmw.dto.BaseEntity;

/**
 * 
 * <p> Description:  </p>
 * @Author LiuMingWei
 * @Date [2017年9月21日] 
 * @Version V1.0 
 * @修改记录  
 * <pre>
 * @param <T>
 * 版本号      修改人    修改时间     修改内容描述
 * ----------------------------------------
 * V1.0  刘明伟   2017年9月21日   新建文件.
 * 
 * </pre>
 */
public class PagedResult<T> extends BaseEntity {
	
	/*serialVersionUID*/
	private static final long serialVersionUID = 1L;

	private List<T> dataList;//数据
	
	private long pageNo;//当前页
	
	private long pageSize;//条数
	
	private long total;//总条数
	
	private long pages;//总页面数目

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	public long getPageNo() {
		return pageNo;
	}

	public void setPageNo(long pageNo) {
		this.pageNo = pageNo;
	}

	public long getPageSize() {
		return pageSize;
	}

	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public long getPages() {
		return pages;
	}

	public void setPages(long pages) {
		this.pages = pages;
	}
	
}
