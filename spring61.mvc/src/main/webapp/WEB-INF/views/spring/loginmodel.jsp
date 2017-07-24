<%@ page session="false" contentType="text/html; charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<html>
<head>
    <meta charset="utf-8" /> 
    <title>Home</title>
</head>
<body>  
    <h3>로그인 정보 </h3>
  
  <form action= "/spring/loginmodel" method="post" enctype="application/x-www-form-urlencoded">
  
  <label for = "name"> 이름 <input type="text" name = "name"/> </label>
  <label for = "phone"> 폰 <input type="text" name = "phone"/> </label>
  <input type = "submit" value="전송"/>
  </form>      
  
    <p> <a href="/" target="_blank">메인페이지로 이동</a> <br /></p>
</body>
</html>
