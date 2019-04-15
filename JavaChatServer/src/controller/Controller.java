package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
    void processGet(HttpServletRequest request, HttpServletResponse response);
    void processPost(HttpServletRequest request, HttpServletResponse response);
}
