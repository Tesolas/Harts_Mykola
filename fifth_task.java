import java.util.*;

public class fifth_task {
    public static String filter_list(String names){
        names = names.toUpperCase();
        String[] list = names.split(";");
        for(int i = 0; i < list.length; i++){
            String[] name = list[i].split(":");
            Collections.reverse(Arrays.asList(name));
            list[i] = String.join(":", name);
        }
        Arrays.sort(list);

        String res = String.join(")(", list);
        res = "(" + res + ")";
        return res;
    }

    public static void main(String[] args) {
        String s = "Fired:Corwill;Wilfred:Corwill;Barney:TornBull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill";
        String list = filter_list(s);
        System.out.println(list);
    }
}

// s = "Fired:Corwill;Wilfred:Corwill;Barney:TornBull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill"