package com.lmw.baseTest;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * <p> Description:  测试基类</p>
 * @Author LiuMingWei
 * @Date [2017年9月21日] 
 * @Version V1.0 
 * @修改记录  
 * <pre>
 * 版本号      修改人    修改时间     修改内容描述
 * ----------------------------------------
 * V1.0  刘明伟   2017年9月21日   新建文件.
 * 
 * </pre>
 */
//指定bean注入的配置文件
@ContextConfiguration(locations = { "classpath*:spring/application.xml" })
//使用标准的JUnit @RunWith注释来告诉JUnit使用Spring TestRunner
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class SpringTestCase extends AbstractJUnit4SpringContextTests{
	protected Logger logger = LoggerFactory.getLogger(getClass());
}
