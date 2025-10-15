package ro.emanuel;

//Interfața comună (produsul)
interface Message {
 void send();
}

//Clase concrete (produsele)
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

//Clasa abstractă (Creatorul)
abstract class MessageCreator {

 // Metodă comună - folosește factory-ul intern
 public void sendMessage() {
     // creează mesajul folosind metoda factory
     Message message = createMessage();
     // trimite mesajul
     message.send();
 }

 // Factory Method (subclasele vor implementa această metodă)
 protected abstract Message createMessage();
}

//Subclasă concretă 1
class SMSCreator extends MessageCreator {
 @Override
 protected Message createMessage() {
     return new SMSMessage();  // creează un SMS
 }
}

//Subclasă concretă 2
class EmailCreator extends MessageCreator {
 @Override
 protected Message createMessage() {
     return new EmailMessage();  // creează un Email
 }
}

//Clasa principală (Main)
public class DemoApp {
 public static void main(String[] args) {
     // Cream un creator de SMS-uri
     MessageCreator smsCreator = new SMSCreator();
     smsCreator.sendMessage();

     // Cream un creator de Email-uri
     MessageCreator emailCreator = new EmailCreator();
     emailCreator.sendMessage();
 }
}