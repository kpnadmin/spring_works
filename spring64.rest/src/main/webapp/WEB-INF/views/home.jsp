<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<p><a href="/rest/currentversion"               target="_blank"  >/rest/currentversion</a></p>
<p><a href="/rest/Login?id=test1id&pw=test1pw"  target="_blank" >/rest/Login</a></p>
<p><a href="/rest/Login?id=test2id&pw=test2pw"  target="_blank" >/rest/Login Not Exists</a></p>
<p><a href="/rest/personlist?name=test"         target="_blank"     >/rest/personlist</a></p>
<p><a href="/rest/insertPerson?id=test33id&pw=test33pw&name=test33id&email=test33@email">/rest/insertperson</a></p>
</body>
</html>
