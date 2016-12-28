<jsp:useBean id="plc_plano_contas" class="br.com.i9.finance.server.relatorios.plc_plano_contas.Plc_plano_contasReport" scope="request"/>
<jsp:setProperty name="plc_plano_contas" property="*"/>
<jsp:setProperty name="plc_plano_contas" property="page" value="${pageContext}"/>
${plc_plano_contas.execute}
