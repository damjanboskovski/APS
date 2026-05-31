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
        Node headNode;

        public void addToList(String data){
            Node newNode = new Node(data);
            while(this.headNode == null){
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

        public void moveNodesInFront(int L){
            if(this.headNode == null){
                return;
            }

            Node currentNode = this.headNode;
            Node previousNode = null;

            Node lastMatch = null;
            Node previousLastMatch = null;

            while(currentNode != null){
                if(currentNode.data.length() == L){
                    lastMatch = currentNode;
                    previousLastMatch = previousNode;
                }
                previousNode = currentNode;
                currentNode = currentNode.nextNode;
            }

            if(lastMatch == null && previousLastMatch == null){
                return;
            }

            previousLastMatch.nextNode = lastMatch.nextNode;
            lastMatch.nextNode = headNode;
            headNode = lastMatch;
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
        list.moveNodesInFront(sc.nextInt());
        System.out.println();
        list.printList();
        sc.close();
    }
}