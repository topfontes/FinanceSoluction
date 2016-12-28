<jsp:useBean id="lan_lancamento" class="br.com.i9.finance.server.relatorios.lan_lancamento.Lan_lancamentoReport" scope="request"/>
<jsp:setProperty name="lan_lancamento" property="*"/>
<jsp:setProperty name="lan_lancamento" property="page" value="${pageContext}"/>
${lan_lancamento.execute}
