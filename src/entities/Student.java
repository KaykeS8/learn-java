package entities;

import java.util.Objects;

public class Student {
    private Integer uniqueCode;

    public Student(Integer uniqueCode) {
        this.uniqueCode = uniqueCode;
    }

    public Integer getUniqueCode() {
        return uniqueCode;
    }

    public void setUniqueCode() {
        this.uniqueCode = uniqueCode;
    }

    @Override
    public String toString() {
        return "Code: " + uniqueCode;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(uniqueCode, student.uniqueCode);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(uniqueCode);
    }
}
