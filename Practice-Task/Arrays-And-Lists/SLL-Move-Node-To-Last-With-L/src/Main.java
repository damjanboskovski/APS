import java.util.Scanner;

public class Main{

    private static class Node {
        String data;
        Node nextNode;

        Node(String data) {
            this.data = data;
            this.nextNode = null;
        }
    }

    private static class SLL{
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

        public void moveNodeWithLength(int L){
            if(this.headNode == null){
                return;
            }

            Node frontTempNode = new Node(null);
            Node backTempNode = new Node(null);
            Node frontNode = frontTempNode;
            Node backNode = backTempNode;

            Node currentNode = this.headNode;
            while(currentNode != null){
                Node tempNode = currentNode.nextNode;
                currentNode.nextNode = null;
                if(currentNode.data.length() == L){
                    backNode.nextNode = currentNode;
                    backNode = currentNode;
                } else {
                    frontNode.nextNode = currentNode;
                    frontNode = currentNode;
                }
                currentNode = tempNode;
            }

            if(frontTempNode.nextNode == null){
                headNode = backTempNode.nextNode;
            } else {
                headNode = frontTempNode.nextNode;
                frontNode.nextNode = backTempNode.nextNode;
            }
        }
    }

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();

        SLL list = new SLL();
        for(int i = 0; i < num; i++){
           list.addToList(sc.nextLine());
        }

        list.printList();
        list.moveNodeWithLength(sc.nextInt());
        System.out.println();
        list.printList();
        sc.close();
    }
}