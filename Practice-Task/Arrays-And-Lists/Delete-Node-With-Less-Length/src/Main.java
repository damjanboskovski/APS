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

    private static class SLL{
        Node head;

        public void addToList(String data){
            Node newNode = new Node(data);
            if(head == null){
                this.head = newNode;
                return;
            }
            Node currentNode = this.head;
            while(currentNode.nextNode != null){
                currentNode = currentNode.nextNode;
            }
            currentNode.nextNode = newNode;
        }

        public void printList(){
            Node currentNode = head;

            while(currentNode != null){
                System.out.print(currentNode.data);
                if(currentNode.nextNode != null){
                    System.out.print("->");
                }
                currentNode = currentNode.nextNode;
            }
        }

        public void deleteShorterThanL(int L){
            while(this.head != null && this.head.data.length() < L){
                this.head = this.head.nextNode;
            }

            Node currentNode = this.head;
            Node previusNode = null;

            while(currentNode != null){
                if(currentNode.data.length() < L){
                    previusNode = currentNode.nextNode;
                    currentNode = currentNode.nextNode;
                } else {
                    previusNode = currentNode;
                    currentNode = currentNode.nextNode;
                }
            }
        }
    }

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();

        SLL list = new SLL();
        for(int i =  0; i < num; i++){
            String word = sc.nextLine();
            list.addToList(word);
        }
        list.printList();
        list.deleteShorterThanL(sc.nextInt());
        System.out.println();
        list.printList();
        sc.close();
    }

}