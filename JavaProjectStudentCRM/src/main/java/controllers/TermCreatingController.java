package controllers;

import database.DBManager;
import entity.Discipline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TermCreatingController", urlPatterns = "/createTerm")
public class TermCreatingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        List<Discipline> disciplines = DBManager.getAllActiveDisciplines();
        req.setAttribute("disces", disciplines);
        req.setAttribute("currentPage", "/WEB-INF/jsp/termCreating.jsp");
        req.setAttribute("pageName", "Создание семестра");
        req.getRequestDispatcher("./WEB-INF/jsp/template.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String termName = req.getParameter("termName");
        String duration = req.getParameter("duration");
        String id = DBManager.createTerm(termName, duration);
        String idDisciplines = req.getParameter("idSelectedDisciplines");
        DBManager.addDisciplinesInNewTerm(id, idDisciplines);
        resp.sendRedirect("/termsList");

    }
}

