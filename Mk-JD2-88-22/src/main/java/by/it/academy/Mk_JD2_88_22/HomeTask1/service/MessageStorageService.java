package by.it.academy.Mk_JD2_88_22.HomeTask1.service;

//import RegistrationForm.service.api.IMessageService;
//import RegistrationForm.dto.Message;

import by.it.academy.Mk_JD2_88_22.HomeTask1.service.api.dto.Message;
import by.it.academy.Mk_JD2_88_22.HomeTask1.service.api.IMessageService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageStorageService implements IMessageService {
    private final Map<String, List<Message>> messageStorage ;
    private final static MessageStorageService instanceMessage = new MessageStorageService();

    private MessageStorageService() {
    this.messageStorage=new HashMap<>();
    }
    @Override
    public void putRecivedMessage(Message message) {
        if (messageStorage.containsKey(message.getRecipient())) {
            messageStorage.get(message.getRecipient()).add(message);
            System.out.println("Добавили к уже существующему юзеру");;

        } else {

            List<Message> massageList = new ArrayList<>();
            massageList.add(message);
            messageStorage.put(message.getRecipient(), massageList);
            System.out.println("Ключа не было но мы создали");
        }
    }

    @Override
    public void putSendedMessage(Message message) {
        if (messageStorage.containsKey(message.getSender())) {
            messageStorage.get(message.getSender()).add(message);


        } else {

            List<Message> massageList = new ArrayList<>();
            massageList.add(message);
            messageStorage.put(message.getSender(), massageList);

        }
    }

//    @Override
//    public HashMap<String, List<Message>> getMessageStorage() {
//        return messageStorage;
//    }

    @Override
    public List<Message> getMessageSendededUser(String userName) {
        return messageStorage.get(userName);
    }
    @Override
    public List<Message> getMessagesRecivedUser(String userName) {
        return messageStorage.get(userName);
    }

    @Override
    public String toString() {
        return "MessageService{" +
                "massageIn=" + messageStorage +
                '}';
    }


    public static MessageStorageService getInstanceMessage() {

        return instanceMessage;
    }


}
