interface NotificationStrategy {
    void send(String message);
}

class EmailNotification implements NotificationStrategy{
    public void send(String message){
        System.out.println("Sending EMAIL with message: " + message);
    }
}

class SMSNotification implements NotificationStrategy{
    public void send(String message){
        System.out.println("Sending SMS with message: " + message);
    }
}

class PushNotification implements NotificationStrategy{
    public void send(String message){
        System.out.println("Sending PUSH with message: " + message);
    }
}

class NotificationContext{
    private NotificationStrategy notificationStrategy;

    public void setNotificationStrategy(NotificationStrategy notificationStrategy){
        this.notificationStrategy = notificationStrategy;
    }

    public void notifyUser(String message){
        if(message == null){
            System.out.println("Cannot send empty message!");
            return;
        }

        notificationStrategy.send(message);

    }
}

class MainRun2{
    static void main() {
        NotificationContext notificationContext = new NotificationContext();

        notificationContext.setNotificationStrategy(new SMSNotification());

        notificationContext.notifyUser("Hello, Dear friend");
    }
}


