import com.google.gson.Gson;
import models.Profile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RestServlet extends HttpServlet {
//    private Controller indexController = new IndexController();
//    private Controller studentController = new StudentController();
//    private Controller authController = new AuthController();


    private class RestRequest {
        // Accommodate two requests, one for all resources, another for a specific resource
        private Pattern regExAllPattern = Pattern.compile("/resource");
        private Pattern regExIdPattern = Pattern.compile("/resource/([0-9]*)");

        private Integer id;

        public RestRequest(String pathInfo) throws ServletException {
            // regex parse pathInfo
            Matcher matcher;

            // Check for ID case first, since the All pattern would also match
            matcher = regExIdPattern.matcher(pathInfo);
            if (matcher.find()) {
                id = Integer.parseInt(matcher.group(1));
                return;
            }

            matcher = regExAllPattern.matcher(pathInfo);
            if (matcher.find()) return;

            throw new ServletException("Invalid URI");
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        try {
            Profile profile = new Profile();
            profile.firstName = "Andrey";
            String employeeJsonString = new Gson().toJson(profile);
            out.println("GET request handling");
            out.println(request.getPathInfo());
            out.println(request.getParameterMap());

            RestRequest resourceValues = new RestRequest(request.getPathInfo());
            //out.println(resourceValues.getId());

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(employeeJsonString);
            out.flush();

        } catch (ServletException e) {
            response.setStatus(400);
            response.resetBuffer();
            e.printStackTrace();
            out.println(e.toString());
        }
        out.close();
//        switch (request.getPathInfo()) {
//            case "logout":
//            case "checkin": {
//                authController.processGet(request, response);
//                break;
//            }
////            case "logout":{
////                authController.processGet(request, response);
////                break;
////            }
//            default: {
//                authController.processPost(request, response);
//                break;
//            }
//        }

//        if (STUDENTS.equals(request.getPathInfo())) {
//            studentController.processGet(request, response);
//        } else {
//            indexController.processGet(request, response);
        //}
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        //
    }

}
