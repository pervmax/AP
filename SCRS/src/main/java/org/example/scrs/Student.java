package org.example.scrs;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name, email, program, semester;
    private List<String> registeredCourses;

    public Student(String name, String email, String program, String semester) {
        this.name = name; this.email = email; this.program = program; this.semester = semester;
        this.registeredCourses = new ArrayList<>();
    }
    // Getters and setters
    public String getName() { return name; }
    public void setName(String s) { name = s; }
    public String getEmail() { return email; }
    public void setEmail(String s) { email = s; }
    public String getProgram() { return program; }
    public void setProgram(String s) { program = s; }
    public String getSemester() { return semester; }
    public void setSemester(String s) { semester = s; }
    public List<String> getRegisteredCourses() { return registeredCourses; }
    public void setRegisteredCourses(List<String> l) { registeredCourses = l; }
}
