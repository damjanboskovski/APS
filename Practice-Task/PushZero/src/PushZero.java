//12
//1 9 8 4 0 0 2 7 0 6 0 9
import java.util.Scanner;

public class PushZero
{
    static void pushZerosToBeginning(int arr[], int n)
    {
        int pos = n-1;
        for(int i = n -1; i >=0; i--){
            if(arr[i] != 0){
                arr[pos] = arr[i];
                pos--;
            }
        }
        for(int j = 0; j <= pos; j++){
            arr[j] = 0;
        }
    }


    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        pushZerosToBeginning(arr, n);
        sc.close();
        System.out.println("Transofrmiranata niza e:");
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }
}