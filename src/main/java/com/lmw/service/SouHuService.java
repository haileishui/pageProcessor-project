package com.lmw.service;

import java.util.List;

import com.lmw.domain.SouHu;

public interface SouHuService {

	public List<SouHu> selectAllSouHu(Integer id) throws Exception ;
	
	public Integer selectSouHuById(Integer id) throws Exception ;
	
	public void insertSouHu(SouHu souHu) throws Exception;
	
	public void updateBody(SouHu souHu) throws Exception;
	
}
