package com.lmw.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmw.dao.SouHuMapper;
import com.lmw.domain.SouHu;
import com.lmw.service.SouHuService;

@Service
public class SouHuServiceImpl implements SouHuService {
	//	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	SouHuMapper souHuMapper;
	
	@Override
	public Integer selectSouHuById(Integer id) throws Exception {
		return souHuMapper.selectByPrimaryKey(id);
	}

	@Override
	public void insertSouHu(SouHu souHu) throws Exception {
		souHuMapper.insert(souHu);
	}

	@Override
	public List<SouHu> selectAllSouHu(Integer id) throws Exception {
		return souHuMapper.selectAllSouHu(id);
	}

	@Override
	public void updateBody(SouHu souHu) throws Exception {
		souHuMapper.updateBody(souHu);
	}
}
