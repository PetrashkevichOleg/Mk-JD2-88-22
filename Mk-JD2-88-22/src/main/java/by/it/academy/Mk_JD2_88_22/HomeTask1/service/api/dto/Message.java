package by.it.academy.Mk_JD2_88_22.HomeTask1.service.api.dto;

import java.time.LocalDateTime;

public class Message {
  String sender;
  String recipient;
  String message;
  LocalDateTime time;


  public Message(String sender, String recipient, String massage, LocalDateTime time) {
    this.sender = sender;
    this.recipient = recipient;
    this.message = massage;
    this.time = time;
  }

  public String getSender() {
    return sender;
  }

  public String getRecipient() {
    return recipient;
  }

  public String getMessage() {
    return message;
  }

  public LocalDateTime getTime() {
    return time;
  }

  @Override
  public String toString() {
    return "Massage{" +
        "sender='" + sender + '\'' +
        ", recipient='" + recipient + '\'' +
        ", massage='" + message + '\'' +
        ", time=" + time +
        '}';
  }
}
