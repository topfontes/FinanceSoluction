<jsp:useBean id="dre" class="br.com.i9.finance.server.relatorios.dre.Dre" scope="request"/>
<jsp:setProperty name="dre" property="*"/> 
<jsp:setProperty name="dre" property="page" value="${pageContext}"/>
${dre.execute}