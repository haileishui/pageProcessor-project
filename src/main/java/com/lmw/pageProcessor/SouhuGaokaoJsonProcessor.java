package com.lmw.pageProcessor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.JsonPathSelector;

import com.alibaba.fastjson.JSONObject;
import com.lmw.domain.SouHu;
import com.lmw.service.SouHuService;
import com.lmw.service.serviceImpl.GaokaoServiceImpl;

public class SouhuGaokaoJsonProcessor implements PageProcessor {

	private ApplicationContext context;

	public SouhuGaokaoJsonProcessor() {
		context = new ClassPathXmlApplicationContext("classpath:/spring/application.xml");
	}

	private SouHuService souHuService;

	private Site site = Site.me();

	private static final String ARITICALE_URL = "http://angularjs\\.cn/api/article/\\w+";

	private static final String LIST_URL = "http://angularjs\\.cn/api/article/latest.*";

	@Override
	public void process(Page page) {
		if (true) {//page.getUrl().regex(LIST_URL).match()
			List<String> jsonString = new JsonPathSelector("$.*").selectList(page.getRawText());
			if (null != jsonString && jsonString.size() > 0) {
				souHuService = (SouHuService) context.getBean("souHuServiceImpl");
				for (int i = 0; i < jsonString.size(); i++) {
					String jsonObj = jsonString.get(i);
					SouHu souhu = JSONObject.parseObject(jsonObj, SouHu.class);
					Date date = new Date(souhu.getPublicTime());
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					souhu.setDate(format.format(date).toString());
					souhu.setFocus(souhu.getFocus().replace("//", ""));
					souhu.setUrl("http://www.sohu.com/a/" + souhu.getId() + "_" + souhu.getAuthorId());
					System.out.println(souhu);
					try {
						Integer result = souHuService.selectSouHuById(souhu.getId().intValue());
						if (result <= 0) {
							souHuService.insertSouHu(souhu);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

		}
	}

	@Override
	public Site getSite() {
		return site;
	}

	public static void main(String[] args) {
		Spider.create(new SouhuGaokaoJsonProcessor()).addUrl("http://v2.sohu.com/public-api/feed?scene=CATEGORY&sceneId=16&page=1&size=100").run();
	}
}