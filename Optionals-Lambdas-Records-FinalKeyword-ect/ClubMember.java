import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClubMember implements Comparable<ClubMember> {
    private String name;
    private int height;

    public ClubMember(String name, int height){
        this.name = name;
        this.height = height;
    }

    @Override
    public int compareTo(ClubMember other){
        return Integer.compare(this.getHeight(), other.getHeight());
    }

    public int getHeight(){
        return this.height;
    }
}

class Main3{
    static void main() {
        List<ClubMember> clubMemberList = new ArrayList<>();

        clubMemberList.add(new ClubMember("Imran", 181));
        clubMemberList.add(new ClubMember("Tarik", 173));
        clubMemberList.add(new ClubMember("Muhamad", 171));

        Collections.sort(clubMemberList);

        ClubMember wanted = new ClubMember("Tarik", 173);
        int index = Collections.binarySearch(clubMemberList, wanted);

        if(index > 0){
            System.out.println("Person has been found, at index: " + index);
        }else{
            System.out.println("Person you are looking for is not in clubMembersList.");
        }


    }
}
