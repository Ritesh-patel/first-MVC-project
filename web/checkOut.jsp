<%-- 
    Document   : checkOut
    Created on : Aug 15, 2012, 5:28:03 PM
    Author     : Ritz
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" href="css/style.css" type="text/css">  
    <script type="text/javascript">
        function valid(form)
        {
            if(form.cname.value=="")
            {
                alert('Error: Please enter your name')
                form.cname.focus();
                return false;
            }
            
            if(form.cno.value=="")
            {
                alert('Error: Please enter your contact number')
                form.cno.focus();
                return false;
            }
            
            if(form.address.value=="")
            {
                alert('Error: Please enter your address')
                form.address.focus();
                return false;
            }
            
            if(form.eid.value=="")
            {
                alert('Error: Please enter your email id')
                form.eid.focus();
                return false;
            }
        }
        function isNumberKey(evt)
        {   
            var charCode = (evt.which) ? evt.which : event.keyCode
            if (charCode > 31 && (charCode < 48 || charCode > 57))
            {
                    alert('Error: Please Enter Numeric value only.');

                    return false;
            }
            else
            {
                    return true;
            }

}
    </script>
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
        	<td align="center">
                    <form method="post" action="checkOut" name="form1" onsubmit="return valid(this);">
            	<table width="100%" align="left">
                    <tr>                    
                        <td align="left">                    
                        <span class="form">
                            <table width="500" align=left cellspacing="10" style="padding-left:20px; font-size:15px; font-family:Verdana, Geneva, sans-serif">
                                <tr>
                               	  <td colspan="2" style="padding-left:100px; font-size:20px; padding-bottom: 10px; font-family:Verdana, Geneva, sans-serif" >Customer Information</td>
                                </tr>
                              <tr>
                                    <td valign="top">Customer Name:</td>
                                    <td><input type="text" id="cname" name="cname"  style="font-size:15px; font-family:Verdana, Geneva, sans-serif"/></td>
                                </tr>
                                <tr>
                                    <td valign="top">Contact No.:</td>
                                    <td><input  type="text" name="cno" id="cno" onkeypress="return isNumberKey(event)" style="font-size:15px; font-family:Verdana, Geneva, sans-serif" /></td>
                                </tr>
                                <tr>
                                    <td valign="top">Address:</td>
                                    <td><textarea name="address" id="address" style="font-size:15px; font-family:Verdana, Geneva, sans-serif"></textarea></td>
                                </tr>
                                <tr>
                                  <td valign="top">Email ID:</td>
                                  <td><input type="text" name="eid" id="eid" style="font-size:15px; font-family:Verdana, Geneva, sans-serif" /></td>
                                </tr>
                            </table>
                        </td>
                        </span>
                            
                        <td align="left" valign="top" style="padding-top:15px">
                            <table width="100%" border="1" style="border-style:solid">
                            	<tr>
                                    <td align="center" style="font-size:20px; font-family:Verdana, Geneva, sans-serif"><span class="order1"> Book name </span>
                                    <td style="font-size:20px; font-family:Verdana, Geneva, sans-serif"><span class="order1">Quantity</span>
                                </tr>
                            	
                                <tr>
                                
                            	  <td align="center" style="font-size:20px; font-family:Verdana, Geneva, sans-serif">
                                      <table>
                                          <c:forEach items="${bookName}" var="bn">
                                            <tr>
                                                <td align="left"><span class="order"> - ${bn}</span></td>
                                            </tr>                                        
                                          </c:forEach>
                                      </table>
                                  </td>
                            	  <td align="center" style="font-size:20px; font-family:Verdana, Geneva, sans-serif"> 
                                      <table>
                                          <c:forEach items="${qty}" var="q">
                                          <tr>
                                              <td align="right"><span class="order">${q}</span></td>
                                          </tr>                       
                                          
                                         </c:forEach>
                                      </table>
                                  </td>
                                  
                                  </tr>
                                  <tr>
                                      <td align="center">
                                          <span class="order"><b>Total Amount</b></span>
                                      </td>
                                      <td align="center">
                                          <span class="order"><b>${amount}</b></span>
                                      </td>
                                  </tr>
                            </table>
                        </td>
                    </tr>
                </table>  
                    
            </td>
    	</tr>           
    	<tr>
            <td align="left" style="padding-left:100px; padding-top:5px">            
                <c:set var="isbn" value="${isbn}" scope="request" />
                <input type="submit" class="checkOut" value="Checkout" style="width:200px; font-size:15px; font-family:Verdana, Geneva, sans-serif" />
            </td>
        </tr>
        </form>
        </table>
    </body>
</html>
