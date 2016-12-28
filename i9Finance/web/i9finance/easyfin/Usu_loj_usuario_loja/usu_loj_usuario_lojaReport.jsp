<jsp:useBean id="usu_loj_usuario_loja" class="br.com.i9.finance.server.relatorios.usu_loj_usuario_loja.Usu_loj_usuario_lojaReport" scope="request"/>
<jsp:setProperty name="usu_loj_usuario_loja" property="*"/>
<jsp:setProperty name="usu_loj_usuario_loja" property="page" value="${pageContext}"/>
${usu_loj_usuario_loja.execute}
