<jsp:useBean id="car_cartao" class="br.com.i9.finance.server.relatorios.car_cartao.Car_cartaoReport" scope="request"/>
<jsp:setProperty name="car_cartao" property="*"/>
<jsp:setProperty name="car_cartao" property="page" value="${pageContext}"/>
${car_cartao.execute}
