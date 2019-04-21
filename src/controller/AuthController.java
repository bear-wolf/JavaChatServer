package controller;

import classes.Reply;
import com.google.gson.Gson;
import interfaces.Validation;
import models.auth.SignIn;
import models.auth.SignUp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AuthController extends CommonController implements Validation {

    private void checkIn() {

    }

    private void logOut() {

    }

    //autherntificate by new data
    private void signIn() {

    }

    @Override
    public AuthController route() {
        String path = request.getPathInfo();
        String action = path.substring(path.lastIndexOf('/') + 1);

        parseBodyFromRequest(this.request);

        if ("POST".equals(request.getMethod())) {
            if (!isValidate()) {
                return null;
                //throw new IOException("auth ctrl not catch");
            }
        }

        switch (action) {
            case "sign-in": {
                signIn();
                break;
            }
            case "sign-up": {
                signUp();
                break;
            }
            case "logout": {
                logOut();
                break;
            }
            default: {
                break;
            }
        }
        return this;
    }

    //registry new data
    private void signUp(){
        Gson gson = new Gson();
        SignUp signUp = gson.fromJson(bodyRequest.toString(), SignUp.class);
        PrintWriter pw;
        Reply reply = new Reply()
                .setStatus(true)
                .setData(new Gson().toJson(signUp));

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try {
            pw = response.getWriter();
            pw.write(new Gson().toJson("{ 'data' : 'true'}"));
        } catch (IOException e) {
            //pw.write(new Gson().toJson("{ 'data' : 'false'}"));
        }
    }

//    //@Override
//    protected void processGet(HttpServletRequest request, HttpServletResponse response) {
//        String path = this.request.getPathInfo();
//
//        String action = path.substring(path.lastIndexOf('/')+1);
//
//        switch (action) {
//            case "check-in": {
//                this.checkIn();
//
//                break; }
//            case "logout": {
//                this.logOut();
//                break;
//            }
//            case "sign-in": {
//                this.signIn();
//
//                break;
//            }
//            case "sign-up": {
//                this.signUp();
//
//                break;
//            }
//        }
//    }
//
//    //@Override
//    protected void processPost(HttpServletRequest request, HttpServletResponse response) {
//        // ignored NOT SUPPORTED
//
//        try {
//            PrintWriter pw = response.getWriter();
//            pw.print("text");
//            pw.close();
//
//            System.out.println("Is not output. It's error");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public boolean isValidate() {
        boolean result = true;

        String path = this.request.getPathInfo();

        String action = path.substring(path.lastIndexOf('/')+1);

        Gson gson = new Gson();

        switch (action) {
            case "check-in":
            case "logout": {
                break;
            }
            case "sign-in": {
                SignIn signIn = gson.fromJson(bodyRequest.toString(), SignIn.class);
                if (!signIn.isValidate()) {
                    result = false;
                }

                break;
            }
            case "sign-up": {
                SignUp singUp = gson.fromJson(bodyRequest.toString(), SignUp.class);
                if (!singUp.isValidate()) result = false;
                break;
            }
        }

        return result;
    }
}
