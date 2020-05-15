<%@ page import="ru.ivmiit.models.Test" %><%--
  Created by IntelliJ IDEA.
  User: artem
  Date: 4/4/2020
  Time: 10:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.lang.String" %>
<html>
<head>
    <TITLE> Add/Remove dynamic rows in HTML table </TITLE>
    <script type="text/javascript" src="/js/Table_delete_add.js"></script>
    <link rel="stylesheet" href="css/table_style.css" type="text/css">
</head>
<body>
    <input type="text" placeholder="Question" id="questionId" required>
    <input type="submit" value="Add Answer" onclick="addAnswer('dataTable')" />
    <input type="submit" value="Add Question" onclick="addQuestion('dataTable')" />
    <input type="button" value="Delete Row" onclick="deleteRow('dataTable')" />
    <form id="createTest" class="input-group" action="create_test" method="post">
        <table id="dataTable" border="1">
            <tr>
                <th>Delete Mark</th>
                <th>Id of question</th>
                <th>Question</th>
                <th>Answer</th>
                <th>Correctness</th>
            </tr>
        </table>
        <button type="submit" class="submit-btn">Register</button>
    </form>
</body>
</html>