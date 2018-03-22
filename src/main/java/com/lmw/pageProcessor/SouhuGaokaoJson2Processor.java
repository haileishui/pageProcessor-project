package com.lmw.pageProcessor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import com.lmw.domain.SouHu;
import com.lmw.service.SouHuService;

/**
 * @ClassName: MyCnblogsSpider
 * @author LJH
 * @date 2017年11月26日 下午4:41:40
 */
public class SouhuGaokaoJson2Processor implements PageProcessor {
	private static ApplicationContext context;

	private static SouHuService souHuService;

	public SouhuGaokaoJson2Processor() {
		context = new ClassPathXmlApplicationContext("classpath:/spring/application.xml");
		souHuService = (SouHuService) context.getBean("souHuServiceImpl");
	}

	private Site site = Site.me().setRetryTimes(10).setSleepTime(10000).setTimeOut(50000)  ;

	//site.setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36");;
	public Site getSite() {
		return site;
	}

	public static final String URL_POST = "http://learning.sohu.com/a/";
	public static final String URL_POST2 = "http://college.gaokao.com/spepoint/p.*";

	public void process(Page page) {

		if (page.getUrl().regex(URL_POST).match() ) {
			System.out.println("---------------url list---------------");//*[@id="main-news"]/div/div[3]/div[1]/div[1]/ul/li[1]/a
			List<SouHu> list ;
			List<String> urlList = new ArrayList<String>();
			try {
				list = souHuService.selectAllSouHu(null);
				if(null != list ){
					for (int i = 0; i < list.size(); i++) {
						SouHu souhu = list.get(i);
						urlList.add(souhu.getUrl());
					}
				}
//				System.out.println(urlList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			page.addTargetRequests(urlList);
		} else {
			System.out.println("---------------get body---------------");
			try {
				SouHu souHu = new SouHu();
				souHu.setUrl(page.getUrl().toString());
				String body = page.getHtml().xpath("//*[@id='mp-editor']/outerHtml()").toString();
//				System.out.println(body);
				body = body.replace("<a href=\"//www.sohu.com/?strategyid=00001 \" target=\"_blank\" title=\"点击进入搜狐首页\" id=\"backsohucom\" style=\"white-space: nowrap;\"><span class=\"backword\"><i class=\"backsohu\"></i>返回搜狐，查看更多</span></a>", "");
				body = body.replace("<p data-role=\"editor-name\">责任编辑：<span></span></p>", "");
				souHu.setBody(body);
	//			System.out.println(body); 
				souHuService.updateBody(souHu);
			} catch (Exception e) {
				System.out.println(page.getHtml().xpath("//*[@id='mp-editor']/outerHtml()"));
				e.printStackTrace();
			}
		}
	}

	/**
	 *
	 * main
	 * @方法描述: main方法启动就开始爬数据了
	 * @逻辑描述:
	 * @Author LiuMingWei
	 * @Date [2018年2月8日]
	 * @Version V1.0
	 * @param args
	 * @throws Exception 
	 * @since Ver 1.00
	 */
	public static void main(String[] args) throws Exception {
		HttpClientDownloader httpClientDownloader = new HttpClientDownloader();
		String urls = "http://learning.sohu.com/a/";
		Spider.create(new SouhuGaokaoJson2Processor()).setDownloader(httpClientDownloader).addUrl(urls).addPipeline(new ConsolePipeline()).thread(10).start();
		System.exit(1); 
//		String textString = "</table>"+ 
// "<p>编导类</p> "+ 
// "<p><img src=\"http://5b0988e595225.cdn.sohucs.com/images/20180315/a2f34520c63e4d0c83011cc0767fc391.png\"></p> "+ 
// "<p><img src=\"http://5b0988e595225.cdn.sohucs.com/images/20180315/4f10bf2e5f7d455fbe3e11d2d67b3e08.jpeg\"></p> "+ 
// "<p><img src=\"http://5b0988e595225.cdn.sohucs.com/images/20180315/6c91409a78a74f059a609307509b7477.jpeg\"></p> "+ 
// "<p><img src=\"http://5b0988e595225.cdn.sohucs.com/images/20180315/16d5dd85c98941e4bc1425dcf04741e7.png\"></p> "+ 
// "<p><img src=\"http://5b0988e595225.cdn.sohucs.com/images/20180315/1a45f61cd7c44767a293303d97bf65b0.png\"></p> "+ 
// "<p><span style=\"font-size: 16px;\">进入2018高考备战群</span></p> "+ 
// "<p>本文由“135编辑器”提供技术支持</p> "+ 
// "<p>加樱樱老师为好友</p> "+ 
// "<p><strong>验证时备注：</strong><strong><span>孩子年级</span></strong></p> "+ 
// "<p><span style=\"font-size: 16px;\">咨询电话15522642169</span></p> "+ 
// "<p><span style=\"font-size: 16px;\">排版编辑 | 暖竹</span></p> "+ 
// "<p><span style=\"font-size: 16px;\">文章来源丨</span><span style=\"font-size: 16px;\">艺考查查</span></p> "+ 
// "<p><span style=\"font-size: 16px;\">图片来源丨摄图网</span><a href=\"//www.sohu.com/?strategyid=00001 \" target=\"_blank\" title=\"点击进入搜狐首页\" id=\"backsohucom\" style=\"white-space: nowrap;\"><span class=\"backword\"><i class=\"backsohu\"></i>返回搜狐，查看更多</span></a></p> "+  
// "<p data-role=\"editor-name\">责任编辑：<span></span></p> "+ 
//"</article>";
//		int end = textString.lastIndexOf("<p");
//		textString = textString.substring(0, end);
//		System.out.println(textString);
//		int end2 = textString.lastIndexOf("<p");
//		textString = textString.substring(0, end2);
//		System.out.println(textString);
		
	}
}