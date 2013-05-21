<%-- 
    Document   : index
    Created on : Aug 10, 2012, 5:41:39 PM
    Author     : Ritz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <style>
       
    </style>
    </head>
    <body background="background.jpg">
        <table width="80%" align="center"> 
            <tr>
                <td>
                    <table cellpadding="0" cellspacing="0">
                        <tr>
                            <td width="100px"><img src="images/book_logo.png" />
                            <td width="350px" valign="bottom" style="padding-bottom:10px;"><span class="heaing">Let's have a book...</span>
                        </tr>
                   </table>
                </td>
            </tr>
            <tr>
                <td align="center" style="padding-top:120px">
                    <form method="post" action="showBooks">
                        <button class="homeButton">Click Here To Enter Into Book Shop</button>
                    </form>
                </td>
            </tr>
        </table>
    </body>
</html>
