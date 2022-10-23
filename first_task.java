import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*In this task you will create a function that takes a list of non-negative integers 
and strings and returns a new list with the strings filtered out.*/

public class first_task {
    public static List getIntegersFromList(List defaultList){
        List newList = new ArrayList<>();

        for(int i = 0; i < defaultList.size(); i++){
            if(defaultList.get(i) instanceof Integer ){
                newList.add(defaultList.get(i));
            }  
        }

        return newList;
    }

    
    public static void main(String[] args) {
        List defaultList = new ArrayList<>();
        defaultList.add(1);
        defaultList.add(2);
        defaultList.add("aa");
        defaultList.add("b");
        defaultList.add("123");
        defaultList.add(0);
        defaultList.add(15);
        List numbers = getIntegersFromList(defaultList);
        System.out.println(numbers);

    }
}
