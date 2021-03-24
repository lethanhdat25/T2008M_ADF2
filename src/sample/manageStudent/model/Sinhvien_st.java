package sample.manageStudent.model;

public class Sinhvien_st {
    public String Name;
    public Integer Age;
    public Integer Mark;

    public Sinhvien_st(String name, Integer age, Integer mark) {
        Name = name;
        Age = age;
        Mark = mark;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public Integer getMark() {
        return Mark;
    }

    public void setMark(Integer mark) {
        Mark = mark;
    }
}
