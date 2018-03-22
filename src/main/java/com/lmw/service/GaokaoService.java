package com.lmw.service;

import com.lmw.domain.Gaokao;

/**
 * 
 * <p> Description: 用户管理service </p>
 * @Author LiuMingWei
 * @Date [2018年1月17日] 
 * @Version V1.0 
 * @修改记录  
 * <pre>
 * 版本号      修改人    修改时间     修改内容描述
 * ----------------------------------------
 * V1.0  刘明伟   2018年1月17日   新建文件.
 * 
 * </pre>
 */
public interface GaokaoService {

	public void indertGaokao(Gaokao gaokao) throws Exception;
}
