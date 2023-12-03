<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSP - Hello World</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 20px;
            text-align: center;
        }

        h1 {
            color: #333;
            text-transform: uppercase;
            letter-spacing: 2px;
            margin-bottom: 20px;
        }

        a {
            text-decoration: none;
            color: #007bff;
            margin-right: 20px;
            font-weight: bold;
        }

        a:hover {
            color: #0056b3;
        }

        a:visited {
            color: #004085;
        }
    </style>
</head>
<body>
<h1><%= "Quản Lý" %></h1>
<br/>
<a href="/manageVacxin">Quản lý vacxin</a>
<a href="/manageClient">Quản lý khách hàng</a>
</body>
</html>
