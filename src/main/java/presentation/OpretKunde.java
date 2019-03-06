package presentation;

import Logik.Kunde;
import persisten.KundeMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OpretKunde", urlPatterns = {"/OpretKunde"})
public class OpretKunde extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String navn = request.getParameter("inputNavn");
//        response.getWriter().println("ny kunde " + navn);

        Kunde kunde = new Kunde(navn);

        KundeMapper.Opret(kunde);

        request.getRequestDispatcher("HentKunder").forward(request,response);




    }
}
