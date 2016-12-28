<jsp:useBean id="conf_configuracao" class="br.com.i9.finance.server.relatorios.conf_configuracao.Conf_configuracaoReport" scope="request"/>
<jsp:setProperty name="conf_configuracao" property="*"/>
<jsp:setProperty name="conf_configuracao" property="page" value="${pageContext}"/>
${conf_configuracao.execute}
