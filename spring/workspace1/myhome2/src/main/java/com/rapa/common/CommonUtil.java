package com.rapa.common;

public class CommonUtil {
	public static String nullToValue(String obj, String value)
	{
		if(obj == null || obj.equals(""))
		{
			return value;
		}
		else
		{
			return obj;
		}
	}
	
	public static String nullToValue(String obj)
	{
		if(obj == null || obj.equals(""))
		{
			return "0";
		}
		else
		{
			return obj;
		}
	}
}
