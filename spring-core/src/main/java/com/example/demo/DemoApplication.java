package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.scheduling.annotation.EnableAsync;
import sample.SampleService;

@SpringBootApplication
@PropertySource("classpath:/app.properties")
@EnableAsync
public class DemoApplication {

//	@Autowired
//	SampleService sampleService;

	public static void main(String[] args) {
		/*
			컴포넌트 스캔으로 빈 등록
		 */
//		SpringApplication.run(DemoApplication.class, args);



		/*
			Application 구동 타임에 성능상에 이점이 있는 펑션을 사용한 빈 등록
		 */
		var app = new SpringApplication(DemoApplication.class);
		app.addInitializers(new ApplicationContextInitializer<GenericApplicationContext>() {
			@Override
			public void initialize(GenericApplicationContext ctx) {
				// 컴포넌트 스캔 밖의 범위 빈 등록 가능
				ctx.registerBean(SampleService.class);
				ctx.registerBean(ApplicationRunner.class, () -> args1 -> System.out.println("functional bean definition"));

			}
		});
		app.run(args);



	}

	@Bean
	public MessageSource messageSource(){
		var messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:/messages");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(3);
		return messageSource;
	}

}
