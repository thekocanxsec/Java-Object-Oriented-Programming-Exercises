class AbstractFactory2 {
}

interface Button{
     void paint();
}

interface Checkbox{
    void check();
}

class WindowsButton implements Button{
    @Override
    public void paint(){
        System.out.println("We paint with WINDOWS");
    }
}

class WindowsCheckbox implements Checkbox{
    @Override
    public void check(){
        System.out.println("We check with WINDOWS");
    }
}

class MacButton implements Button{
    @Override
    public void paint(){
        System.out.println("We paint with MAC");
    }
}

class MacCheckbox implements Checkbox{
    @Override
    public void check(){
        System.out.println("We check with MAC");
    }
}

interface GUIFactory{
    Button createButton();
    Checkbox createCheckbox();
}

class WindowsFactory implements GUIFactory{
    @Override
    public Button createButton(){
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox(){
        return new WindowsCheckbox();

    }
}

class MacFactory implements GUIFactory{
    @Override
    public Button createButton(){
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox(){
        return new MacCheckbox();
    }
}

class MainRun5{
    static void main() {
        GUIFactory mac = new MacFactory();

        Button macButton = mac.createButton();
        Checkbox macCheckbox = mac.createCheckbox();

        macButton.paint();
        macCheckbox.check();

    }
}
