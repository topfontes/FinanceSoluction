<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="op_ope_perJB" class="br.com.easynet.easyportal.jb.Op_ope_perConsultJB" scope="request"/>                                         
<jsp:setProperty name="op_ope_perJB" property="*"/>                                         
<jsp:setProperty name="op_ope_perJB" property="page" value="${pageContext}"/>                                         
${op_ope_perJB.execute}                                         
                                     

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<head>
<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<title>op_ope_per</title>
<meta http-equiv="Content-Type" content="text/html; charset=latin1" />
<link rel="stylesheet" href="/recursos/mm_health_nutr.css" type="text/css" />
<script language="JavaScript" type="text/javascript">
<!--
//--------------- LOCALIZEABLE GLOBALS ---------------
var d=new Date();
var monthname=new Array("January","February","March","April","May","June","July","August","September","October","November","December");
//Ensure correct for language. English is "January 1, 2004"
var TODAY = monthname[d.getMonth()] + " " + d.getDate() + ", " + d.getFullYear();
//---------------   END LOCALIZEABLE   ---------------

//-->
</script>
        <link href="model.css" rel="stylesheet" type="text/css" />          
        <link href="/model.css" rel="stylesheet" type="text/css" />          
        <script src="eventos.js"></script>  
        <script src="/eventos.js"></script>                                         

</head>
<body bgcolor="#F4FFE4">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr bgcolor="#D5EDB3">
    <td colspan="3">
	<jsp:include page="cabecalho.jsp" flush="true" />
	</td>
  </tr>
  <tr>
    <td colspan="3" bgcolor="#5C743D"><img src="/recursos/mm_spacer.gif" alt="" width="1" height="1" border="0" /></td>
  </tr>

  <tr>
    <td colspan="3" bgcolor="#99CC66" background="/recursos/mm_dashed_line.gif">
	<img src="/recursos/mm_dashed_line.gif" alt="line decor" width="4" height="3" border="0" />
	</td>
  </tr>

  <tr bgcolor="#99CC66">
  	<td colspan="3" id="dateformat" height="20">&nbsp;&nbsp;<script language="JavaScript" type="text/javascript">
      document.write(TODAY);	</script>	</td>
  </tr>
  <tr>
    <td colspan="3" bgcolor="#99CC66" background="/recursos/mm_dashed_line.gif"><img src="/recursos/mm_dashed_line.gif" alt="line decor" width="4" height="1" border="0" /></td>
  </tr>

  <tr>
    <td colspan="3" bgcolor="#5C743D"><img src="/recursos/mm_spacer.gif" alt="" width="1" height="2" border="0" /></td>
  </tr>

 <tr>
    <td width="29" valign="top" bgcolor="#5C743D">
	<%@include file="menu.jsp"%>
 	&nbsp; 	</td>
    <td width="16"></td>
    <td valign="top">&nbsp;<br />
	<table border="0" cellspacing="0" cellpadding="0" width="90%">
        <tr>
          <td class="pageName">op_ope_per</td>
		</tr>

		<tr>
          <td valign="top" class="bodyText"><p align="left">
                                          


<form action="op_ope_perConsult.jsp" method="post">                                         
    <input type="hidden" name="op"/>
    <center>     
	<label class="errorMessage" align="center">${op_ope_perJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOp('insert')"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOp('consult')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>	
    <display:table class="grandtotal-label" cellpadding="0" cellspacing="0" id="item" name="${op_ope_perJB.list}"  pagesize="5" >
     <!--   <th>Per_nr_id</th>
<th>Ope_nr_id</th>
<th>Sis_nr_id</th>
   -->
	<display:column sortable="false" title="Per_nr_id" >
	    <a href="op_ope_perUpdateDelete.jsp?op=findbyid&op_ope_perT.per_nr_id=${item.per_nr_id}&op_ope_perT.ope_nr_id=${item.ope_nr_id}&op_ope_perT.sis_nr_id=${item.sis_nr_id}&">
      		<c:out value="${item.per_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ope_nr_id" >
	    <a href="op_ope_perUpdateDelete.jsp?op=findbyid&op_ope_perT.per_nr_id=${item.per_nr_id}&op_ope_perT.ope_nr_id=${item.ope_nr_id}&op_ope_perT.sis_nr_id=${item.sis_nr_id}&">
      		<c:out value="${item.ope_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Sis_nr_id" >
	    <a href="op_ope_perUpdateDelete.jsp?op=findbyid&op_ope_perT.per_nr_id=${item.per_nr_id}&op_ope_perT.ope_nr_id=${item.ope_nr_id}&op_ope_perT.sis_nr_id=${item.sis_nr_id}&">
      		<c:out value="${item.sis_nr_id}"/>
            </a>
	</display:column>

        <display:column title="Apagar">
       	   <center>
		<a href="op_ope_perConsult.jsp?op=delete&op_ope_perT.per_nr_id=${item.per_nr_id}&op_ope_perT.ope_nr_id=${item.ope_nr_id}&op_ope_perT.sis_nr_id=${item.sis_nr_id}&">
    	       		<img border="0" src="images/delete.png">
		</a>
	   </center>
       </display:column>	
    </display:table>
    </center>	
    
</form>           
              
          </p>
            <p align="left"><br />
            </p>            <div align="center"></div></td>
        </tr>
      </table>
	�</td>
  </tr>
  <tr>
    <td width="29">&nbsp;</td>
    <td width="16">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
</body>
</html>                                 
