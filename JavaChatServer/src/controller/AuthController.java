package controller;

import service.AuthService;
import service.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthController implements Controller {
    //public static final String STUDENTS = "";
    private AuthService authService = new AuthService();

    @Override
    public void processGet(HttpServletRequest request, HttpServletResponse response) {
        request.getAuthType();
//        try {
//            String pathInfo = request.getPathInfo();
//
//            //if (STUDENTS.equals(pathInfo)) {
////                String studentID = request.getParameter("id");
////                if (studentID != null) {
////                    int id = Integer.parseInt(studentID);
////                    request.setAttribute("studentRecord", studentService.getStudent(id));
////                } else {
////                    request.setAttribute("students", studentService.getStudents());
////                }
//            //}
//            //RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/students.jsp");
//            //dispatcher.forward(request, response);
//        } catch (ServletException | IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void processPost(HttpServletRequest request, HttpServletResponse response) {
        // ignored NOT SUPPORTED
        if (AuthService.isToken(request) ) {
            response.setContentType("json/application");
            response
            /* throw new Exception("transction: "); */
            }
//        try {
//            if (AuthService.isToken(request) ) {
////                throw new Exception("transction: ");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();;
//        }
    }
}
