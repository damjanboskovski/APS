package ArrayAndList.Task5;

import java.util.Scanner;

public class Main {
    public static class SLLNode<E>{
        protected E element;
        protected SLLNode<E> next;

        public SLLNode(E element, SLLNode<E> next){
            this.element = element;
            this.next = next;
        }
    }

    public static class SLL<E>{
        private SLLNode<E> first;

        public SLL(){
            this.first = null;
        }

        public void insertLast(E value){
            if(this.first == null){
                this.first = new SLLNode<>(value, null);
                return;
            }

            SLLNode<E> current = this.first;
            while(current.next != null){
                current = current.next;
            }
            current.next = new SLLNode<>(value, null);
        }

        public void printList(){
            SLLNode<E> current = this.first;
            while(current != null){
                System.out.print(current.element);
                if(current.next != null){
                    System.out.print("->");
                }
                current = current.next;
            }
            System.out.println();
        }

        public void moveStringWithLenToEnd(int lengthOfString){
            if(this.first == null){
                return;
            }

            SLLNode<E> frontTempNode = new SLLNode<>(null, null);
            SLLNode<E> backTempNode = new SLLNode<>(null, null);
            SLLNode<E> frontNode = frontTempNode;
            SLLNode<E> backNode = backTempNode;

            SLLNode<E> current = this.first;
            while(current != null){
                SLLNode<E> tempNode = current.next;
                if(((String)current.element).length() == lengthOfString){
                    backNode.next = current;
                    backNode = current;
                } else {
                    frontNode.next = current;
                    frontNode = current;
                }
                current = tempNode;
            }

            backNode.next = null;

            if(frontTempNode.next == null){
                this.first = backTempNode.next;
            } else {
                this.first = frontTempNode.next;
                frontNode.next = backTempNode.next;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        SLL<String> list = new SLL<>();
        for (int i = 0; i < num; i++) {
            list.insertLast(sc.next());
        }

        list.printList();
        list.moveStringWithLenToEnd(sc.nextInt());
        list.printList();

        sc.close();
    }
}
