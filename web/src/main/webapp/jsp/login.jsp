<%--
  Created by IntelliJ IDEA.
  User: liaox
  Date: 2019/5/19
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <div>
        <form id="formAdd" action="/user/login" method="post" accept-charset="UTF-8">
            <TABLE cellSpacing=0 cellPadding=5 border=0 style="margin: auto">
                <TR>
                    <td>用户名：</td>
                    <td>
                        <INPUT type="text" style="WIDTH: 180px" maxLength=50 name="u_name">
                    </td>

                </TR>
                <TR>
                    <td>密码 ：</td>
                    <td>
                        <INPUT type="text" style="WIDTH: 180px" maxLength=50 name="u_password">
                    </td>
                </TR>
                <tr>
                    <td colspan="2">
                        <button style="display:block;margin:0 auto;WIDTH: 90px" type="submit">登录</button>
                    </td>
                </tr>
            </TABLE>
        </form>
    </div>
</body>
</html>
