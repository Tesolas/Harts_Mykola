/*
There is an array of numbers - arr [1, 3, 6, 2, 2, 0, 4, 5] 
there is a number target = 5.
 Count the number of pairs in the array, the sum of which will give target
*/

public class fourth_task {
    public static int target_number(int target, int[] numbers){
        int counter = 0;
        for(int i = 0; i < numbers.length; i++){
            for(int j = i+1; j < numbers.length; j++){
                if(numbers[i] + numbers[j] == target){
                    counter +=1;
                }
            }
        }
        return counter;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 2, 2, 0, 4, 5};
        int target = 5;
        int couples = target_number(target, arr);
        System.out.println(couples);
    }
}
