package net.sjgang.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected Class<?>[] getRootConfigClasses(){
		/// TODO AUTO-generated method sub
		return null;
	}
	
	@Override 
	protected Class<?>[] getServletConfigClasses(){
		/// TODO AUTO-generated method sub
		return new Class[] {RootConfig.class};
	}
	
	@Override 
	protected String[] getServletMappings(){
		/// TODO AUTO-generated method sub
		return null;
	}
	

	
}
