import java.util.Scanner;

public class Main {
    private static class Node {
        int data;
        Node nextNode;
        Node previousNode;

        Node(int data) {
            this.data = data;
            this.nextNode = null;
            this.previousNode = null;
        }
    }

    private static class DLL {
        Node headNode, tailNode;

        public void addToList(int data) {
            Node newNode = new Node(data);
            if (headNode == null) {
                this.headNode = newNode;
                this.tailNode = newNode;
            } else {
                this.tailNode.nextNode = newNode;
                newNode.previousNode = this.tailNode;
                this.tailNode = newNode;
            }
        }

        public void printList(){
            Node currentNode = this.headNode;
            while(currentNode != null){
                System.out.print(currentNode.data);
                if(currentNode.nextNode != null){
                    System.out.print("<->");
                }
                currentNode = currentNode.nextNode;
            }
        }

        public void rotateToRight(int k, int num){
            if(this.headNode == null || this.headNode == this.tailNode || k == 0){
                return;
            }

            k = k % num;
            if( k == 0 ){
                return;
            }

            Node newTail = this.headNode;
            for(int i = 0; i < num - k - 1; i++){
                newTail = newTail.nextNode;
            }

            Node newHead = newTail.nextNode;
            this.tailNode.nextNode = this.headNode;
            this.headNode.previousNode = this.tailNode;

            newTail.nextNode = null; newHead.previousNode = null;

            this.headNode = newHead; this.tailNode = newTail;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        DLL list = new DLL();
        for(int i = 0; i < num; i++) {
            list.addToList(sc.nextInt());
        }

        list.printList();
        System.out.println();
        list.rotateToRight(sc.nextInt(), num);
        list.printList();
        sc.close();
    }
}