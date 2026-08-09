package lab8task4;

import java.util.List;

public class ReportList{
    public void exportList(List<?> list){
        for(Object element : list){
            System.out.println(element);
        }
    }
}
