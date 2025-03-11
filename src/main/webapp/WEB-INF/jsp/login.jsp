<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login</title>
</head>
<body>
  <h1>Login</h1>
  <form action="login" method="post">
    <label>Username:</label>
    <input type="text" name="username" required/><br/>
    <label>Password:</label>
    <input type="password" name="password" required/><br/><br/>
    <button type="submit">Login</button>
  </form>
  <a href="register">Register</a>
</body>
</html>
