<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="pu_per_usuJB" class="br.com.easynet.easyportal.jb.Pu_per_usuInsertJB" scope="request"/>
<jsp:setProperty name="pu_per_usuJB" property="*"/>
<jsp:setProperty name="pu_per_usuJB" property="page" value="${pageContext}"/>
${pu_per_usuJB.execute}
{"resultado":"${pu_per_usuJB.msg}"}
