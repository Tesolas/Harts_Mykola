import java.util.Scanner;
/*Write a function named first_non_repeating_letter that takes a string input, 
and returns the first character that is not repeated anywhere in the string.

For example, if given the input 'stress', the function should return 't', 
since the letter t only occurs once in the string, and occurs first in the string.

As an added challenge, upper- and lowercase letters are considered the same character,
but the function should return the correct case for the initial letter. For example, 
the input 'sTreSS' should return 'T'.
If a string contains all repeating characters, it should return an empty string ("")
or None -- see sample tests.
*/

public class second_task {
    public static char first_non_repeating_letter(String givenWord){
        String lowerWord = givenWord.toLowerCase();
        for(int i = 0; i < lowerWord.length(); i++){
            int count = 1;
            char x = lowerWord.charAt(i);
            for(int j = i+1; j < lowerWord.length(); j++){
                if (x == lowerWord.charAt(j)){ 
                    count += 1;
                }
            }
            if(count == 1){ 
                return givenWord.charAt(i);
            }
        }
        return '0';
    }

    public static void main(String[] args) {
        Scanner word = new Scanner(System.in);
        System.out.println("Enter your word: ");
        String givenWord = word.nextLine();
        char letter = first_non_repeating_letter(givenWord);
        System.out.println("First non repeating letter: " + letter);
    }
}
