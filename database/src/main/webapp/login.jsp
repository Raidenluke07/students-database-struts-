<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h2>Login</h2>
    <s:form action="login">
        <s:textfield name="username" label="Username" required="true"/>
        <s:password name="password" label="Password" required="true"/>
        <s:submit value="Login"/>
        <s:actionerror/>
    </s:form>
</body>
</html>
