<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="par_parametroJB" class="br.com.i9.portal.jb.Par_parametroConsultJB" scope="request"/>
<jsp:setProperty name="par_parametroJB" property="*"/>                                         
<jsp:setProperty name="par_parametroJB" property="page" value="${pageContext}"/>                                         
${par_parametroJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${par_parametroJB.list}" var="item">
     ,{	"sis_nr_id":"${item.sis_nr_id}"
 ,	"par_nr_id":"${item.par_nr_id}"
 ,	"par_tx_nome":"${item.par_tx_nome}"
 ,	"par_tx_valor":"${item.par_tx_valor}"
 ,	"par_tx_secreto":"N"
  }
</c:forEach>
]}