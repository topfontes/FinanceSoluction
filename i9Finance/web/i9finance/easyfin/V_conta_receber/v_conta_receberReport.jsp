<jsp:useBean id="v_conta_receber" class="br.com.i9.finance.server.relatorios.v_conta_receber.V_conta_receberReport" scope="request"/>
<jsp:setProperty name="v_conta_receber" property="*"/>
<jsp:setProperty name="v_conta_receber" property="page" value="${pageContext}"/>
${v_conta_receber.execute}
