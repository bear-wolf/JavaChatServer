package controller;

import service.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentController implements Controller {
    public static final String STUDENTS = "";
    private StudentService studentService = new StudentService();

    @Override
    public void processGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            String pathInfo = request.getPathInfo();

            if (STUDENTS.equals(pathInfo)) {
                String studentID = request.getParameter("id");
                if (studentID != null) {
                    int id = Integer.parseInt(studentID);
                    request.setAttribute("studentRecord", studentService.getStudent(id));
                } else {
                    request.setAttribute("students", studentService.getStudents());
                }
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/students.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void processPost(HttpServletRequest request, HttpServletResponse response) {
        // ignored NOT SUPPORTED
    }
}
