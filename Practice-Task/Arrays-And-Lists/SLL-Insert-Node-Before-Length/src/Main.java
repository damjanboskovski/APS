import java.util.Scanner;

public class Main{
    private static class Node{
        String data;
        Node nextNode;

        Node(String data){
            this.data = data;
            this.nextNode = null;
        }
    }

    private static class  SLL{
        Node headNode;

        public void addToList(String data){
            Node newNode = new Node(data);
            if(this.headNode == null){
                this.headNode = newNode;
                return;
            }
            Node currentNode = this.headNode;
            while(currentNode.nextNode != null){
                currentNode = currentNode.nextNode;
            }
            currentNode.nextNode = newNode;
        }

        public void printList(){
            Node currentNode = this.headNode;
            while(currentNode != null){
                System.out.print(currentNode.data);
                if(currentNode.nextNode != null){
                    System.out.print("->");
                }
                currentNode = currentNode.nextNode;
            }
        }

        public void addNodeBeforeLength(int L){
            Node currentNode = this.headNode;
            Node previousNode = null;

            while(currentNode != null){
                if(currentNode.data.length() > L){
                    Node newNode = new Node("Outlier");

                    if(previousNode == null){
                        newNode.nextNode = headNode;
                        headNode = newNode;
                    } else {
                        newNode.nextNode = currentNode;
                        previousNode.nextNode = newNode;
                    }

                    previousNode = currentNode;
                    currentNode = currentNode.nextNode;
                } else {
                    previousNode = currentNode;
                    currentNode = currentNode.nextNode;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();

        SLL list = new SLL();
        for(int i = 0; i < num; i++){
            String word = sc.nextLine();
            list.addToList(word);
        }

        list.printList();
        list.addNodeBeforeLength(sc.nextInt());
        System.out.println();
        list.printList();
        sc.close();
    }
}