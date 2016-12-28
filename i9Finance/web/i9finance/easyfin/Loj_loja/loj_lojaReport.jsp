<jsp:useBean id="loj_loja" class="br.com.i9.finance.server.relatorios.loj_loja.Loj_lojaReport" scope="request"/>
<jsp:setProperty name="loj_loja" property="*"/>
<jsp:setProperty name="loj_loja" property="page" value="${pageContext}"/>
${loj_loja.execute}
