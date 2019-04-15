package service;

import domain.Student;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

public class AuthService {

    private String getToken() {
        return  "";
    }

    public static boolean isToken(HttpServletRequest request) {
        return request.getHeaders("Token").toString() ? true : false;
    }

//    //public List<Student> getStudents() {
//        return students;
//    }
}
