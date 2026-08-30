package lab8task1;
package lab8task1;

public class Locker<T>{
    private int lockerNumber;
    private boolean isLocked;
    private T item;

    public Locker(int lockerNumber, T item){
        this.lockerNumber = lockerNumber;
        this.item = item;
        this.isLocked = true;
    }

    public void unlock(){
        this.isLocked = false;
    }

    public void lock(){
        this.isLocked = true;
    }

    public void viewItem(){
        if(!isLocked){
            System.out.println("Locker number: " + this.lockerNumber + " contains: " + this.item);
        }
        else{
            System.out.println("Locker number: " + this.lockerNumber + " is locked. Cannot view item.");
        }
    }
}
