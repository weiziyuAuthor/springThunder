package com.u.spring.web.servlet;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.context.support.StaticMessageSource;
import org.springframework.ui.context.Theme;
import org.springframework.ui.context.ThemeSource;
import org.springframework.ui.context.support.SimpleTheme;
import org.springframework.ui.context.support.UiApplicationContextUtils;
import org.springframework.web.context.support.StaticWebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.LastModified;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.theme.AbstractThemeResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.XmlViewResolver;


public class SimpleWebApplicationContext extends StaticWebApplicationContext {


	@Override
	public void refresh() throws BeansException {
		MutablePropertyValues pvs = new MutablePropertyValues();
		pvs.add("commandClass", "org.springframework.tests.sample.beans.TestBean");
		pvs.add("formView", "form");

		registerSingleton("/locale.do", LocaleChecker.class);

		addMessage("test", Locale.ENGLISH, "test message");
		addMessage("test", Locale.CANADA, "Canadian & test message");
		addMessage("testArgs", Locale.ENGLISH, "test {0} message {1}");
		addMessage("testArgsFormat", Locale.ENGLISH, "test {0} message {1,number,#.##} X");

		registerSingleton(UiApplicationContextUtils.THEME_SOURCE_BEAN_NAME, DummyThemeSource.class);

		registerSingleton("handlerMapping", BeanNameUrlHandlerMapping.class);
		registerSingleton("viewResolver", InternalResourceViewResolver.class);

		pvs = new MutablePropertyValues();
		pvs.add("location", "org/springframework/web/context/WEB-INF/sessionContext.xml");
		registerSingleton("viewResolver2", XmlViewResolver.class, pvs);

		super.refresh();
	}


	public static class LocaleChecker implements Controller, LastModified {

		public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			if (!(RequestContextUtils.getWebApplicationContext(request) instanceof SimpleWebApplicationContext)) {
				throw new ServletException("Incorrect WebApplicationContext");
			}
			if (!(RequestContextUtils.getLocaleResolver(request) instanceof AcceptHeaderLocaleResolver)) {
				throw new ServletException("Incorrect LocaleResolver");
			}
			if (!Locale.CANADA.equals(RequestContextUtils.getLocale(request))) {
				throw new ServletException("Incorrect Locale");
			}
			return null;
		}

		public long getLastModified(HttpServletRequest request) {
			return 98;
		}
	}


	public static class DummyThemeSource implements ThemeSource {

		private StaticMessageSource messageSource;

		public DummyThemeSource() {
			this.messageSource = new StaticMessageSource();
			this.messageSource.addMessage("themetest", Locale.ENGLISH, "theme test message");
			this.messageSource.addMessage("themetestArgs", Locale.ENGLISH, "theme test message {0}");
		}

		public Theme getTheme(String themeName) {
			if (AbstractThemeResolver.ORIGINAL_DEFAULT_THEME_NAME.equals(themeName)) {
				return new SimpleTheme(AbstractThemeResolver.ORIGINAL_DEFAULT_THEME_NAME, this.messageSource);
			}
			else {
				return null;
			}
		}
	}


}
