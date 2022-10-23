import java.util.Scanner;
/*Digital root is the recursive sum of all the digits in a number.
Given n, take the sum of the digits of n. If that value has more than one digit, 
continue reducing in this way until a single-digit number is produced. 
The input will be a non-negative integer.
*/

public class third_task {
    public static int digital_root(int givenNumber){
        int sum = 0;
        String num;
        num = String.valueOf(givenNumber);
        for(int i = 0; i < num.length(); i++){
            sum += Integer.parseInt(num.substring(i, i+1));
        }
        if(String.valueOf(sum).length() > 1){
            sum = digital_root(sum);
        }

        return sum;

    }

    public static void main(String[] args) {
        Scanner number = new Scanner(System.in);
        System.out.println("Enter your number: ");
        int num = number.nextInt();
        // int num = 1235;
        int result = digital_root(num);
        System.out.println("\nSum of the numbers: \n" + result);
    }
}
