package com.ujiuye.converter;

import org.springframework.core.convert.converter.Converter;

public class StringTrimConverter implements Converter<String,String> {

	@Override
	public String convert(String arg0) {
		
		return arg0.trim();
	}

}
