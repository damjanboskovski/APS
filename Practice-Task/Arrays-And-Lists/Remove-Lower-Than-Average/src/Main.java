import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    public static void printList(ArrayList<Integer> list){
        System.out.println("{");
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i));
            if(i < list.get(i) - 1){
                System.out.print(",");
            }
        }
        System.out.println("}");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        ArrayList<Integer> originalList = new ArrayList<>();
        int sum = 0;

        for(int i = 0; i < num; i++){
            originalList.add(sc.nextInt());
            sum += originalList.get(i);
        }

        printList(originalList);

        double avg = (double) sum / num;
        ArrayList<Integer> filteredList = new ArrayList<>();
        for(int i : originalList){
            if(i >= avg){
                filteredList.add(i);
            }
        }
        printList(filteredList);
    }
}