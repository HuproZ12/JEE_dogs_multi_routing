package Temp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "/servlet", value = "/servlet/*")
public class Servlet extends HttpServlet {
    Session session;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch(req.getPathInfo()) {
            case "/affichage":
                session = Util.getSession();
                List<Chien> chiens = session.createQuery("from Chien ").list();
                Util.closeSession(session);
                req.setAttribute("chiens", chiens);
                req.getRequestDispatcher("/WEB-INF/Display.jsp").forward(req, resp);
                break;
            case "/details":
                String chienObjet = req.getParameter("chien");              // "Chien(id=1, nom=Olaf, race=Bulldog, naissance=2018-07-15)"
                chienObjet = chienObjet.substring(6, chienObjet.length() - 1); // "id=1, nom=Olaf, race=Bulldog, naissance=2018-07-15"
                String[] pairs = chienObjet.split(", ");                 // ["id=1", "nom=Olaf", "race=Bulldog", "naissance=2018-07-15"]
                for (String pair : pairs) {
                    String[] cleValeur = pair.split("=");                // ["id","1"] ...
                    req.setAttribute(cleValeur[0], cleValeur[1]);
                }
                req.getRequestDispatcher("/WEB-INF/DisplayDetails.jsp").forward(req, resp);
                break;
            case "/form":
                req.getRequestDispatcher("/WEB-INF/DisplayForm.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch(req.getPathInfo()) {
            case "/form":
                String nom = req.getParameter("nom");
                String race = req.getParameter("race");
                String naissance = req.getParameter("naissance");

                session = Util.getSession();
                session.beginTransaction();
                Chien chien = new Chien.ChienBuilder().nom(nom).race(race).naissance(naissance).build();
                session.save(chien);
                session.getTransaction().commit();
                Util.closeSession(session);

                resp.sendRedirect(req.getServletContext().getContextPath() + "/servlet/affichage");
                break;
            case "/delete":
                int id = Integer.parseInt(req.getParameter("chien"));

                session = Util.getSession();
                session.beginTransaction();
                session.createQuery("DELETE FROM Chien WHERE id = :id").setParameter("id", id).executeUpdate();
                session.getTransaction().commit();
                Util.closeSession(session);

                resp.sendRedirect(req.getServletContext().getContextPath() + "/servlet/affichage");
        }
    }
}