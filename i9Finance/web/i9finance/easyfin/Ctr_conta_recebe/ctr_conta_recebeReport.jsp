<jsp:useBean id="ctr_conta_recebe" class="br.com.i9.finance.server.relatorios.ctr_conta_recebe.Ctr_conta_recebeReport" scope="request"/>
<jsp:setProperty name="ctr_conta_recebe" property="*"/>
<jsp:setProperty name="ctr_conta_recebe" property="page" value="${pageContext}"/>
${ctr_conta_recebe.execute}
