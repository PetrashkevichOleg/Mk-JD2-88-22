package by.it.academy.Mk_JD2_88_22.HomeTask1.service.api;

//import RegistrationForm.dto.Message;

import by.it.academy.Mk_JD2_88_22.HomeTask1.service.api.dto.Message;
import java.util.List;

public interface IMessageService{
    void putRecivedMessage(Message message);
    void putSendedMessage(Message message);
//    HashMap<String,List<Message>> getMessageStorage();
    List<Message> getMessageSendededUser(String userName);
    List<Message> getMessagesRecivedUser(String userName);
}
