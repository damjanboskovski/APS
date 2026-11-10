package IntroductionToJava.First;

// За дадена низа од случајни броеви кои се внесуваат од стандарден влез,
// да се направи преместување на сите нули на почеток на низата.
// На стандарден излез да се испечати трансформираната низа.

// Input: 12
// Input: 1 9 8 4 0 0 2 7 0 6 0 9

// Output: Transformiranata niza e:
// Output: 0 0 0 0 1 9 8 4 2 7 6 9

import java.util.Scanner;

public class PushZero {
    static void pushZeroToBeginning(int arr[], int n){
        int position = n - 1;
        for(int i = n - 1; i >= 0; i--){
            if(arr[i] != 0){
                arr[position] = arr[i];
                position--;
            }
        }

        for(int i = 0; i <= position; i++){
            arr[i] = 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];

        for(int i = 0; i < num; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();

        pushZeroToBeginning(arr, num);

        System.out.println("Transformiranata niza e:");
        for(int i = 0; i < num; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
