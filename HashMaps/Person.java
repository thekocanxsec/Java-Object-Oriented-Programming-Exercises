record Person(String name, int age,int height) {
    public Person(String name){
        this(name,0,0);
    }

    public Person(String name, int age){
        this(name,age,0);
    }

    public static Person unnamed(String name){
        return new Person(name);
    }

    public int a(){
        return 1;
    }
}
