package by.it.academy.Mk_JD2_88_22.HomeTask1.endPoints.servlets;

import by.it.academy.Mk_JD2_88_22.HomeTask1.service.UserStorageService;
import by.it.academy.Mk_JD2_88_22.HomeTask1.service.api.IUserService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SignInServlet", urlPatterns = "/signIn")
public class SignInServlet extends HttpServlet {
  private static final String LOGIN="login";
  private static final String PASSWORD="password";
  private static final String NEXT_PATH="view/message.jsp";
  private static final String CURRENT_PATH="view/signIn.jsp";

  IUserService userService= UserStorageService.getInstanceUser();

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String login = req.getParameter(LOGIN);
    String password = req.getParameter(PASSWORD);

    if (userService.getUserStorage().containsKey(login)) {
      if (userService.getUserStorage().get(login).getPassword().equals(password)) {
        HttpSession session= req.getSession();
        session.setAttribute(LOGIN,login);
        RequestDispatcher request = req.getRequestDispatcher(NEXT_PATH);
        request.forward(req, resp);
      } else {
        RequestDispatcher request = req.getRequestDispatcher(CURRENT_PATH);
        request.forward(req, resp);
      }
    } else {
      RequestDispatcher request = req.getRequestDispatcher(CURRENT_PATH);
      request.forward(req, resp);
    }
  }
}
