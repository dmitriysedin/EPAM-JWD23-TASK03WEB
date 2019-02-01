<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Index</title>
</head>
<body>

	<form action="ServletForParsers" method="post">
		<input type="submit" name="parser" value="SAX"> 
		<input type="submit" name="parser" value="STAX"> 
		<input type="submit" name="parser" value="DOM">
	</form>

</body>
</html>