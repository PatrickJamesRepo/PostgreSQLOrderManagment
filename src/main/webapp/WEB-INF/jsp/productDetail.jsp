<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Product Detail</title>
</head>
<body>
  <h1>${product.name}</h1>
  <p>${product.description}</p>
  <p>Price: ${product.price}</p>
  <p>Available: ${product.quantityAvailable}</p>
  <a href="../order/${product.productId}">Order Now</a>
  <br/><br/>
  <a href="../products">Back to Products</a>
</body>
</html>
