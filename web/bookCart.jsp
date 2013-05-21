<%-- 
    Document   : bookCart
    Created on : Aug 11, 2012, 7:58:09 PM
    Author     : Ritz
--%>


<%@page import="com.lab1.controller.book"%>
<%@page import="java.util.*"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<link rel="stylesheet" href="css/style.css" type="text/css">

</head>
<body background="background.jpg">
    
	<table width="80%" align="center"> 
            <tr>
                <td>
                    <table cellpadding="0" cellspacing="0">
                        <tr>
                            <td width="100px"><img src="images/book_logo.png" style="padding-left: 2px" />
                            <td width="350px" valign="bottom" style="padding-bottom:10px;"><span class="heaing">Let's have a book...</span>
                            <td align="right" valign="bottom" style="padding-bottom: 12px" width="430px">
                                <span class="link">
                                    <form method="post" action="showCart">
                                        
                                        <a href="showCart.jsp">Show My Cart</a>
                                    </form>
                                </span>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td>
    <form method="post" action="addToCartServlet">
                    <table width="90%" align="center">
                    <c:forEach items="${book_Info}" var="bi">
                        <c:if test="${bi.order==0}">
                            <tr>
                        </c:if>
                                <td>
                                    <table width="500px" cellspacing="0">
                                        <tr>
                                            <td align="center"><img src="book_images/${bi.image_name}" style="padding-left: 5px; padding-right: 5px; padding-top: 18px;" /></td>
                                            <td width="87%" valign="top">
                                                <div>
                                                    <p class="title">${bi.title}</br>
                                                        
                                                        <label class="author">By, ${bi.author}</br></label>
                                                        <label class="publisher">Published by, ${bi.publisher}</br></label>
                                                        <label class="isbn">ISBN:${bi.isbn}</br></label></p>
                                                    
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right"><img src="images/rupee.png"/><span class="price">${bi.price}</span></td>
                                            <td align="center"><input type="submit" class="CSSButton1" name="add" value=${bi.isbn} /></td>
                                        </tr>
                                        <tr>
                                            <td colspan="2" style="border-bottom:solid 4px #D9C260"></td>
                                        </tr>
                                    </table>
                                </td>
            
                        <c:if test="${bi.order}%2==0">
                            </tr>
                        </c:if>
                    </c:forEach>
                    </table>
                </td>
            </tr>               
            <tr>
                <td align="center" style="padding-top:10px">
                    
                    <a href="addToCartServlet"><input class="checkOut" type="button" name="checkout" value="Check Out My Order" /></a>
                </td>
            </tr>
        </table>    
    </form>
</body>
</html>
