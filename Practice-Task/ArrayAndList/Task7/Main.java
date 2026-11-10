package ArrayAndList.Task7;

import java.util.Scanner;

public class Main {
    public static class DLLNode<E>{
        protected E element;
        protected DLLNode<E> prevNode;
        protected DLLNode<E> nextNode;

        public DLLNode(E element, DLLNode<E> prevNode, DLLNode<E> nextNode){
            this.element = element;
            this.prevNode = prevNode;
            this.nextNode = nextNode;
        }
    }

    public static class DLL<E>{
        private DLLNode<E> firstNode;
        private DLLNode<E> lastNode;

        public DLL(){
            this.firstNode = null;
            this.lastNode = null;
        }

        public void insertLast(E value){
            if(this.firstNode == null){
                DLLNode<E> newNode = new DLLNode<>(value, null, null);
                this.firstNode = newNode;
                this.lastNode = newNode;
                return;
            }

            DLLNode<E> newNode = new DLLNode<>(value, this.lastNode, null);
            this.lastNode.nextNode = newNode;
            this.lastNode = newNode;
        }

        public void printList(){
            DLLNode<E> currentNode = this.firstNode;
            while(currentNode != null){
                System.out.print(currentNode.element);
                if(currentNode.nextNode != null){
                    System.out.print("<->");
                }
                currentNode = currentNode.nextNode;
            }
            System.out.println();
        }

        public void rotateRight(int k){
            if(this.firstNode == null || this.firstNode == this.lastNode || k <= 0){
                return;
            }
            int cnt = 0;
            DLLNode<E> currentNode = this.firstNode;
            while(currentNode != null){
                cnt++; currentNode = currentNode.nextNode;
            }

            k = k % cnt;
            if(k == 0){
                return;
            }

            int stepsToNewLast = cnt - k;
            DLLNode<E> newLast = this.firstNode;
            for(int i = 1; i < stepsToNewLast; i++){
                newLast = newLast.nextNode;
            }

            DLLNode<E> newFirst = newLast.nextNode;

            this.lastNode.nextNode = this.firstNode;
            this.firstNode.prevNode = this.lastNode;

            newLast.nextNode = null;
            newFirst.prevNode = null;

            this.firstNode = newFirst;
            this.lastNode = newLast;
        }
    }
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        DLL<Integer> list = new DLL<>();
        for(int i = 0; i < num; i++){
            list.insertLast(sc.nextInt());
        }

        list.printList();
        list.rotateRight(sc.nextInt());
        list.printList();
        sc.close();
    }
}
