<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
    <head>  
        <title>登录</title>  
    </head>  
    <body>  
        <form method="post" name="frmLogin" action="login/wml">  
            <h1 align="center">  
                用户登录  
            </h1>  
            <br>  
            ${error}  
            <div align="center">  
                用户名：  
                <input type="text" name="txtUserName" value="Your name" size="20"  
                    maxlength="20" onfocus="if(this.value=='Your name')this.value='';">  
                <br>  
                密码：  
                <input type="password" name="txtPassword" value="Your password"  
                    size="20" maxlength="20"  
                    onfocus="if(this.value=='Your password')this.value='';">  
                <br>  
                <input type="submit" name="Submit" value="登录"  
                    onClick="validateLogin();">  
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
                <input type="reset" name="Reset" value="取消">  
                <br>  
            </div>  
        </form>  
  
        <script language="javaScript">  
function validateLogin() {  
    var sUserName = document.frmLogin.txtUserName.value;  
    var sPassword = document.frmLogin.txtPassword.value;  
    if (sUserName == "") {  
        alert("请输入用户名！");  
        return false;  
    }  
    if (sPassword == "") {  
        alert("请输入密码！");  
        return false;  
    }  
}  
</script>  
    </body>  
</html>  