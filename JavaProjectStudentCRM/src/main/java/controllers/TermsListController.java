package controllers;

import database.DBManager;
import entity.Discipline;
import entity.Term;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TermsListController", urlPatterns = "/termsList")
public class TermsListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Term> terms = DBManager.getAllActiveTerm1();
        List<Discipline> disciplines;
        req.setAttribute("terms", terms);
        String idTerm = req.getParameter("idTerm");
        if (idTerm == null) {
            req.setAttribute("selectedTerm", terms.get(0));
            disciplines = DBManager.showDisciplinesForSelectTerm(Integer.toString(terms.get(0).getId()));
            req.setAttribute("disciplines", disciplines);
        } else {
            int i = 0;
            for (Term term : terms) {
                if (Integer.parseInt(idTerm) == term.getId()) {
                    req.setAttribute("selectedTerm", terms.get(i));
                    break;
                } else {
                    i++;
                }
            }
            disciplines = DBManager.showDisciplinesForSelectTerm(idTerm);
            req.setAttribute("disciplines", disciplines);
        }
        req.setAttribute("currentPage", "/WEB-INF/jsp/termsList.jsp");
        req.setAttribute("pageName", "Список семестров");
        req.getRequestDispatcher("./WEB-INF/jsp/template.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idTerm = req.getParameter("idDelTerm");
        DBManager.deleteTerm(idTerm);
        resp.sendRedirect("/termsList");

    }
}
