<jsp:useBean id="for_fornecedor" class="br.com.i9.finance.server.relatorios.for_fornecedor.For_fornecedorReport" scope="request"/>
<jsp:setProperty name="for_fornecedor" property="*"/>
<jsp:setProperty name="for_fornecedor" property="page" value="${pageContext}"/>
${for_fornecedor.execute}
