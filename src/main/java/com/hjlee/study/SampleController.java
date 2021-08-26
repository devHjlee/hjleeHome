package com.hjlee.study;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

public class SampleController {
	
	SampleRepository sampleRepository;

	//Autowired
	public SampleController(SampleRepository sampleRepository) {
		this.sampleRepository = sampleRepository;
	}
	
	public void doSomething() {
		sampleRepository.save();
	}
	
	
}
