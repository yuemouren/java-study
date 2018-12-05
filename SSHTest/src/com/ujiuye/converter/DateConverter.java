package com.ujiuye.converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;

public class DateConverter extends StrutsTypeConverter {
	
	//֧��ת���Ķ������ڸ�ʽ��������ʱ���ʽ
    private final DateFormat[] dfs={
        new SimpleDateFormat("yyyy��MM��dd��"),
        new SimpleDateFormat("yyyy-MM-dd"),
        new SimpleDateFormat("MM/dd/yy"),
        new SimpleDateFormat("yyyy.MM.dd"),
        new SimpleDateFormat("yy.MM.dd"),
        new SimpleDateFormat("yyyy/MM/dd")
    };

	@Override
	public Object convertFromString(Map arg0, String[] values, Class arg2) {
		 String dateStr=values[0];       //��ȡ���ڵ��ַ���
	        for (int i = 0; i < dfs.length; i++) {   //��������֧�ָ�ʽ������ת��
	            try {
	                return dfs[i].parse(dateStr);
	            } catch (Exception e) {
	                continue;
	            }
	        }
	        //���������Ϻ���û��ת���ɹ�����ʾ����ת���쳣
	        throw new TypeConversionException();
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		    Date date=(Date)arg1;
	        //�����ʽ��yyyy-MM-dd
	        return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}

}
