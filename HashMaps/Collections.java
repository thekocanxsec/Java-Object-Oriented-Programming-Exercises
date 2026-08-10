import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


class ClubMembers implements Comparable<ClubMembers>{
    public String name;
    public int age;

    public ClubMembers(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public int compareTo(ClubMembers members){
        return Integer.compare(this.age, members.age);
    }
}


class Main2{
    static void main() {
        List<ClubMembers> clubMembers = new ArrayList<>();

        clubMembers.add(new ClubMembers("Imran", 22));
        clubMembers.add(new ClubMembers("Mirza", 23));
        clubMembers.add(new ClubMembers("Afan", 22));
        clubMembers.add(new ClubMembers("Tarik", 21));
        clubMembers.add(new ClubMembers("Ubejd", 20));

        Collections.sort(clubMembers);

        ClubMembers wanted = new ClubMembers("Afan", 22);
        int index = Collections.binarySearch(clubMembers,wanted);
        if(index >= 0){
            System.out.println("A person who is 22 years old was found at index " + index);
            System.out.println("name: " + clubMembers.get(index).getName());

        }
    }
}
