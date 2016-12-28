<jsp:useBean id="v_lan_centro_custo" class="br.com.i9.finance.server.relatorios.v_lan_centro_custo.V_lan_centro_custoReport" scope="request"/>
<jsp:setProperty name="v_lan_centro_custo" property="*"/>
<jsp:setProperty name="v_lan_centro_custo" property="page" value="${pageContext}"/>
${v_lan_centro_custo.execute}
