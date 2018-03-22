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

import com.lmw.domain.Gaokao;
import com.lmw.service.serviceImpl.GaokaoServiceImpl;

/**
 * @ClassName: MyCnblogsSpider
 * @author LJH
 * @date 2017年11月26日 下午4:41:40
 */
public class GaokaoZiXunProcessor implements PageProcessor {
	private ApplicationContext context;

	public GaokaoZiXunProcessor() {
		context = new ClassPathXmlApplicationContext("classpath:/spring/application.xml");
	}

	private GaokaoServiceImpl gaokaoServiceImpl;

	private Site site = Site.me().setRetryTimes(10).setSleepTime(10000).setTimeOut(50000);

	//.setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36");;
	public Site getSite() {
		return site;
	}

	public static final String URL_POST = "http://gaokao.eol.cn/.*";
	public static final String URL_POST2 = "http://college.gaokao.com/spepoint/p.*";

	public void process(Page page) {

		if (page.getUrl().regex(URL_POST).match() ) {//分量爬所有的页面都是datalist，不爬标题所有省市数据  。全量爬数据使用这个if条件,page.getUrl().regex(URL_POST).match() || page.getUrl().regex(URL_POST2).match()
			System.out.println("---------------url list---------------");
			List<String> listUrl = page.getHtml().xpath("//*[@class='page_left']/ul/li/a/@href").all();
			List<String> titleList  = page.getHtml().xpath("//*[@class='page_left']/ul/li/a/allText()").all();
			List<String> laiyuan  = page.getHtml().xpath("//*[@class='mly']/allText()").all();
			List<String> date  = page.getHtml().xpath("//*[@class='page_left']/ul/li/span[2]/allText()").all();
			List<String> newListUrl = new ArrayList<String>();
			for (int i = 0; i < listUrl.size() ; i++) {
				String url = listUrl.get(i);
					url = url.replace("../","http://gaokao.eol.cn/");
					url = url.replace("./","http://gaokao.eol.cn/news/");
				System.out.println(titleList.get(i) + "|" + url + "|" + laiyuan.get(i)+"|"+date.get(i));
//				System.out.println(titleList.get(i));
//				System.out.println(laiyuan.get(i));
//				System.out.println(date.get(i));
//				System.out.println("---------------------------------");
//				newListUrl.add(url);
			}
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
		String url = "http://gaokao.eol.cn/zhengce/baokao/index.shtml";//a+*代表省市，P+*代表页数。。！！！！！！！全量爬使用 http://college.gaokao.com/spepoint/ ！！！！URL
		List<String> urlList = new ArrayList<String>();
		for (int i = 1; i < 25 ; i++) {
			urlList.add( "http://gaokao.eol.cn/zhengce/baokao/index_"+i+".shtml");
		}
		urlList.add(url);
		System.out.println(urlList);
		Spider.create(new GaokaoZiXunProcessor()).setDownloader(httpClientDownloader).startUrls(urlList).addPipeline(new ConsolePipeline()).thread(10).run();
		//           页面的所有URL
		//          [http://college.gaokao.com/spepoint/a1/p1, http://college.gaokao.com/spepoint/a2/p1, http://college.gaokao.com/spepoint/a3/p1, http://college.gaokao.com/spepoint/a4/p1, http://college.gaokao.com/spepoint/a5/p1, http://college.gaokao.com/spepoint/a6/p1, http://college.gaokao.com/spepoint/a7/p1, http://college.gaokao.com/spepoint/a8/p1, http://college.gaokao.com/spepoint/a9/p1, http://college.gaokao.com/spepoint/a10/p1, http://college.gaokao.com/spepoint/a11/p1, http://college.gaokao.com/spepoint/a12/p1, http://college.gaokao.com/spepoint/a13/p1, http://college.gaokao.com/spepoint/a14/p1, http://college.gaokao.com/spepoint/a15/p1, http://college.gaokao.com/spepoint/a16/p1, http://college.gaokao.com/spepoint/a17/p1, http://college.gaokao.com/spepoint/a18/p1, http://college.gaokao.com/spepoint/a19/p1, http://college.gaokao.com/spepoint/a20/p1, http://college.gaokao.com/spepoint/a21/p1, http://college.gaokao.com/spepoint/a22/p1, http://college.gaokao.com/spepoint/a23/p1, http://college.gaokao.com/spepoint/a24/p1, http://college.gaokao.com/spepoint/a25/p1, http://college.gaokao.com/spepoint/a26/p1, http://college.gaokao.com/spepoint/a27/p1, http://college.gaokao.com/spepoint/a28/p1, http://college.gaokao.com/spepoint/a29/p1, http://college.gaokao.com/spepoint/a30/p1, http://college.gaokao.com/spepoint/a31/p1, http://college.gaokao.com/spepoint/a33/p1, http://college.gaokao.com/spepoint/a38/p1, http://college.gaokao.com/spepoint/a39/p1]

	}
}