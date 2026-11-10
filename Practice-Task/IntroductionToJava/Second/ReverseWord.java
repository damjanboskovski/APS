//За даден збор кој се внесува од стандарден влез, да се испечати истиот превртен.
// На влез во првиот ред се дава број на зборови кои ќе се внесуваат.
// Во наредните линии се внесуваат самите зборови.

//Input: 3
// one
// two
// three

//Output: eno
// owt
// eerht

package IntroductionToJava.Second;
import java.util.Scanner;

public class ReverseWord {
    public static void printReversed(String word){
        for(int i = word.length() - 1;  i>= 0; i--){
            System.out.print(word.charAt(i));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i = 0; i<num; i++){
            String word = sc.next();
            printReversed(word);
        }
        sc.close();
    }
}
