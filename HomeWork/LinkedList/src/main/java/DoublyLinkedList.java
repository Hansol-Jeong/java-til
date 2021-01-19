import lombok.*;

@Getter
public class DoublyLinkedList<T> implements LinkedList<T>{
    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    class Node{
        private T value;
        private Node prev;
        private Node next;
    }

    public Node head; //이건 도대체 왜못쓰는데 -> 질문
    public Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void prepend(T value) {
        if(head == null) {
            head = new Node();
            Node newNode = new Node(value, head, null);
            head.setNext(newNode);
        }
        else {
            Node newNode = new Node(value, head, head.next);
            head.next.setPrev(newNode);
            head.next = newNode;
       }
        settingTail();

    }

    @Override
    public void append(T value) {
        if (head == null) {
            prepend(value);
        } else {
            Node newNode = new Node(value, tail.prev, tail);
            tail.prev.next = newNode;
            tail.prev = newNode;//tail설정
        }
    }

    @Override
    public void settingHead(int index) {
        if(index <= size()) {
            Node currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            head = currentNode;
            head.prev = null;
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public T access(int index) {
        Node currentNode = head;
        if(index <= size() + 1) {
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            return currentNode.value;
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }
    public Node accessNode(int index) {
        Node currentNode = head;
        if(index <= size() + 1) {
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            return currentNode;
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean insert(int index, T value) {
        if(index >= 1 && index <= size()) {
            Node current = accessNode(index);
            Node newNode = new Node(value, current.prev, current);//
            current.prev.next = newNode;
            current.prev = newNode;
        return true;
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void print() {
        String result = "";
        for(int i = 1; i < size(); i++) {
            result = result + access(i) + ", ";
        }
       result = result + access(size());
        result =  "[" + result + "]";
        System.out.println(result);
    }

    @Override
    public int size() {
       if(head == null) {
           return 0;
       }
       else {
           int count = 0;
           Node currentNode = head;
           while(currentNode.next.value != null) {
               count ++;
               currentNode = currentNode.next;
           }
           return count;
       }
    }
    public void settingTail() {
        Node currentNode = head;
        while(currentNode.next != null) {
            currentNode = currentNode.next;
        }
        tail = new Node(null, currentNode, null);
        currentNode.next = tail;

    }
}
