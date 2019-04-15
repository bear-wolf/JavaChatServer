import controller.Controller;
import controller.IndexController;
import controller.StudentController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static controller.StudentController.STUDENTS;

public class RestServlet extends HttpServlet {
    private Controller indexController = new IndexController();
    private Controller studentController = new StudentController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        if (STUDENTS.equals(request.getPathInfo())) {
            studentController.processGet(request, response);
        } else {
            indexController.processGet(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        //
    }

}
