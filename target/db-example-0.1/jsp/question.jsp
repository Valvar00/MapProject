<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: artem
  Date: 3/18/2020
  Time: 1:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/qstyle.css" type="text/css">
    <link rel="stylesheet" href="css/qform.css" type="text/css">
    <title>Custom Checkbox</title>
</head>
<body>

<div class="container">
    <form id="contact" action="" method="post">
        <%
        String questionName = "First question";
        if(request.getAttribute("QName") != null){
            questionName = (String) request.getAttribute("QName");
        }
        %>
        <h3><%=questionName%></h3>
        <form id="test" class="input-group" action="/test" method="post">
            <%
                int numberOfAnswers = 0;
                if (request.getAttribute("NumberOfAnswers")!= null){
                    numberOfAnswers = (int) request.getAttribute("NumberOfAnswers");
                }
                for (int i = 0; i < numberOfAnswers; i++) {
                String qId = "question" + i;
                String qValue = "Q" + i;
                List<String> answerList = new ArrayList<>();
                if(request.getAttribute("AnswerList") != null) {
                    answerList = (List<String>) request.getAttribute("AnswerList");
                }
            %>
                <input type="checkbox" id=<%=qId%> name="question-1" value=<%=qValue%>>
                <label for=<%=qId%>><%=answerList.get(i)%></label>
            <%
                }
            %>
            <fieldset>
                <button name="submit" type="submit" id="contact-submit" data-submit="Sending">Submit</button>
            </fieldset>
        </form>
    </form>
</div>
</body>
</html>