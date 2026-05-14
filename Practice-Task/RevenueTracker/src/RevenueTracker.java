import java.util.Scanner;

public class RevenueTracker{
    class QuarterlySales {

        private int numOfSales;
        private int [] revenues;
        private int quarterNo;

        public QuarterlySales(int numOfSales, int[] revenues, int quarterNo) {
            this.numOfSales = numOfSales;
            this.revenues = revenues;
            this.quarterNo = quarterNo;
        }

        public int totalRevenue(){
            int sum = 0;
            for(int r : revenues){
                sum += r;
            }
            return sum;
        }

        int getQuarterNo(){
            return quarterNo;
        }

        int getNumOfSales(){
            return numOfSales;
        }

    }

    class SalesPerson {

        private String name;
        private QuarterlySales [] quarters;

        public SalesPerson(String name, QuarterlySales[] quarters) {
            this.name = name;
            this.quarters = quarters;
        }

        int totalRevenue(){
            int sum = 0;
            for(QuarterlySales q : quarters){
                sum += q.totalRevenue();
            }
            return sum;
        }

        public String getName(){
            return name;
        }

        public QuarterlySales[] getQuarters(){
            return quarters;
        }

    }



    public class Main {
        public static int sumSales(SalesPerson sp){
            return sp.totalRevenue();
        }

        public static SalesPerson salesChampion(SalesPerson [] arr)
        {
            SalesPerson best = arr[0];
            int bestSum = sumSales(arr[0]);
            for(int i = 1; i < arr.length; i++){
                int curSum = sumSales(arr[i]);
                if(curSum > bestSum){
                    bestSum = curSum;
                    best = arr[i];
                }
            }
            return best;
        }
        public static void table(SalesPerson [] arr)
        {
            System.out.println("SP   1   2   3   4   Total");
            for(SalesPerson sp : arr){
                System.out.print(sp.getName());
                QuarterlySales [] qs = sp.getQuarters();
                for(int i = 0; i < qs.length; i++){
                    System.out.print("  " + qs[i].totalRevenue());
                }
                System.out.println("    " + sp.totalRevenue());

            }

        }

        public static void main(String[] args) {

            int n;
            Scanner input = new Scanner(System.in);
            n = input.nextInt();
            SalesPerson [] arr = new SalesPerson[n];
            for(int i=0;i<n;i++)
            {
                //your code goes here
            }

            table(arr);
            System.out.println("SALES CHAMPION: " + salesChampion(arr).getName());

        }
    }
}