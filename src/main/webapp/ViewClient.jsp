<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.BEAN.ClientFinance" %>
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
            text-decoration: none;
            color: #007bff;
            padding: 8px 12px;
            border-radius: 4px;
            background-color: #fff;
            border: 1px solid #007bff;
            transition: background-color 0.3s, color 0.3s;
        }

        a:hover {
            background-color: #007bff;
            color: #fff;
        }

        a.back-link {
            display: inline-block;
            margin-top: 20px;
            font-size: 18px;
        }
    </style>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>Mã khách hàng</th>
        <th>Tên khách hàng</th>
        <th>Địa chỉ</th>
        <th>Tổng tiền</th>
        <th>Chi tiết</th>
    </tr>
    <%
        ArrayList<ClientFinance> clients = (ArrayList<ClientFinance>) request.getAttribute("dataClients");
        for(int i = 0; i < clients.size(); i++) {
            ClientFinance clientFinance = clients.get(i);
    %>
    <tr>
        <td><%= clientFinance.getIdClient()%></td>
        <td><%= clientFinance.getNameClient()%></td>
        <td><%= clientFinance.getAddressClient()%></td>
        <td><%= clientFinance.getSummaryMoney()%></td>
        <td><a href="/manageHistory?id=<%= clientFinance.getIdClient()%>">Chi tiết</a></td>
    </tr>
    <%
        }
    %>
</table>
<a href="/index.jsp" class="back-link">Quay lại</a>
</body>
</html>
