<div align="center">
    <%
      String url = request.getParameter("link");
      if (url != null) {
        url = url.replaceAll("\\|", "?").replaceAll(";", "\\&");
    %>
    <%=url%>
    <a target="download" href="<%=url%>">Download</a>
    <% } %>
</div>