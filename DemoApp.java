package ro.emanuel;

interface Message {
 void send();
}

class SMSMessage implements Message {
 public void send() {
     System.out.println("Sending an SMS message...");
 }
}

class EmailMessage implements Message {
 public void send() {
     System.out.println("Sending an Email message...");
 }
}
abstract class MessageCreator {

 public void sendMessage() {
     Message message = createMessage();
     message.send();
 }

 protected abstract Message createMessage();
}

class SMSCreator extends MessageCreator {
 @Override
 protected Message createMessage() {
     return new SMSMessage(); 
 }
}
class EmailCreator extends MessageCreator {
 @Override
 protected Message createMessage() {
     return new EmailMessage();  
 }
}
public class DemoApp {
 public static void main(String[] args) {
     MessageCreator smsCreator = new SMSCreator();
     smsCreator.sendMessage();

     MessageCreator emailCreator = new EmailCreator();
     emailCreator.sendMessage();
 }
}
