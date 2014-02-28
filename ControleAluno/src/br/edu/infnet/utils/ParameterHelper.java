package br.edu.infnet.utils;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class ParameterHelper {

	public static String parameterIgnoreCase(HttpServletRequest request, String parameter)
	{
	
		Enumeration<String> e = request.getParameterNames();
		
//		parameter.toLowerCase();
		String element;
		
		while(e.hasMoreElements()) {
			
			element = e.nextElement();
			
			if( parameter.equalsIgnoreCase( element ) )
			{
				return request.getParameter(parameter);
			}
		}
		
		return null;
	}

}
