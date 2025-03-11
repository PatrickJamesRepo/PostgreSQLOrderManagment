<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Place Order</title>
</head>
<body>
  <h1>Order Form for ${product.name}</h1>
  <c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
  </c:if>
  <form action="../order/place" method="post">
    <input type="hidden" name="productId" value="${product.productId}" />
    <label>Quantity:</label>
    <input type="number" name="quantity" min="1" required/>
    <br/><br/>
    <label>First Name:</label>
    <input type="text" name="firstName" required/><br/>
    <label>Last Name:</label>
    <input type="text" name="lastName" required/><br/>
    <label>City:</label>
    <input type="text" name="city" required/><br/>
    <label>Street:</label>
    <input type="text" name="street" required/><br/>
    <label>Landmark:</label>
    <input type="text" name="landmark"/><br/>
    <label>State:</label>
    <input type="text" name="state" required/><br/>
    <label>Pin:</label>
    <input type="text" name="pin" required/><br/>
    <label>Phone Number:</label>
    <input type="text" name="phoneNumber" required/><br/><br/>
    <button type="submit">Place Order</button>
  </form>
  <br/>
  <a href="../products">Back to Products</a>
</body>
</html>
