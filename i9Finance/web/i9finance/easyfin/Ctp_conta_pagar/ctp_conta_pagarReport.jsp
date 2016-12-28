<jsp:useBean id="ctp_conta_pagar" class="br.com.i9.finance.server.relatorios.ctp_conta_pagar.Ctp_conta_pagarReport" scope="request"/>
<jsp:setProperty name="ctp_conta_pagar" property="*"/>
<jsp:setProperty name="ctp_conta_pagar" property="page" value="${pageContext}"/>
${ctp_conta_pagar.execute}
