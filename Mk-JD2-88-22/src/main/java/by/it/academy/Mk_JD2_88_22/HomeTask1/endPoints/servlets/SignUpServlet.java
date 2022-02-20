package by.it.academy.Mk_JD2_88_22.HomeTask1.endPoints.servlets;

import static java.lang.Integer.parseInt;

import by.it.academy.Mk_JD2_88_22.HomeTask1.service.api.dto.User;
import by.it.academy.Mk_JD2_88_22.HomeTask1.service.MessageStorageService;
import by.it.academy.Mk_JD2_88_22.HomeTask1.service.UserStorageService;
import by.it.academy.Mk_JD2_88_22.HomeTask1.service.api.IMessageService;
import by.it.academy.Mk_JD2_88_22.HomeTask1.service.api.IUserService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet (name = "SignUpServlet", urlPatterns = "/signUp")
public class SignUpServlet extends HttpServlet {
  private static final String FIRST_NAME_PARAM= "first_name";
  private static final String LAST_NAME_PARAM= "last_name";
  private static final String LOGIN= "login";
  private static final String PASSWORD= "password";
  private static final String PATH= "view/signUp.jsp";
  private static final String NEXT_PATH="view/message.jsp";

  IMessageService messageService= MessageStorageService.getInstanceMessage();
  IUserService userService= UserStorageService.getInstanceUser();

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println( "Привет");
    req.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html;charset= UTF-8");

    String login = req.getParameter(LOGIN);
    String password = req.getParameter(PASSWORD);
    String firstName = req.getParameter(FIRST_NAME_PARAM);
    String lastName = req.getParameter(LAST_NAME_PARAM);

    if (lastName.isEmpty() || login.isEmpty() || firstName.isEmpty() || password.isEmpty()) {
      RequestDispatcher request = req.getRequestDispatcher(PATH);
      request.include(req,resp);
    } else {

      if (userService.getUserStorage().containsKey(login)) {
        req.setAttribute("userExists",true);

        req.getRequestDispatcher(PATH).forward(req,resp);
      } else {
        HttpSession session= req.getSession();
        session.setAttribute(LOGIN,login);
        User user = new User(login, password, firstName, lastName);
        userService.addUser(user);
        RequestDispatcher request=req.getRequestDispatcher(NEXT_PATH);
        request.forward(req,resp);
        System.out.println((req.getContextPath()));

      }
    }

//

  }


}
