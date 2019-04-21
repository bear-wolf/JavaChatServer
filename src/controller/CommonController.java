package controller;

import interfaces.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

public class CommonController implements Controller {
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected StringBuilder bodyRequest;

    public CommonController setHttpServletRequest(HttpServletRequest request) {
        this.request = request;

        return this;
    }

    public CommonController route() {
        return this;
    }

    protected void parseBodyFromRequest(HttpServletRequest request) {
        bodyRequest = new StringBuilder();
        BufferedReader reader;

        try {
            reader = request.getReader();
            String line;
            while ((line = reader.readLine()) != null) {
                bodyRequest.append(line).append('\n');
            }
        } catch (IOException e) {

        }
//        finally {
//            reader.close();
//        }
    }

    public CommonController setHttpServletResponse(HttpServletResponse response) {
        this.response = response;

        return this;
    }

    @Override
    public void processGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public void processPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
