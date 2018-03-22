package com.lmw.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmw.dao.GaokaoMapper;
import com.lmw.domain.Gaokao;
import com.lmw.service.GaokaoService;

@Service
public class GaokaoServiceImpl implements GaokaoService {
	//	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	GaokaoMapper gaokaoMapper;
	
	@Override
	public void indertGaokao(Gaokao gaokao) throws Exception {
			gaokaoMapper.insert(gaokao);
	}

}
