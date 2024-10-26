<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Student</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        h2 {
            color: #003366; /* Navy Blue */
            margin: 20px 0;
        }

        a {
            text-decoration: none;
            color: #003366; /* Navy Blue */
        }

        a:hover {
            text-decoration: underline;
        }

        p {
            color: #666;
            font-size: 14px;
        }

        form {
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 600px;
            margin: auto;
        }

        label {
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
        }

        input[type="text"] {
            width: calc(100% - 20px);
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
    </style>
</head>
<body>
    <h2>Edit Student</h2>
    <s:form action="updateStudent.action">
        <s:hidden name="id" />
        <label for="name">Name:</label>
        <s:textfield name="name" /><br/><br/>
        <label for="address">Address:</label>
        <s:textfield name="address" /><br/><br/>
        <s:submit value="Update" />
    </s:form>
    <a href="display.action">Back to List</a>
</body>
</html>
