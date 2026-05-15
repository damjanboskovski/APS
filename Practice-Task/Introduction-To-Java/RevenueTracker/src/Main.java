import java.util.Scanner;

class QuarterlySales {

    private int numOfSales;
    private int [] revenues;
    private int quarterNo;

    public QuarterlySales(int numOfSales, int[] revenues, int quarterNo) {
        this.numOfSales = numOfSales;
        this.revenues = revenues;
        this.quarterNo = quarterNo;
    }

    public int totalRev(){
        int sum = 0;
        for(int i = 0; i < numOfSales; i++){
            sum += revenues[i];
        }
        return sum;
    }
    @Override
    public String toString() {
        return "Q" + quarterNo +" - " + totalRev();
    }

}

class SalesPerson {

    private String name;
    private QuarterlySales [] quarters;

    public SalesPerson(String name, QuarterlySales[] quarters) {
        this.name = name;
        this.quarters = quarters;
    }

    public QuarterlySales[] getQuarters(){
        return this.quarters;
    }

    public String getName(){
        return this.name;
    }
    @Override
    public String toString() {
        int total = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        for(int i=0; i< quarters.length; i++){
            int qi = quarters[i].totalRev();
            total += qi;
            sb.append("   ").append(qi);
        }
        sb.append("   ").append(total);
        return sb.toString();
    }

}

public class Main {

    public static int sumSales(SalesPerson sp){
        int sum = 0;
        for(QuarterlySales qs : sp.getQuarters()){
            sum += qs.totalRev();
        }

        return sum;
    }
    public static SalesPerson salesChampion(SalesPerson [] arr)
    {
        SalesPerson bestSalePerson = arr[0];
        int bestSum = sumSales(arr[0]);
        for(int i = 1; i < arr.length; i++){
            int currSum = sumSales(arr[i]);
            if(currSum > bestSum){
                bestSum = currSum;
                bestSalePerson = arr[i];
            }
        }
        return bestSalePerson;
    }

    public static void table(SalesPerson [] arr)
    {
        System.out.println("SP   1   2   3   4   Total");
        for(SalesPerson sp : arr){
            System.out.println(sp);
        }
    }

    public static void main(String[] args) {

        int n;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        SalesPerson [] arr = new SalesPerson[n];
        for(int i=0;i<n;i++)
        {
            String name = input.next();
            QuarterlySales[] qs = new QuarterlySales[4];

            for(int j=0; j < 4; j++){
                int numSales = input.nextInt();
                int[] revenue = new int[numSales];
                for(int k=0; k<numSales; k++){
                    revenue[k] = input.nextInt();
                }
                qs[j] = new QuarterlySales(numSales, revenue, j + 1);
            }

            arr[i] = new SalesPerson(name, qs);
        }

        table(arr);
        System.out.println("SALES CHAMPION: " + salesChampion(arr).getName());

    }
}