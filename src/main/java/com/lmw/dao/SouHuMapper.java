package com.lmw.dao;

import java.util.List;

import com.lmw.domain.SouHu;

public interface SouHuMapper {

	int insert(SouHu Souhu);
	
	List<SouHu> selectAllSouHu(Integer id);
	
	int selectByPrimaryKey(Integer id);
	
	void updateBody(SouHu souhu);
}