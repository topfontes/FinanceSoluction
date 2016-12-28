<jsp:useBean id="int_intervalo_parcelamento" class="br.com.i9.finance.server.relatorios.int_intervalo_parcelamento.Int_intervalo_parcelamentoReport" scope="request"/>
<jsp:setProperty name="int_intervalo_parcelamento" property="*"/>
<jsp:setProperty name="int_intervalo_parcelamento" property="page" value="${pageContext}"/>
${int_intervalo_parcelamento.execute}
