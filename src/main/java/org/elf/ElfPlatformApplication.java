package org.elf;

import java.lang.annotation.Annotation;

import javax.ws.rs.Path;
import javax.ws.rs.ext.Provider;

import org.elf.config.ExceptionMappingResource;
import org.elf.config.JerseyConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ElfPlatformApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		var application = new ElfPlatformApplication()
				.configure(new SpringApplicationBuilder(ElfPlatformApplication.class)).run(args);
		register(application,Path.class);
		register(application,Provider.class);
	}

	public static void register(ConfigurableApplicationContext application,Class<? extends Annotation> annotationType) {
		var jerseyConfig = application.getBean(JerseyConfig.class);
		var pathBean = application.getBeanNamesForAnnotation(annotationType);
		for(var beanName : pathBean) {
			jerseyConfig.register(application.getBean(beanName));
		}
		jerseyConfig.register(ExceptionMappingResource.class);
	}
}
