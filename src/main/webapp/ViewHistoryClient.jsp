<%@ page import="Model.BEAN.History" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 20px;
            text-align: center;
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            overflow: hidden;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: left;
        }

        th {
            background-color: #007bff;
            color: #fff;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        a {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            color: #fff;
            text-decoration: none;
            background-color: #007bff;
            border-radius: 4px;
            transition: background-color 0.3s, color 0.3s;
        }

        a:hover {
            background-color: #0056b3;
        }
    </style>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>Mã khách hàng</th>
        <th>Tên khách hàng</th>
        <th>Mã Vacxin</th>
        <th>Tên Vacxin</th>
        <th>Tên bệnh</th>
        <th>Số mũi cần tiêm</th>
    </tr>
    <%
        ArrayList<History> clients = (ArrayList<History>) request.getAttribute("dataHistory");
        for(int i = 0; i < clients.size(); i++) {
            History history = clients.get(i);
    %>
    <tr>
        <td><%= history.getIdClient()%></td>
        <td><%= history.getNameClient()%></td>
        <td><%= history.getIdVacxin()%></td>
        <td><%= history.getNameVacxin()%></td>
        <td><%= history.getNameDisease()%></td>
        <td><%= history.getSummaryDose()%></td>
    </tr>
    <%
        }
    %>
</table>
<a href="/manageClient">Quay lại</a>
</body>
</html>
