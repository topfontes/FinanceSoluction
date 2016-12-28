<jsp:useBean id="par_parcelamento" class="br.com.i9.finance.server.relatorios.par_parcelamento.Par_parcelamentoReport" scope="request"/>
<jsp:setProperty name="par_parcelamento" property="*"/>
<jsp:setProperty name="par_parcelamento" property="page" value="${pageContext}"/>
${par_parcelamento.execute}
