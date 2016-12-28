<jsp:useBean id="ban_banco" class="br.com.i9.finance.server.relatorios.ban_banco.Ban_bancoReport" scope="request"/>
<jsp:setProperty name="ban_banco" property="*"/>
<jsp:setProperty name="ban_banco" property="page" value="${pageContext}"/>
${ban_banco.execute}
