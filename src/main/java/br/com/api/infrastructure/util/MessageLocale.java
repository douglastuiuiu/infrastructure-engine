package br.com.api.infrastructure.util;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author douglasog87@gmail.com
 * @since 29/12/2016
 */
@Component
public class MessageLocale {
	
	@Autowired
	private MessageSource messageSource;
	
	public String getMessage(String messageKey) {
		return messageSource.getMessage(messageKey, null, LocaleContextHolder.getLocale());
	}
	
	public String getMessage(String messageKey, String... args) {
		return messageSource.getMessage(messageKey, args, LocaleContextHolder.getLocale());
	}
	
	public String getMessage(String messageKey, String[] args, Locale locale) {
		return messageSource.getMessage(messageKey, args, locale);
	}
}
