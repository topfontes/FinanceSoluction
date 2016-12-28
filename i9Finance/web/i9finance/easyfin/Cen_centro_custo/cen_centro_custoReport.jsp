<jsp:useBean id="cen_centro_custo" class="br.com.i9.finance.server.relatorios.cen_centro_custo.Cen_centro_custoReport" scope="request"/>
<jsp:setProperty name="cen_centro_custo" property="*"/>
<jsp:setProperty name="cen_centro_custo" property="page" value="${pageContext}"/>
${cen_centro_custo.execute}
