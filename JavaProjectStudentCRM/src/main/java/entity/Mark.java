package entity;

import java.util.Objects;

public class Mark {
    private int id;
    private int graduate;
    private String discipline;

    public Mark() {
    }

    public Mark(int id, int graduate, String discipline) {
        this.id = id;
        this.graduate = graduate;
        this.discipline = discipline;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGraduate() {
        return graduate;
    }

    public void setGraduate(int graduate) {
        this.graduate = graduate;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mark mark = (Mark) o;
        return id == mark.id &&
                graduate == mark.graduate &&
                Objects.equals(discipline, mark.discipline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, graduate, discipline);
    }

    @Override
    public String toString() {
        return "Mark{" +
                "id=" + id +
                ", graduate=" + graduate +
                ", discipline='" + discipline + '\'' +
                '}';
    }
}
