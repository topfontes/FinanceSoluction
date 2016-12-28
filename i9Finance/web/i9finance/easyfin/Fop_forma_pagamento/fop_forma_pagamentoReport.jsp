<jsp:useBean id="fop_forma_pagamento" class="br.com.i9.finance.server.relatorios.fop_forma_pagamento.Fop_forma_pagamentoReport" scope="request"/>
<jsp:setProperty name="fop_forma_pagamento" property="*"/>
<jsp:setProperty name="fop_forma_pagamento" property="page" value="${pageContext}"/>
${fop_forma_pagamento.execute}
