package presentation;

import persisten.KundeMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Opdater", urlPatterns = {"/Opdater"})
public class Opdater extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String navn = request.getParameter("navn");
        String nr = request.getParameter("nr");

        KundeMapper.Opdater(nr, navn);

        request.getRequestDispatcher("HentKunder").forward(request,response);

    }
}
