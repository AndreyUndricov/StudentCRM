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

@WebServlet(name = "TermModifyingController", urlPatterns = "/modifyTerm")
public class TermModifyingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String idTerm = req.getParameter("idModifyTerm");

        req.setAttribute("idsOldDisc", req.getParameter("idsOldDisciplines"));
        Term term = DBManager.getTerm1(idTerm, req.getParameter("idsOldDisciplines"));
        List<Discipline> disciplines = term.getDisciplines();

        req.setAttribute("term", term);
        req.setAttribute("disc", disciplines);
        req.setAttribute("currentPage", "/WEB-INF/jsp/termModifying.jsp");
        req.setAttribute("pageName", "Изменение семестра");
        req.getRequestDispatcher("./WEB-INF/jsp/template.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String termId = req.getParameter("termId");
        String termName = req.getParameter("termName");
        String duration = req.getParameter("duration");
        String oldIds = req.getParameter("idOldDisciplines");
        String newIds = req.getParameter("idNewDisciplines");
        DBManager.modifyTerm(termId, termName, duration, oldIds, newIds);
        resp.sendRedirect("/termsList");

    }
}

