<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Menu</title>
</head>
<body>

<table cellspacing="2" border="1" cellpadding="5" bordercolor="gray">
<tr><th>Меню</th><th>Ассортимент</th><th>Название блюда</th>
<th>Описание блюда</th><th>Порция</th><th>Цена</th></tr>
<c:forEach items="${menus}" var="menu">
	<c:forEach items="${menu.assortments}" var="assortment">  			
           				<c:forEach items="${assortment.dishes}" var="dish">
           					    <tr>
           					    <td><c:out value="${menu.menuName}"></c:out></td>
           						<td><c:out value="${assortment.assortmentName}"></c:out></td>
           						<td><c:out value="${dish.dishName}"></c:out></td>
           							<td><c:out value="${dish.dishExtraDescription}"></c:out><br>
           							<c:forEach items="${dish.specificationOfDishes}" var="specification">
									<c:out value="${specification.dishDescription}"></c:out><br>
           							</c:forEach></td>
           							<td><c:forEach items="${dish.specificationOfDishes}" var="specification">
									<c:out value="${specification.dishPortion}"></c:out><br>
           							</c:forEach></td>
           							<td><c:forEach items="${dish.specificationOfDishes}" var="specification">
									<c:out value="${specification.dishPrice}"></c:out><br>
           							</c:forEach></td>
           						</tr>
           				</c:forEach>
           		</c:forEach>
      </c:forEach>
</table>
</body>
</html>