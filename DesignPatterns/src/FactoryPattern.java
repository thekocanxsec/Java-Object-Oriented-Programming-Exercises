public class FactoryPattern {
}

interface Notification{
    void send(String message);
}

class EmailNotification implements Notification{
    @Override
    public void send(String message){
        System.out.println("E-Mail notification sent: " + message);
    }
}

class SmsNotification implements Notification{
    @Override
    public void send(String message){
        System.out.println("SMS notifcation sent: " + message);
    }
}

class NotificationFactory{
    public Notification createNotification(String type){
        if(type == null){
            return null;
        }
        else if(type.equalsIgnoreCase("EMAIL")) {
            return new EmailNotification();
        }
        else if(type.equalsIgnoreCase("SMS")){
            return new SmsNotification();
        }

        throw new IllegalArgumentException("Uknown type of notification: " + type);
    }
}

class MainRun2{
    static void main() {
        NotificationFactory notification = new NotificationFactory();

        Notification n1 = notification.createNotification("EMAIL");
        n1.send("EMAIL TEST");

        Notification n2 = notification.createNotification("SMS");
        n2.send("SMS TEST");
    }
}