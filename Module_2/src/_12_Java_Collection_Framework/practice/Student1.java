package _12_Java_Collection_Framework.practice;

public class Student1 implements Comparable <Student> {
    private String name;
    private Integer age;
    private String address;

    public Student1(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }


    public int compareTo(Student1 student) {
        return this.getName().compareTo(student.getName());
    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }
}