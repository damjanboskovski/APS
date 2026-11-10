package ArrayAndList.Task6;

import java.util.Scanner;

public class Main {
    public static class SLLNode<E>{
        protected E element;
        protected SLLNode<E> nextNode;

        public SLLNode(E element, SLLNode<E> nextNode){
            this.element = element;
            this.nextNode = nextNode;
        }
    }

    public static class SLL<E>{
        private SLLNode<E> firstNode;

        public SLL(){
            this.firstNode = null;
        }

        public void insertLast(E value){
            if(this.firstNode == null){
                this.firstNode = new SLLNode<>(value, null);
                return;
            }

            SLLNode<E> currentNode = this.firstNode;
            while(currentNode.nextNode != null){
                currentNode = currentNode.nextNode;
            }
            currentNode.nextNode = new SLLNode<>(value, null);
        }

        public void printList(){
            SLLNode<E> currentNode = this.firstNode;

            while(currentNode != null){
                System.out.print(currentNode.element);
                if(currentNode.nextNode != null){
                    System.out.print("->");
                }
                currentNode = currentNode.nextNode;
            }
            System.out.println();
        }

        public void moveStringWithLenToBeg(int lengthOfString){
            if(this.firstNode == null){
                return;
            }

            SLLNode<E> currentNode = this.firstNode;
            SLLNode<E> prevNode = null;

            SLLNode<E> targetNode = null;
            SLLNode<E> targetPrev = null;

            while(currentNode != null){
                if(((String)currentNode.element).length() == lengthOfString){
                    targetNode = currentNode;
                    targetPrev = prevNode;
                }
                prevNode = currentNode;
                currentNode = currentNode.nextNode;
            }

            if(targetNode == null || targetNode == this.firstNode){
                return;
            }

            targetPrev.nextNode = targetNode.nextNode;
            targetNode.nextNode = this.firstNode;
            this.firstNode = targetNode;

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        SLL<String> list = new SLL<>();

        for(int i = 0; i < num; i++){
            list.insertLast(sc.next());
        }

        list.printList();
        list.moveStringWithLenToBeg(sc.nextInt());
        list.printList();

        sc.close();
    }
}
