<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.BEAN.Vacxin" %>
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

        form {
            margin-bottom: 20px;
        }

        input[type="text"] {
            padding: 10px;
            margin-right: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="radio"] {
            margin-right: 5px;
        }

        button {
            background-color: #007bff;
            color: #fff;
            padding: 12px;
            border: none;
            cursor: pointer;
            border-radius: 4px;
        }

        button:hover {
            background-color: #0056b3;
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
<form action="/manageVacxin" method="get">
    <input type="text" id="data" name="data" placeholder="Enter search term">

    <input type="radio" id="option1" name="option" value="TenVacxin">
    <label for="option1">Tên vacxin</label>

    <input type="radio" id="option2" name="option" value="MaVacxin">
    <label for="option2">Mã vacxin</label>

    <button type="submit">Tìm kiếm</button>
</form>
<a href="addOrUpdate?id=-1">Thêm Vacxin</a>
<table>
    <tr>
        <th>Mã vacxin</th>
        <th>Tên vacxin</th>
        <th>Số mũi</th>
        <th>Mô tả</th>
        <th>Giá vacxin</th>
        <th>Tên hãng sản xuất</th>
        <th>Chỉnh sửa</th>
    </tr>
    <%
        ArrayList<Vacxin> vacxins = (ArrayList<Vacxin>) request.getAttribute("listVacxin");
        Vacxin vacxin;
        if (vacxins != null)
            for (int i = 0; i < vacxins.size(); i++) {
                vacxin = vacxins.get(i);
    %>
    <tr>
        <td><%= vacxin.getIdVacxin()%></td>
        <td><%= vacxin.getNameVacxin()%></td>
        <td><%= vacxin.getSoMui()%></td>
        <td><%= vacxin.getMoTa()%></td>
        <td><%= vacxin.getGiaVacxin()%></td>
        <td><%= vacxin.getTenHangSX()%></td>
        <td><a href="/addOrUpdate?id=<%= vacxin.getIdVacxin()%>">Chỉnh sửa</a></td>
    </tr>
    <% } %>
</table>
<a href="/index.jsp">Quay lại</a>
</body>
</html>
