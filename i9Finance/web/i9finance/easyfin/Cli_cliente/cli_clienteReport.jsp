<jsp:useBean id="cli_cliente" class="br.com.i9.finance.server.relatorios.cli_cliente.Cli_clienteReport" scope="request"/>
<jsp:setProperty name="cli_cliente" property="*"/>
<jsp:setProperty name="cli_cliente" property="page" value="${pageContext}"/>
${cli_cliente.execute}
