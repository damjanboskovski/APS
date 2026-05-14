//3
//one
//two
//three
import java.util.Scanner;

public class ReverseWord {

    public static void printReversed(String word) {
        for(int i = word.length() - 1; i>= 0; i--){
            System.out.print(word.charAt(i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            String word = sc.next();
            printReversed(word);
            System.out.println();
        }
        sc.close();
    }
}
