<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>SignUp</title>
    <style>
        /* Add your CSS styles here */
        body {
            font-family: Arial, sans-serif;
            
            margin: 0;
            padding: 0;
        }
        h1 {
            color: #fff;
            text-align: center;
            padding: 20px 0;
            background-color: #4CAF50; /* Dark green */
            margin: 0;
        }
        .form-container {
            width: 25%;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .form-group {
            margin-bottom: 15px;
            overflow: hidden;
        }
        .form-group label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }
        .form-group input[type="text"], .form-group input[type="password"], .form-group input[type="date"], .form-group input[type="number"] {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        .form-group input[type="submit"] {
            background-color: #4CAF50; /* Dark green */
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .form-group input[type="submit"]:hover {
            background-color: #449d44; /* Medium green */
        }
    </style>
</head>
<body>
    <h1>User SignUp</h1>

    <div class="form-container">
        <form action="SignupAction" method="post">
            <div class="form-group">
                <label for="username">username :</label>
                <input type="text" name="user.username" required />
            </div>
            <div class="form-group">
                <label for="password">password:</label>
                <input type="password" name="user.password" required />
            </div>
            
            <div class="form-group">
                <input type="submit" value="signup" />
                
            </div>
        </form>
    </div>
    <div class="container text-center mt-2">
        	<a href="index.jsp" class="btn btn-primary">login</a>
        </div>
    
</body>
</html>
