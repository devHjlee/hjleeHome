package com.hjlee;

import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hjlee.study.SampleController;
import com.hjlee.study.SampleRepository;
import com.hjlee.study.TestInterface;

class SampleControllerTest {


	@Autowired
	org.springframework.context.ApplicationContext applicationContext;
	
	@Autowired
	TestInterface app;

	@Test
	public void testDoSomething() {
		SampleRepository sampleRepository  = new SampleRepository();
		//TestInterface nss = new TestInterface();
		SampleController sampleController = new SampleController(sampleRepository);
		sampleController.doSomething();
	}

	@Test
	public void getBean() {
		applicationContext.getBeanDefinitionNames();
	}
}
