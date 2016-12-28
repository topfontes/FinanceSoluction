<jsp:useBean id="v_conta_receber_conta" class="br.com.i9.finance.server.relatorios.v_conta_receber_conta.V_conta_receber_contaReport" scope="request"/>
<jsp:setProperty name="v_conta_receber_conta" property="*"/>
<jsp:setProperty name="v_conta_receber_conta" property="page" value="${pageContext}"/>
${v_conta_receber_conta.execute}
