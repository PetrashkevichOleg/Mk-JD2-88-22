package by.it.academy.Mk_JD2_88_22.HomeTask1.endPoints.servlets;

import by.it.academy.Mk_JD2_88_22.HomeTask1.service.api.dto.Message;
import by.it.academy.Mk_JD2_88_22.HomeTask1.service.MessageStorageService;
import by.it.academy.Mk_JD2_88_22.HomeTask1.service.api.IMessageService;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name ="MessageServlet",urlPatterns = "/message")
public class MessageServlet extends HttpServlet {
private static final String RECIPIENT="recipient";
private static final String MESSAGE="message";
private static final String LOGIN="login";
  private static final String NEXT_PATH="view/message.jsp";
  IMessageService messageService= MessageStorageService.getInstanceMessage();

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html;charset= UTF-8");
    String messageRow = req.getParameter(MESSAGE);
    String recipient= req.getParameter(RECIPIENT);

    HttpSession session= req.getSession();

    Message message=new Message((String) session.getAttribute(LOGIN),recipient,messageRow, LocalDateTime.now().truncatedTo(
        ChronoUnit.MINUTES));

    messageService.putRecivedMessage(message);
    RequestDispatcher request = req.getRequestDispatcher(NEXT_PATH);
    request.forward(req,resp);




  }
}
