package ArrayAndList.Task1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        ArrayList<Integer> originalList = new ArrayList<Integer>();
        int sum = 0;

        for(int i = 0; i < num; i++){
            originalList.add(sc.nextInt());
            sum += originalList.get(i);
        }

        double avg = (double) sum / num;

        System.out.print("{");
        for(int i = 0; i < num; i++){
            System.out.print(originalList.get(i));
            if(i < num - 1){
                System.out.print(",");
            }
        }
        System.out.println("}");

        ArrayList<Integer> transformedList = new ArrayList<>();

        for(int value : originalList){
            if( value >= avg ){
                transformedList.add(value);
            }
        }

        System.out.print("{");
        for(int i = 0; i < transformedList.size(); i++){
            System.out.print(transformedList.get(i));
            if(i < transformedList.size() - 1){
                System.out.print(",");
            }
        }
        System.out.print("}");
    }
}
