<jsp:useBean id="ccp_conta_ct_pagar" class="br.com.i9.finance.server.relatorios.ccp_conta_ct_pagar.Ccp_conta_ct_pagarReport" scope="request"/>
<jsp:setProperty name="ccp_conta_ct_pagar" property="*"/>
<jsp:setProperty name="ccp_conta_ct_pagar" property="page" value="${pageContext}"/>
${ccp_conta_ct_pagar.execute}
