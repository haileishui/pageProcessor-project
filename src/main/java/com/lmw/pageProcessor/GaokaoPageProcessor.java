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
 * 高考分数线爬取
 */
public class GaokaoPageProcessor implements PageProcessor {
	private ApplicationContext context;

	public GaokaoPageProcessor() {
		context = new ClassPathXmlApplicationContext("classpath:/spring/application.xml");
	}

	private GaokaoServiceImpl gaokaoServiceImpl;

	private Site site = Site.me().setRetryTimes(10).setSleepTime(10000).setTimeOut(50000);

	//.setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36");;
	public Site getSite() {
		return site;
	}

	public static final String URL_POST = "http://college.gaokao.com/spepoint/a.*/p.*";
	public static final String URL_POST2 = "http://college.gaokao.com/spepoint/p.*";

	public void process(Page page) {

		if (true) {//分量爬所有的页面都是datalist，不爬标题所有省市数据  。全量爬数据使用这个if条件,page.getUrl().regex(URL_POST).match() || page.getUrl().regex(URL_POST2).match()
			System.out.println("---------------data list---------------");
			List<String> urlList = new ArrayList<String>();
			urlList.add(page.getHtml().xpath("//*[@id='wrapper']/div[4]/ul/li[3]/a/@href").toString());//如果有分页将URL添加到请求中
			page.addTargetRequests(urlList);
			List<String> tablesTr = page.getHtml().xpath("//*[@id='wrapper']/div/table/tbody/tr/allText()").all();
			for (int i = 1; i < tablesTr.size() + 1; i++) {
				//                page.putField("line"+i,page.getHtml().xpath("//*[@id='wrapper']/div/table/tbody/tr["+i+"]/allText()").toString());
				String zhuanyemingcheng = page.getHtml().xpath("//*[@id='wrapper']/div/table/tbody/tr[" + i + "]/td[1]/allText()").toString();
				String gaoxiaomingcheng = page.getHtml().xpath("//*[@id='wrapper']/div/table/tbody/tr[" + i + "]/td[2]/allText()").toString();
				String pingjunfen = page.getHtml().xpath("//*[@id='wrapper']/div/table/tbody/tr[" + i + "]/td[3]/allText()").toString();
				String zuigaofen = page.getHtml().xpath("//*[@id='wrapper']/div/table/tbody/tr[" + i + "]/td[4]/allText()").toString();
				String kaoshengdiqu = page.getHtml().xpath("//*[@id='wrapper']/div/table/tbody/tr[" + i + "]/td[5]/allText()").toString();
				String kebie = page.getHtml().xpath("//*[@id='wrapper']/div/table/tbody/tr[" + i + "]/td[6]/allText()").toString();
				String nianfen = page.getHtml().xpath("//*[@id='wrapper']/div/table/tbody/tr[" + i + "]/td[7]/allText()").toString();
				String pici = page.getHtml().xpath("//*[@id='wrapper']/div/table/tbody/tr[" + i + "]/td[8]/allText()").toString();
				String zhuanyeduibi = page.getHtml().xpath("//*[@id='wrapper']/div/table/tbody/tr[" + i + "]/td[9]/allText()").toString();
				if (null != zhuanyemingcheng && null != gaoxiaomingcheng) {
					Gaokao gaokao = new Gaokao();
					gaokao.setZhuanyemingcheng(zhuanyemingcheng);
					gaokao.setGaoxiaomingcheng(gaoxiaomingcheng);
					gaokao.setPingjunfen(pingjunfen);
					gaokao.setZuigaofen(zuigaofen);
					gaokao.setKaoshengdiqu(kaoshengdiqu);
					gaokao.setKebie(kebie);
					gaokao.setNianfen(nianfen);
					gaokao.setPici(pici);
					gaokao.setZhuanyeduibi(zhuanyeduibi);
					gaokaoServiceImpl = (GaokaoServiceImpl) context.getBean("gaokaoServiceImpl");
					try {
						gaokaoServiceImpl.indertGaokao(gaokao);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			System.out.println("---------------get title---------------");
			List<String> titleUrls = page.getHtml().xpath("//div[@class='menufix']").links().regex("http://college.gaokao.com/spepoint/a.*/").all();
			List<String> finalUrl = new ArrayList<String>();
			for (String url : titleUrls) {
				url += "p1";
				finalUrl.add(url);
			}
			page.addTargetRequests(finalUrl);

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
		String url = "http://college.gaokao.com/spepoint/a3/p1";//a+*代表省市，P+*代表页数。。！！！！！！！全量爬使用 http://college.gaokao.com/spepoint/ ！！！！URL
		Spider.create(new GaokaoPageProcessor()).setDownloader(httpClientDownloader).addUrl(url).addPipeline(new ConsolePipeline()).thread(10).run();
		//           页面的所有URL
		//          [http://college.gaokao.com/spepoint/a1/p1, http://college.gaokao.com/spepoint/a2/p1, http://college.gaokao.com/spepoint/a3/p1, http://college.gaokao.com/spepoint/a4/p1, http://college.gaokao.com/spepoint/a5/p1, http://college.gaokao.com/spepoint/a6/p1, http://college.gaokao.com/spepoint/a7/p1, http://college.gaokao.com/spepoint/a8/p1, http://college.gaokao.com/spepoint/a9/p1, http://college.gaokao.com/spepoint/a10/p1, http://college.gaokao.com/spepoint/a11/p1, http://college.gaokao.com/spepoint/a12/p1, http://college.gaokao.com/spepoint/a13/p1, http://college.gaokao.com/spepoint/a14/p1, http://college.gaokao.com/spepoint/a15/p1, http://college.gaokao.com/spepoint/a16/p1, http://college.gaokao.com/spepoint/a17/p1, http://college.gaokao.com/spepoint/a18/p1, http://college.gaokao.com/spepoint/a19/p1, http://college.gaokao.com/spepoint/a20/p1, http://college.gaokao.com/spepoint/a21/p1, http://college.gaokao.com/spepoint/a22/p1, http://college.gaokao.com/spepoint/a23/p1, http://college.gaokao.com/spepoint/a24/p1, http://college.gaokao.com/spepoint/a25/p1, http://college.gaokao.com/spepoint/a26/p1, http://college.gaokao.com/spepoint/a27/p1, http://college.gaokao.com/spepoint/a28/p1, http://college.gaokao.com/spepoint/a29/p1, http://college.gaokao.com/spepoint/a30/p1, http://college.gaokao.com/spepoint/a31/p1, http://college.gaokao.com/spepoint/a33/p1, http://college.gaokao.com/spepoint/a38/p1, http://college.gaokao.com/spepoint/a39/p1]

	}
}