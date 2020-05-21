<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="../css/style.css" type="text/css">
</head>
<body>
<div class="hero">
    <div class="form-box1">
        <%
        String uni = (String) request.getAttribute("university");
        String city = (String) request.getAttribute("city");
        String kilo = (String) request.getAttribute("kilometers");
        String email = (String) request.getAttribute("email");
        String nickname = (String) request.getAttribute("nickname");
        String error = (String) request.getAttribute("reg");
            System.out.println(error);
            System.out.println(session.getAttribute("user"));
        %>
        <h1>Your Profile</h1>
        <form id="login" class="input-group1 grp4" action="/profile" method="post">
            <label>Username</label>
            <input type="text" class="input-field" name="name" value=<%=nickname%>>
            <label>Email</label>
            <p class='pad'><%=email%></p>
            <label>Password</label>
            <p class='pad'>********</p>
            <label class='underbut'>University</label>
            <input type="text" class="input-field" name="uni" value=<%=uni%>>
            <label>City</label>
            <input type="text" class="input-field" name="city" value=<%=city%>>
            <label>Kilometers traveled</label>
            <p class='pad'><%=kilo%></p>
            <button type="submit" class="submit-btn">Save Changes</button>
        </form>
    </div>

</div>
</body>
</html>