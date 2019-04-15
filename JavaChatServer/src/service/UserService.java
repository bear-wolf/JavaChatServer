package service;

import models.User;

import javax.servlet.http.HttpServletRequest;

public class UserService {

    private User parseRequest(HttpServletRequest request) {
        if (request.getParameter('pass')) {

        }
        return new User();
    }

//    //public List<Student> getStudents() {
//        return students;
//    }
}
