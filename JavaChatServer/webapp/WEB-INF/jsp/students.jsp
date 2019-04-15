<%@ page import="domain.Student" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Student Record</title>
</head>
<body>
<%
    if (request.getAttribute("studentRecord") != null) {
        Student student = (Student) request.getAttribute("studentRecord");
%>

<h1>Student Record</h1>
<div>ID: <%= student.getId()%></div>
<div>First Name: <%= student.getFirstName()%></div>
<div>Last Name: <%= student.getLastName()%></div>

<%
} else if (request.getAttribute("students") != null) {
    List<Student> students = (List<Student>) request.getAttribute("students");
    for (Student student : students) {
%>
<h1>Student Record</h1>
<div>ID: <%= student.getId()%></div>
<div>First Name: <%= student.getFirstName()%></div>
<div>Last Name: <%= student.getLastName()%></div>
<%
    }
} else {
%>
<h1>No student record found.</h1>
<% } %>
</body>
</html>