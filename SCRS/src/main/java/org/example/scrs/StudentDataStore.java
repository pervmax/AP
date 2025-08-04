package org.example.scrs;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.example.scrs.Student;

public class StudentDataStore {
    private static final String DATA_FILE = "student.dat";

    public Student loadStudent() {
        Student s = new Student("Mrigendra Man Baidhya", "mrigendra.baidhya@email.com", "BCS", "5");
        File f = new File(DATA_FILE);

        if (f.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                String name = br.readLine();
                String email = br.readLine();
                String program = br.readLine();
                String semester = br.readLine();

                if (name != null) s.setName(name);
                if (email != null) s.setEmail(email);
                if (program != null) s.setProgram(program);
                if (semester != null) s.setSemester(semester);

                List<String> courses = new ArrayList<>();
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.startsWith("C:") && line.length() > 2) {
                        courses.add(line.substring(2));
                    }
                }
                s.setRegisteredCourses(courses);
            } catch (IOException ex) {
                System.err.println("Error loading student data: " + ex.getMessage());
            }
        }
        return s;
    }

    public void saveStudent(Student s) {
        try (PrintWriter out = new PrintWriter(new FileWriter(DATA_FILE))) {
            out.println(s.getName());
            out.println(s.getEmail());
            out.println(s.getProgram());
            out.println(s.getSemester());
            for (String c : s.getRegisteredCourses()) {
                out.println("C:" + c);
            }
            out.flush(); // Ensure data is written
        } catch (IOException ex) {
            System.err.println("Error saving student data: " + ex.getMessage());
            throw new RuntimeException("Failed to save student data", ex);
        }
    }
}
