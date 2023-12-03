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
            max-width: 400px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }

        input {
            width: calc(100% - 16px);
            padding: 10px;
            margin-bottom: 16px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
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

        a {
            display: block;
            margin-top: 16px;
            color: #007bff;
            text-decoration: none;
        }

        a:hover {
            color: #0056b3;
        }
    </style>
    <% Vacxin vacxin = (Vacxin) request.getAttribute("data"); %>
    <title><%= (vacxin.getIdVacxin().equals("-1")) ? "Thêm vacxin" : "Sửa vacxin" %></title>
</head>
<body>
<form action="/addOrUpdate" method="post">
    <label for="id">ID:</label>
    <input type="text" name="MaVacxin" id="id" value="<%= (!vacxin.getIdVacxin().equals("-1")) ? vacxin.getIdVacxin() : "" %>"<%= (!vacxin.getIdVacxin().equals("-1") ? "readonly" : "") %>>
    <label for="name">Tên vacxin:</label>
    <input type="text" name="TenVacxin" id="name" value="<%= (!vacxin.getIdVacxin().equals("-1")) ? vacxin.getNameVacxin() : "" %>">
    <label for="somui">Số mũi:</label>
    <input type="text" name="SoMui" id="somui" value="<%= (!vacxin.getIdVacxin().equals("-1")) ? vacxin.getSoMui() : "" %>">
    <label for="mota">Mô tả:</label>
    <input type="text" name="MoTa" id="mota" value="<%= (!vacxin.getIdVacxin().equals("-1")) ? vacxin.getMoTa() : "" %>">
    <label for="giatien">Giá vacxin:</label>
    <input type="text" name="GiaVacxin" id="giatien" value="<%= (!vacxin.getIdVacxin().equals("-1")) ? vacxin.getGiaVacxin() : "" %>">
    <label for="hangsx">Hãng sản xuất:</label>
    <input type="text" name="TenHangSX" id="hangsx" value="<%= (!vacxin.getIdVacxin().equals("-1")) ? vacxin.getTenHangSX() : "" %>">
    <button type="submit"><%= (vacxin.getIdVacxin().equals("-1")) ? "Thêm vacxin" : "Sửa vacxin" %></button>
    <a href="/manageVacxin">Quay lại</a>
</form>
</body>
</html>
