<jsp:useBean id="fpar_forma_parcela" class="br.com.i9.finance.server.relatorios.fpar_forma_parcela.Fpar_forma_parcelaReport" scope="request"/>
<jsp:setProperty name="fpar_forma_parcela" property="*"/>
<jsp:setProperty name="fpar_forma_parcela" property="page" value="${pageContext}"/>
${fpar_forma_parcela.execute}
