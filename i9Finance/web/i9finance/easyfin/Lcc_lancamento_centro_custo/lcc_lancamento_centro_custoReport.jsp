<jsp:useBean id="lcc_lancamento_centro_custo" class="br.com.i9.finance.server.relatorios.lcc_lancamento_centro_custo.Lcc_lancamento_centro_custoReport" scope="request"/>
<jsp:setProperty name="lcc_lancamento_centro_custo" property="*"/>
<jsp:setProperty name="lcc_lancamento_centro_custo" property="page" value="${pageContext}"/>
${lcc_lancamento_centro_custo.execute}
