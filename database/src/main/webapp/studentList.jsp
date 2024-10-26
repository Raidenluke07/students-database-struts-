<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f4f4f4;
        }
        h2 {
            color: #003366; /* Navy Blue */
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #003366; /* Navy Blue */
            color: white;
        }
        tr:nth-child(even) {
            background-color: #e6e6e6;
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
        }
        
        tr:nth-child(even) {
  background-color: rgba(150, 212, 212, 0.4);
}

th:nth-child(even),td:nth-child(even) {
  background-color: rgba(150, 212, 212, 0.4);
}


tr:hover {background-color: #D6EEEE;}
    </style>
</head>
<body>
    <h2>Student List</h2>
    <s:if test="students.isEmpty()">
        <p>No students found.</p>
    </s:if>
    <s:else>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Address</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="students">
                    <tr>
                        <td><s:property value="id"/></td>
                        <td><s:property value="name"/></td>
                        <td><s:property value="address"/></td>
                        <td>
                            <a href="editStudent.action?id=<s:property value='id'/>">Edit</a>
                            <a href="deleteStudent.action?id=<s:property value='id'/>">Delete</a>
                        </td>
                    </tr>
                </s:iterator>
            </tbody>
        </table>
    </s:else>
    <a href="addStudent.jsp">Add New Student</a>
</body>
</html>
