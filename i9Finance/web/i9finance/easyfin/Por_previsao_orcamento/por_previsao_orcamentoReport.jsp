<jsp:useBean id="por_previsao_orcamento" class="br.com.i9.finance.server.relatorios.por_previsao_orcamento.Por_previsao_orcamentoReport" scope="request"/>
<jsp:setProperty name="por_previsao_orcamento" property="*"/>
<jsp:setProperty name="por_previsao_orcamento" property="page" value="${pageContext}"/>
${por_previsao_orcamento.execute}
