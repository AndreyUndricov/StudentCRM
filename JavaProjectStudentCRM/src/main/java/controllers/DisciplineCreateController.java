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

@WebServlet(name = "DisciplineCreateController", urlPatterns = "/disciplinecreating")
public class DisciplineCreateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("currentPage","/WEB-INF/jsp/disciplinecreating.jsp");
        req.setAttribute("pageName", "Создание дисциплину");
        req.getRequestDispatcher("./WEB-INF/jsp/template.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String nameOfDiscipline = req.getParameter("discName");
        DBManager.insertNewDiscipline(nameOfDiscipline);
        resp.sendRedirect("/disciplines");
    }
}