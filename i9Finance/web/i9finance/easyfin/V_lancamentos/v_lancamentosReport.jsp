<jsp:useBean id="v_lancamentos" class="br.com.i9.finance.server.relatorios.v_lancamentos.V_lancamentosReport" scope="request"/>
<jsp:setProperty name="v_lancamentos" property="*"/>
<jsp:setProperty name="v_lancamentos" property="page" value="${pageContext}"/>
${v_lancamentos.execute}
