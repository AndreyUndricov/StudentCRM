package entity;

import database.DBManager;

import java.text.SimpleDateFormat;
import java.util.Objects;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String group;
    private String date;

    public Student() {
    }

    public Student(int id, String firstName, String lastName, String group, String date) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        SimpleDateFormat fromDB = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat toUser = new SimpleDateFormat("MM/dd/yyyy");

        try {
            toUser.format(fromDB.parse(date));
            String reformattedStr = toUser.format(fromDB.parse(date));
            this.date = reformattedStr;
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(group, student.group) &&
                Objects.equals(date, student.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, group, date);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", group='" + group + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
