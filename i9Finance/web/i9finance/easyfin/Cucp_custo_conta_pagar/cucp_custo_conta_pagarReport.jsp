<jsp:useBean id="cucp_custo_conta_pagar" class="br.com.i9.finance.server.relatorios.cucp_custo_conta_pagar.Cucp_custo_conta_pagarReport" scope="request"/>
<jsp:setProperty name="cucp_custo_conta_pagar" property="*"/>
<jsp:setProperty name="cucp_custo_conta_pagar" property="page" value="${pageContext}"/>
${cucp_custo_conta_pagar.execute}
