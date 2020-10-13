package controllers;

import database.DBManager;
import entity.Mark;
import entity.Student;
import entity.Term;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentProgressController", urlPatterns = "/studentProgress")
public class StudentProgressController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String idStud;
        Student student;
        List<Mark> marks;
        List<Term> terms = DBManager.getAllActiveTerm1();
        req.setAttribute("terms", terms);
        String idTerm = req.getParameter("idTerm");
        if (idTerm == null) {
            idStud = req.getParameter("idStudentProgress");
            student = DBManager.getStudentById(idStud);
            req.setAttribute("stud", student);
            req.setAttribute("selectedTerm", terms.get(0));
            marks = DBManager.showMarkForSelectStudentAndTerm(idStud, Integer.toString(terms.get(0).getId()));
            req.setAttribute("markes", marks);
        } else {
            idStud = req.getParameter("idSt");
            student = DBManager.getStudentById(idStud);
            req.setAttribute("stud", student);
            int i = 0;
            for (Term term : terms) {
                if (Integer.parseInt(idTerm) == term.getId()) {
                    req.setAttribute("selectedTerm", terms.get(i));
                    break;
                } else {
                    i++;
                }
            }
            marks = DBManager.showMarkForSelectStudentAndTerm(idStud, idTerm);
            req.setAttribute("markes", marks);
        }
        req.setAttribute("currentPage", "/WEB-INF/jsp/studentProgress.jsp");
        req.setAttribute("pageName", "Успеваемость студента");
        req.getRequestDispatcher("./WEB-INF/jsp/template.jsp").forward(req, resp);
    }


}
