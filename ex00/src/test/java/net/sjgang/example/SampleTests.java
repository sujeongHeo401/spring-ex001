package net.sjgang.example;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jdk.internal.org.jline.utils.Log;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import net.sjgang.config.RootConfig;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=RootConfig.class)
@Log4j

public class SampleTests {
	
	
	@Autowired
	private Restaurant restaurant;
	
	@Test
	public void testExist() {
		System.out.println("test1-----------" + restaurant);
		Log.info("test1--------------------");
		Log.info(restaurant);
//		System.out.println("test1------------------");
//		log.info("test1111111111111-----------------");
//		assertNotNull(restaurant);
//		
//		log.info(restaurant);
//		log.info("---------------------");
//		log.info(restaurant.getClass());
	}
}
