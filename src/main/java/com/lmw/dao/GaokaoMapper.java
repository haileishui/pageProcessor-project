package com.lmw.dao;

import com.lmw.domain.Gaokao;

public interface GaokaoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Gaokao record);

    int insertSelective(Gaokao record);

    Gaokao selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Gaokao record);

    int updateByPrimaryKey(Gaokao record);
}