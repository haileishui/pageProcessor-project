package com.lmw.pageProcessor;

import com.lmw.domain.Gaokao;
import com.lmw.service.serviceImpl.GaokaoServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: MyCnblogsSpider
 * @author LJH
 * @date 2017年11月26日 下午4:41:40
 */
public class SouhuGaokaoProcessor implements PageProcessor {
	private ApplicationContext context;

//	public SouhuGaokaoProcessor() {
//		context = new ClassPathXmlApplicationContext("classpath:/spring/application.xml");
//	}

//	private GaokaoServiceImpl gaokaoServiceImpl;

	private Site site = Site.me().setRetryTimes(10).setSleepTime(10000).setTimeOut(50000);

	//.setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36");;
	public Site getSite() {
		return site;
	}

	public static final String URL_POST = "http://learning.sohu.com/*";
	public static final String URL_POST2 = "http://college.gaokao.com/spepoint/p.*";

	public void process(Page page) {

		if (true ) {
			System.out.println("---------------url list---------------");//*[@id="main-news"]/div/div[3]/div[1]/div[1]/ul/li[1]/a
			List<String> listUrl = page.getHtml().xpath("//*[@data-role='news-item']/div[2]/ul/li/a/img/@src").all();
			System.out.println(listUrl);
			List<String> titleList  = page.getHtml().xpath("//*[@data-role='news-item']/div/ul/li/a/@herf").all();
			System.out.println(titleList);
			List<String> laiyuan  = page.getHtml().xpath("//*[@data-role='news-item']/div/ul/li/a/allText()").all();
			System.out.println(laiyuan);
			List<String> date  = page.getHtml().xpath("//*[@class='page_left']/ul/li/span[2]/allText()").all();
			List<String> newListUrl = new ArrayList<String>();
//			for (int i = 0; i < listUrl.size() ; i++) {
//				String url = listUrl.get(i);
//				url = url.replace("../","http://gaokao.eol.cn/");
//				url = url.replace("./","http://gaokao.eol.cn/news/");
//				System.out.println(titleList.get(i) + "|" + url + "|" + laiyuan.get(i)+"|"+date.get(i));
//				System.out.println(titleList.get(i));
//				System.out.println(laiyuan.get(i));
//				System.out.println(date.get(i));
//				System.out.println("---------------------------------");
//				newListUrl.add(url);
//			}
//			System.out.println(newListUrl);
//			page.addTargetRequests(newListUrl);
//			String nextPage = page.getHtml().xpath("//*[@id='pagenav']/a[8]/@href").toString();
//			nextPage = "http://gaokao.eol.cn/news/" + nextPage;
//			System.out.println(nextPage);
		} else {
			System.out.println("---------------get title---------------");
//			String title = page.getHtml().xpath("//*[@class='page_title']/allText()").toString();
//			String text = page.getHtml().xpath("//*[@class='TRS_Editor']/allText()").toString();
//			System.out.println("--title--:"+title);
//			System.out.println("--text--:"+text);
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
	 * @since Ver 1.00
	 */
	public static void main(String[] args) {
		HttpClientDownloader httpClientDownloader = new HttpClientDownloader();
		/** 使用代理打开该部分注释
		 //        String host = "61.136.163.245";
		 //        Integer port =8104;
		 String userName = "";
		 String passWord = "";
		 httpClientDownloader.setProxyProvider(SimpleProxyProvider.from(
		 new Proxy("61.136.163.245",8104,userName,passWord),
		 new Proxy("14.153.53.233",3128,userName,passWord),
		 new Proxy("171.34.197.71",3128,userName,passWord),
		 new Proxy("219.149.46.151",3129,userName,passWord)
		 ));
		 Spider.setDownloader(httpClientDownloader);*/
		String url = "http://learning.sohu.com/16";
		List<String> urlList = new ArrayList<String>();
//		for (int i = 1; i < 25 ; i++) {
//			urlList.add( "http://gaokao.eol.cn/news/index_"+i+".shtml");
//		}
		urlList.add(url);
//		System.out.println(urlList);
		Spider.create(new SouhuGaokaoProcessor()).setDownloader(httpClientDownloader).addUrl(url).addPipeline(new ConsolePipeline()).thread(10).run();
	}
}