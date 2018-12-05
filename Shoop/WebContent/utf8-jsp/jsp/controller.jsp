<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.ujiuye.util.ActionEnterExt" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%

    request.setCharacterEncoding( "utf-8" );
	response.setHeader("Content-Type" , "text/html");	
	String rootPath = application.getRealPath( "/" );
	ActionEnterExt ac = new ActionEnterExt( request, rootPath );
	ac.configUploadPath();
	out.write(ac.exec() );

%>