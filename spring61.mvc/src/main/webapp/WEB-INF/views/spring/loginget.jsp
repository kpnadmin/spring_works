<%@ page session="false" contentType="text/html; charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<html>
<head>
    <meta charset="utf-8" /> 
    <title>Home</title>
</head>
<body>  
  <form method = "post" action="/spring/login" enctype="application/x-www-form-urlencoded">
  <label for = "name"> ID : <input type="text" name = "id" value= "${id}"> </label>
  <label for = "pw"> PW : <input type="password" name = "pw"> </label>
  <input type = "submit" value ="전송">
  
  </form>
  
  
        
</body>
</html>
