interface NotificationMode{
    void sendNotification();
}

class EmailNotification implements NotificationMode{
    public void sendNotification(){
        System.out.println("Notify by Email.");
    }
}

class SMSNotification implements NotificationMode{
    public void sendNotification(){
        System.out.println("Notify by SMS.");
    }
}

class CallNotification implements NotificationMode{
    public void sendNotification(){
        System.out.println("Notify by Call.");
    }
}

abstract class NotificationFactory{
    public abstract NotificationMode createNotificationMode();
}

class EmailNotificationFactory extends NotificationFactory{
    @Override
    public NotificationMode createNotificationMode(){
        return new EmailNotification();
    }
}

class SMSNotificationFactory extends NotificationFactory{
    @Override
    public NotificationMode createNotificationMode(){
        return new SMSNotification();
    }
}

class CallNotificationFactory extends NotificationFactory{
    @Override
    public NotificationMode createNotificationMode(){
        return new CallNotification();
    }
}


class Main {
    public static void main(String[] args) {
        NotificationFactory factory;
        NotificationMode mode;
        
        factory=new EmailNotificationFactory();
        mode=factory.createNotificationMode();
        mode.sendNotification();
        
        factory=new SMSNotificationFactory();
        mode=factory.createNotificationMode();
        mode.sendNotification();
        
        factory=new CallNotificationFactory();
        mode=factory.createNotificationMode();
        mode.sendNotification();
    }
}
