<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Register</title>
</head>
<body>
  <h1>User Registration</h1>
  <form action="register" method="post">
    <label>Username:</label>
    <input type="text" name="username" required/><br/>
    <label>Password:</label>
    <input type="password" name="password" required/><br/>
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
    <button type="submit">Register</button>
  </form>
  <a href="login">Already have an account? Login</a>
</body>
</html>
