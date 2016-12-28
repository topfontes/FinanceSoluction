<jsp:useBean id="v_conta_pagar" class="br.com.i9.finance.server.relatorios.v_conta_pagar.V_conta_pagarReport" scope="request"/>
<jsp:setProperty name="v_conta_pagar" property="*"/>
<jsp:setProperty name="v_conta_pagar" property="page" value="${pageContext}"/>
${v_conta_pagar.execute}
