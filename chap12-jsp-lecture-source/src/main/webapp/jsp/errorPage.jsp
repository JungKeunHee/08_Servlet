<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2024-11-04
  Time: 오후 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
    isErrorPage="true"
%>
<html>
<head>
    <title>에러 페이지</title>
</head>
<body>
  <%
    // 우리가 2번 파일에서 errorPage 로 등록 해뒀다.
    // 하지만 Error 페이지로 사용하기 위해서는
    // isErrorPage="true" 설정을 반드시 해주어야
    // exception 관련 정보를 사용할 수 있게 된다
    String exceptionType = exception.getClass().getName();
    String exceptionMsg = exception.getMessage();
  %>

  <h1><%=exceptionType%></h1>
  <h1><%=exceptionMsg%></h1>
</body>
</html>
