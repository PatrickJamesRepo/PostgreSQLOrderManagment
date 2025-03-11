<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Product Listing</title>
</head>
<body>
  <h1>Product Listing</h1>
  <c:if test="${not empty products}">
    <ul>
      <c:forEach var="product" items="${products}">
        <li>
          <a href="products/${product.productId}">${product.name}</a> - ${product.price}
        </li>
      </c:forEach>
    </ul>
  </c:if>
  <a href="login">Login</a> | <a href="register">Register</a>
</body>
</html>
