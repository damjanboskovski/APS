package ArrayAndList.Task3;

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

        @SuppressWarnings("unchecked")
        public void insertAfterLenString(int lengthOfString){
            SLLNode<E> current = this.first;
            while(current != null){
                if(((String)current.element).length() == lengthOfString){
                    SLLNode<E> newNode = new SLLNode<>((E) "Target", current.next);
                    current.next = newNode;
                    current = newNode.next;
                } else {
                    current = current.next;
                }
            }
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
        list.insertAfterLenString(sc.nextInt());
        list.printList();

        sc.close();
    }
}
