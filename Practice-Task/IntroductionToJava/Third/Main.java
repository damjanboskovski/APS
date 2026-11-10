package IntroductionToJava.Third;

// За потребите на софтвер за евиденција на приходите остварени од вработените во одделот за продажба,
// да се дефинира класа QuarterlySales во која се чуваат бројот на продажби остварени во одреден квартал,
// приходот добиен од секоја продажба и бројот на кварталот.
//
// Потоа, да се дефинира друга класа SalesPerson за кој се чува име (string) и низа од квартали (точно 4).
// За класите да се имплементираат соодветните конструктори и методи за правилно извршување на програмата.
// Да се имплементираат следните барања:
//
//• Метод int sumSales(SalesPerson sp) кој ќе врати сума од сите приходи остварени од дадениот вработен
// во одделот за продажба во сите квартали.
//
//• Метод SalesPerson salesChampion(SalesPerson [] arr) кој за дадената низа од работници ќе го врати
// работникот со најголем остварен приход (од сите квартали).
//
//• Да се дополни main методот во кој ќе се иницијализира низа од вработени во одделот за продажба и
// квартали согласно влезните тест примери. Во првиот ред се чита број на вработени, а понатаму прво во еден ред се чита името, па за секој квартал во еден ред бројот на продажби, и во следниот ред приходот добиен од секоја од тие продажби.
//
//• На стандарден излез да се испечати низата од вработени во одделот за продажба со помош на методата
// void table(SalesPerson [] arr) која за низата од вработени ќе отпечати приказ во следниот формат (за простор при печатење се користат три празни места):

//Input: 5
//Damian
//3
//2000 1500 1000
//5
//1000 1300 2500 800 1100
//2
//3000 2000
//1
//1700
//Samantha
//4
//1500 2000 1700 1200
//6
//900 1200 1800 1100 1500 1300
//3
//2500 3000 2000
//5
//800 1000 1300 1200 900
//Jackson
//5
//1300 1500 1600 1200 1400
//4
//1700 2100 2000 1900
//6
//900 1200 1500 1800 2000 2200
//7
//500 700 900 1100 1300 1500 1700
//Olivia
//2
//3500 3000
//3
//2000 2500 3000
//4
//1500 1800 2100 2400
//5
//1000 1300 1600 1900 2200
//Liam
//6
//1100 1400 1700 2000 2300 2600
//7
//500 700 900 1100 1300 1500 1700
//8
//800 1000 1200 1400 1600 1800 2000 2200
//3
//2700 3000 3300


//Output: SP   1   2   3   4   Total
//Damian   4500   6700   5000   1700   17900
//Samantha   6400   7800   7500   5200   26900
//Jackson   7000   7700   9600   7700   32000
//Olivia   6500   7500   7800   8000   29800
//Liam   11100   7700   12000   9000   39800
//
//SALES CHAMPION: Liam

//Given Code import java.util.Scanner;
//
//class QuarterlySales {
//
//    private int numOfSales;
//    private int [] revenues;
//    private int quarterNo;
//
//    public QuarterlySales(int numOfSales, int[] revenues, int quarterNo) {
//        this.numOfSales = numOfSales;
//        this.revenues = revenues;
//        this.quarterNo = quarterNo;
//    }
//    @Override
//    public String toString() {
//
//    }
//
//}
//
//class SalesPerson {
//
//    private String name;
//    private QuarterlySales [] quarters;
//
//    public SalesPerson(String name, QuarterlySales[] quarters) {
//        this.name = name;
//        this.quarters = quarters;
//    }
//    @Override
//    public String toString() {
//
//    }
//
//}
//
//
//
//public class Main {
//
//    public static SalesPerson salesChampion(SalesPerson [] arr)
//    {
//
//    }
//    public static void table(SalesPerson [] arr)
//    {
//
//
//    }
//
//    public static void main(String[] args) {
//
//        int n;
//        Scanner input = new Scanner(System.in);
//        n = input.nextInt();
//        SalesPerson [] arr = new SalesPerson[n];
//        for(int i=0;i<n;i++)
//        {
//            //your code goes here
//        }
//
//        table(arr);
//        System.out.println("SALES CHAMPION: " + salesChampion(arr).getName());
//
//    }
//}


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
        for(int i = 0; i < this.numOfSales; i++){
            sum += revenues[i];
        }
        return sum;
    }

    @Override
    public String toString() {
        return quarterNo + " " + totalRev();
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

        for(int i = 0; i < quarters.length; i++){
            int quarterlyInvestment = quarters[i].totalRev();
            total += quarterlyInvestment;
            sb.append("   ").append(quarterlyInvestment);
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
        SalesPerson bestSeller = arr[0];
        int bestSum = sumSales(arr[0]);

        for(int i = 0; i < arr.length; i++){
            int currentSum = sumSales(arr[i]);
            if(currentSum > bestSum){
                bestSum = currentSum;
                bestSeller = arr[i];
            }
        }
        return bestSeller;
    }

    public static void table(SalesPerson [] arr)
    {
        System.out.println("SP   1   2   3   4   Total");
        for(SalesPerson sp : arr){
            System.out.println(sp);
        }
    }

    public static QuarterlySales readQuarter(Scanner in, int quarterNumber){
        int numSales = in.nextInt();
        int[] revenue = new int[numSales];

        for(int i = 0; i < numSales; i++){
            revenue[i] = in.nextInt();
        }

        return new QuarterlySales(numSales, revenue, quarterNumber);
    }

    public static SalesPerson readSalesPerson(Scanner in){
        String name = in.next();
        QuarterlySales[] qs = new QuarterlySales[4];

        for(int i = 0; i < 4; i++){
            qs[i] = readQuarter(in, i + 1);
        }

        return new SalesPerson(name, qs);
    }

    public static void main(String[] args) {

        int n;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        SalesPerson [] arr = new SalesPerson[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = readSalesPerson(input);
        }

        table(arr);
        System.out.println("SALES CHAMPION: " + salesChampion(arr).getName());
    }
}