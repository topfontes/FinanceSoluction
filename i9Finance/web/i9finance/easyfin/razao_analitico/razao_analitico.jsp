<jsp:useBean id="razao" class="br.com.i9.finance.server.relatorios.razao_analitico.Razao_analiticoReport" scope="request"/>
<jsp:setProperty name="razao" property="*"/> 
<jsp:setProperty name="razao" property="page" value="${pageContext}"/>
${razao.execute}