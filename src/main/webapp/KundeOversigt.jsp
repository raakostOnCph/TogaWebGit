<%@ page import="java.util.List" %>
<%@ page import="Logik.Kunde" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="presentation.HentKunder" %><%--
  Created by IntelliJ IDEA.
  User: nbh
  Date: 2019-03-06
  Time: 09:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Oversigt over kunder</title>
</head>
<body>

<h2> Oversigt over kunder </h2>


<%
    List<Kunde> kundeList = new ArrayList<>();
    kundeList = (List<Kunde>) request.getAttribute("resultat");

    for (int i = 0; i < kundeList.size(); i++) {

        out.println(kundeList.get(i).getKundenr() + " " +
        kundeList.get(i).getNavn() + "<br/>" );
    }
%>



<form action="/SletKunde" method="get">

    <select name="nummer">
        <%
            for (int i = 0; i < kundeList.size(); i++) {%>
        String id = kundeList.get(i).getKundeId();
        <option><%out.print(kundeList.get(i).getKundenr());%></option>
        <%}%>
    </select>

    <input type="submit" name="fyrdenaf" value="slet kunde">
</form>




<form action="OpretKunde"  method="get">

    <input type="text"  name="inputNavn" value="">
    <input type="submit" name="opret" value="opret kunde">

</form>





<form action="Opdater"  method="get">


    angiv kundenummer<select name="nr">
        <%
            for (int i = 0; i < kundeList.size(); i++) {%>
        String id = kundeList.get(i).getKundeId();
        <option><%out.print(kundeList.get(i).getKundenr());%></option>
        <%}%>
    </select>

 skriv dit nye navn :<input type="text"  name="navn" value="">

    <input type="submit" name="kunde nr" value="opdater kunde">

</form>





</body>
</html>
