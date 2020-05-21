<%@ page import="java.util.ArrayList" %>
<%@ page import="pl.valvar.models.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Login And Registration Form</title>
    <link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
<div class="hero">
    <div class="form-box">
        <h1 name="title"></h1>
        <div class="button-box">
            <div id="btn"></div>
            <button type="button" class="toggle-btn" onclick="login()">Log In</button>
            <button type="button" class="toggle-btn" onclick="register()">Register</button>
        </div>
        <div class="social-icons">
            <img src="css/img/fb.png">
            <img src="css/img/tw.png">
            <img src="css/img/gp.png">
        </div>
        <form id="login" class="input-group" action="/login_main" method="post">
            <%String misstake = (String) request.getAttribute("inc");
            String misstake2 = (String) request.getAttribute("reg");
            String nick = (String) request.getAttribute("nick");
                System.out.println(nick);
                if(misstake.equals("1")){
            %>
            <center>Incorrect name or password</center>
            <%};
                if(misstake2.equals("2")){
            %>
            <center>User with such data already exist</center>
            <%};
            %>
            <input type="text" class="input-field" placeholder="Username" required name="name">
            <input type="password" class="input-field" placeholder="Enter Password" required name="password">
            <input type="checkbox" class="check-box" name="RemPass" ><span>Remember Password</span>
            <button type="submit" class="submit-btn">Login</button>
        </form>
        <form id="register" class="input-group" action="/signUp_main" method="post">
            <input type="text" class="input-field" placeholder="Username" required name="name">
            <input type="email" class="input-field" placeholder="Email" required name="email">
            <input type="password" class="input-field" placeholder="Enter Password" required name="password">
            <input type="checkbox" class="check-box"><span>I agree to something</span>
            <button type="submit" class="submit-btn">Register</button>
        </form>
    </div>

</div>
<script src="js/login.js"></script>
</body>
</html>