<jsp:useBean id="ccr_conta_ct_receber" class="br.com.i9.finance.server.relatorios.ccr_conta_ct_receber.Ccr_conta_ct_receberReport" scope="request"/>
<jsp:setProperty name="ccr_conta_ct_receber" property="*"/>
<jsp:setProperty name="ccr_conta_ct_receber" property="page" value="${pageContext}"/>
${ccr_conta_ct_receber.execute}
