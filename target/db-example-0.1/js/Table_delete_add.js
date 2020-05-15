var questions = 0;
var answers = 0;
var pq_name = "";

function addAnswer(tableID) {
    if(document.getElementById("questionId").value) {
        if (document.getElementById("questionId").value == pq_name) {
            var table = document.getElementById(tableID);
            var rowCount = table.rows.length;
            var row = table.insertRow(rowCount);
            row.setAttribute("name", "row"+answers);
            var cell1 = row.insertCell(0);
            var element1 = document.createElement("input");
            question_name = document.getElementById("questionId").value;
            pq_name = question_name;
            element1.type = "checkbox";
            element1.name = "chkbox[]";
            cell1.appendChild(element1);

            var cell2 = row.insertCell(1);
            var element = document.createElement("input");
            element.type = "hidden";
            element.name = "qid"+answers;
            element.value = questions;
            cell2.innerHTML = questions;
            cell2.appendChild(element);

            var cell3 = row.insertCell(2);
            var element = document.createElement("input");
            element.type = "hidden";
            element.name = "questions"+answers;
            element.value = question_name;
            cell3.innerHTML = question_name;
            cell3.appendChild(element);

            var cell4 = row.insertCell(3);
            var element = document.createElement("input");
            element.name = "answer"+answers;
            element.value = question_name;
            cell4.appendChild(element);

            var cell5 = row.insertCell(4);
            var element = document.createElement("input");
            element.type = "checkbox";
            element.name = "correctid"+answers;
            cell5.appendChild(element);

            answers += 1;
        }
        else{
            addQuestion(tableID);
        }
    }
}

function addQuestion(tableID) {
    if(document.getElementById("questionId").value) {
        if (pq_name !== document.getElementById("questionId").value) {
            questions = questions + 1;
            question_name = document.getElementById("questionId").value;
        }
        var table = document.getElementById(tableID);
        var rowCount = table.rows.length;
        var row = table.insertRow(rowCount);
        row.setAttribute("name", "row"+answers);


        var cell1 = row.insertCell(0);
        var element1 = document.createElement("input");
        element1.type = "checkbox";
        element1.name = "chkbox[]";
        cell1.appendChild(element1);

        var cell2 = row.insertCell(1);
        var element = document.createElement("input");
        element.type = "hidden";
        element.name = "qid"+answers;
        element.value = questions;
        cell2.innerHTML = questions;
        cell2.appendChild(element);

        var cell3 = row.insertCell(2);
        var element = document.createElement("input");
        element.type = "hidden";
        element.name = "questions"+answers;
        element.value = question_name;
        cell3.innerHTML = question_name;
        cell3.appendChild(element);

        var cell4 = row.insertCell(3);
        var element = document.createElement("input");
        element.name = "answer"+answers;
        element.value = question_name;
        cell4.appendChild(element);

        var cell5 = row.insertCell(4);
        var element = document.createElement("input");
        element.type = "checkbox";
        element.name = "correctid"+answers;
        cell5.appendChild(element);

        answers += 1;
        pq_name = document.getElementById("questionId").value;
    }
}

function deleteRow(tableID) {
    try {
        var table = document.getElementById(tableID);
        var rowCount = table.rows.length;

        for(var i=0; i<rowCount; i++) {
            var row = table.rows[i];
            var chkbox = row.cells[0].childNodes[0];
            if(null != chkbox && true == chkbox.checked) {
                table.deleteRow(i);
                rowCount--;
                i--;
            }
        }
    }catch(e) {
        alert(e);
    }
}