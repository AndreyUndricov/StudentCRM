package database;

import entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DBManager {
    private static Connection con;
    private static PreparedStatement modifyDiscipline;
    private static PreparedStatement getAccountByLoginPasswordRole;
    private static PreparedStatement getAllActiveTerms;
    private static PreparedStatement modifyStudent;

// Подлкючение е базе данных
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student_crm?useUnicode=true&serverTimezone=UTC", "root", "root");
            modifyDiscipline = con.prepareStatement("UPDATE `discipline` SET `discipline` = ? WHERE (`id` = ?);");
            getAccountByLoginPasswordRole = con.prepareStatement("SELECT * FROM user_role\n" +
                    "left join user on user_role.id_user = user.id\n" +
                    "where user.login = ? and user.password = ? and user_role.id_role = ?;");
            getAllActiveTerms = con.prepareStatement("SELECT * FROM term_discipline  as td\n" +
                    "left join term as t on td.id_term = t.id\n" +
                    "left join discipline as d on td.id_discipline = d.id\n" +
                    "where t.status = 1 and d.status = 1 order by td.id_term;");
            modifyStudent = con.prepareStatement("UPDATE `student` SET `first_name` = ?, `last_name` = ?, `group` = ?, `date` = ? WHERE (`id` = ?);");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Получить список всех дисциплин
    public static LinkedList<Discipline> getAllActiveDisciplines() {
        LinkedList<Discipline> disciplines = new LinkedList<Discipline>();
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from discipline where status = 1");
            while (rs.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(rs.getInt(1));
                discipline.setDiscipline(rs.getString(2));
                disciplines.add(discipline);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return disciplines;
    }

    //
    public static void insertNewDiscipline(String newDiscipline) {
        try {
            Statement stm = con.createStatement();
            stm.execute("INSERT INTO `discipline` (`discipline`) VALUES ('" + newDiscipline + "');");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Добавляем новых студентов
    public static void insertNewStudent(String firstName, String lastName, String group, String date) {
        try {
            Statement stm = con.createStatement();
            stm.execute("INSERT INTO `student` (`first_name`, `last_name`, `group`, `date`) VALUES ('" + firstName + "', '" + lastName + "', '" + group + "', '" + date + "');");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Discipline getDisciplineById(String id) {
        Discipline discipline = new Discipline();
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from discipline where status = 1 AND id = " + id);

            while (rs.next()) {
                discipline.setId(rs.getInt("id"));
                discipline.setDiscipline(rs.getString("discipline"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return discipline;
    }

    //Изменить дисциплину
    public static void modifyDiscipline(String discipline, String id) {
        try {
            modifyDiscipline.setString(1, discipline);
            modifyDiscipline.setString(2, id);
            modifyDiscipline.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Удаляем выбранную дисциплину
    public static void deleteDiscipline(String ids) {
        try {
            Statement stm = con.createStatement();
            stm.execute("UPDATE `discipline` SET `status` = '0' WHERE (`id` in (" + ids + "));");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //
    public static List<Student> getAllStudents() {
        ArrayList<Student> students = new ArrayList<Student>();
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM student WHERE `status`=1 ");
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt(1));
                student.setFirstName(rs.getString(2));
                student.setLastName(rs.getString(3));
                student.setGroup(rs.getString(4));
                student.setDate(rs.getString(5));
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    //
    public static Student getStudentById(String id) {
        Student student = new Student();
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from student where status = 1 AND id = " + id);

            while (rs.next()) {
                student.setId(rs.getInt(1));
                student.setFirstName(rs.getString(2));
                student.setLastName(rs.getString(3));
                student.setGroup(rs.getString(4));
                student.setDate(rs.getString(5));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    // Изменить студента
    public static void modifyStudent(String firstName, String lastName, String group, String date, String id) {
        try {
            Statement stm = con.createStatement();
            stm.execute("UPDATE `student` SET `first_name` = '" + firstName + "', `last_name` = '" + lastName + "', `group` = '" + group + "', `date` = '" + date + "' WHERE (`id` = '" + id + "');");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Удаление студентов из базы данных
    public static void deleteStudent(String ids) {
        try {
            Statement stm = con.createStatement();
            stm.execute("UPDATE `student` SET `status` = '0' WHERE (`id` in (" + ids + "));");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //
    public static boolean getAccountByLoginPasswordRole(String login, String password, String role) {
        try {
            getAccountByLoginPasswordRole.setString(1, login);
            getAccountByLoginPasswordRole.setString(2, password);
            getAccountByLoginPasswordRole.setString(3, role);
            ResultSet rs = getAccountByLoginPasswordRole.executeQuery();

            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //
    public static List<Term> getAllActiveTerm1() {
        LinkedList<Term> terms = new LinkedList<Term>();
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM student_crm.term where status=1;");

            while (rs.next()) {
                Term term = new Term();
                term.setId(rs.getInt(1));
                term.setName(rs.getString(2));
                term.setDuration(rs.getString(3));
                terms.add(term);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return terms;
    }

    //
    public static List<Discipline> showDisciplinesForSelectTerm(String idTerm) {

        List<Discipline> disciplines = new LinkedList<Discipline>();
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM term_discipline  as td\n" +
                    "left join discipline as d on td.id_discipline = d.id\n" +
                    "where td.id_term=" + idTerm + " and td.status = 1 and d.status = 1;");

            while (rs.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(rs.getInt(5));
                discipline.setDiscipline(rs.getString(6));
                disciplines.add(discipline);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return disciplines;
    }

    //
    public static List<Mark> showMarkForSelectStudentAndTerm(String idStudent, String idTerm) {

        List<Mark> marks = new LinkedList<Mark>();
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM mark as m\n" +
                    "left join term_discipline as td on m.id_term_discipline = td.id\n" +
                    "left join term as t on td.id_term=t.id\n" +
                    "left join discipline as d on td.id_discipline=d.id\n" +
                    "where m.id_student = " + idStudent + " and t.id = " + idTerm + " and t.status=1;");

            while (rs.next()) {
                Mark mark = new Mark();
                mark.setId(rs.getInt(1));
                mark.setDiscipline(rs.getString(14));
                mark.setGraduate(rs.getInt(4));
                marks.add(mark);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return marks;
    }

    // Удаляем семестр
    public static void deleteTerm(String id) {
        try {
            Statement stm = con.createStatement();
            stm.execute("UPDATE `student_crm`.`term` SET `status` = '0' WHERE (`id` = '" + id + "');");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Создать семестр
    public static String createTerm(String nameDisc, String duration) {
        String id = "";
        try {
            Statement stm = con.createStatement();
            stm.execute("INSERT INTO `term` (`name`, `duration`) VALUES ('" + nameDisc + "', '" + duration + "');");
            ResultSet rs = stm.executeQuery("SELECT * FROM term where term.name = '" + nameDisc + "';");
            while (rs.next()) {
                id = Integer.toString(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    // Добавляем новые дисциплины в семетр
    public static void addDisciplinesInNewTerm(String termId, String idDisc) {
        try {
            Statement stm = con.createStatement();
            for (String idsDisc1 : idDisc.split(",")) {
                System.out.println(idsDisc1);
                stm.execute("INSERT INTO `term_discipline` (`id_term`, `id_discipline`) VALUES ('" + termId + "', '" + idsDisc1 + "');");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Получить по ID семетр
    public static Term getTerm(String idTerm) {
        Term term = new Term();
        try {
            Statement stm = con.createStatement();
            Statement stm1 = con.createStatement();
            ResultSet rs1 = stm1.executeQuery("SELECT * FROM term where id=" + idTerm + ";");
            term.setId(rs1.getInt(1));
            term.setName(rs1.getString(2));
            term.setDuration(rs1.getString(3));

            LinkedList<Discipline> disciplines = DBManager.getAllActiveDisciplines();
            ResultSet rs = stm.executeQuery("SELECT id_discipline FROM term_discipline  as td where  td.id_term = " + idTerm + " order by td.id_term;");
            for (Discipline disc : disciplines) {
                while (rs.next()) {
                    if (disc.getId() == rs.getInt(1)) {
                        disc.setFlag(1);
                    } else {
                        disc.setFlag(0);
                    }
                    term.addDiscipline(disc);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return term;
    }

    //
    public static Term getTerm1(String idTerm, String oldIds) {
        Term term = new Term();
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM term where  term.id = '" + idTerm + "';");
            while (rs.next()) {
                term.setId(rs.getInt(1));
                term.setName(rs.getString(2));
                term.setDuration(rs.getString(3));
            }
            LinkedList<Discipline> disciplines = DBManager.getAllActiveDisciplines();
            for (Discipline disc : disciplines) {
                for (String s : oldIds.split(",")) {
                    if (Integer.parseInt(s) == disc.getId()) {
                        disc.setFlag(1);
                        break;
                    }
                }
                term.addDiscipline(disc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return term;
    }

    //
    public static List<Discipline> getDisciplinesOfModifyTerm(int idTerm) {
        List<Discipline> disciplines = new LinkedList<Discipline>();
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM term_discipline where term_discipline.id_term =" + idTerm + ";");
            while (rs.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(3);
                disciplines.add(discipline);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return disciplines;
    }

    //
    public static void modifyTerm(String termId, String termName, String duration, String oldIds, String newIds) {
        try {
            Statement stm = con.createStatement();
            stm.execute("UPDATE term SET `name` = '" + termName + "', `duration` = '" + duration + "' WHERE (`id` = '" + termId + "');");
            for (String oldId : oldIds.split(",")) {
                boolean got = false;
                for (String newId : newIds.split(",")) {
                    if (oldId == newId) {
                        got = true;
                        break;
                    }
                }
                if (!got) {
                    stm.execute("UPDATE term_discipline SET status = '0' WHERE id_term = '" + termId + "' and id_discipline = '" + oldId + "';");
                }
            }
            for (String newId : newIds.split(",")) {
                boolean got = false;
                for (String oldId : oldIds.split(",")) {
                    if (oldId == newId) {
                        got = true;
                        break;
                    }
                }
                if (!got) {
                    stm.execute("INSERT INTO term_discipline (`id_term`, `id_discipline`) VALUES ('" + termId + "', '" + newId + "');");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}