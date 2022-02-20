package by.it.academy.Mk_JD2_88_22.HomeTask1.endPoints.servlets;

import by.it.academy.Mk_JD2_88_22.HomeTask1.service.api.dto.Message;
import by.it.academy.Mk_JD2_88_22.HomeTask1.service.MessageStorageService;
import by.it.academy.Mk_JD2_88_22.HomeTask1.service.api.IMessageService;
import java.io.IOException;

import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name ="ChartsServlet",urlPatterns = "/charts")
public class ChartsServlet extends HttpServlet {

  private static final String NEXT_PATH="view/charts.jsp";
  private static final String LOGIN="login";
  IMessageService messageService = MessageStorageService.getInstanceMessage();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html;charset= UTF-8");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html;charset= UTF-8");

    List<Message> currentsList = messageService.getMessagesRecivedUser(req.getParameter(LOGIN));

    HttpSession session = req.getSession();
    session.setAttribute("currentsList", currentsList);

    RequestDispatcher request= req.getRequestDispatcher(NEXT_PATH);
    request.forward(req,resp);

    }
  }

