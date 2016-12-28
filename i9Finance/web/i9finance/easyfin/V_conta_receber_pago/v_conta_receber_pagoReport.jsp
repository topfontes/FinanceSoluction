<jsp:useBean id="v_conta_receber_pago" class="br.com.i9.finance.server.relatorios.v_conta_receber_pago.V_conta_receber_pagoReport" scope="request"/>
<jsp:setProperty name="v_conta_receber_pago" property="*"/>
<jsp:setProperty name="v_conta_receber_pago" property="page" value="${pageContext}"/>
${v_conta_receber_pago.execute}
