<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Index</title>
</head>
<body>

	<form action="ServletForParsers" method="post">
		<input type="text" name="fileName" value="enter file path"> 
		<input type="submit" name="command" value="SAX"> 
		<input type="submit" name="command" value="STAX"> 
		<input type="submit" name="command" value="DOM">
	</form>

</body>
</html>