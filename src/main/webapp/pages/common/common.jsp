<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="ctp" scope="page"><%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()%></c:set>
