package presentation;

import Logik.Kunde;
import persisten.KundeMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HentKunder",urlPatterns = {"/HentKunder"})
public class HentKunder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        List<Kunde> kundeList = KundeMapper.getKunder();

        request.setAttribute("resultat", kundeList);

//        response.getWriter().println(kundeList.size());
//
//
//        for (int i = 0; i < kundeList.size(); i++) {
//            response.getWriter().println(kundeList.get(i).getNavn());
//        }


       request.getRequestDispatcher("KundeOversigt.jsp").forward(request,response);


    }
}
