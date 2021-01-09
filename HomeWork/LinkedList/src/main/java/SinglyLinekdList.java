import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;




class SinglyLinkedList<T> implements LinkedList<T> {//왜 퍼블릭이면 안되지 이렇게 내부 클래스로 만드는게 맞나? 이상한데 그렇게안하면 제네릭 타입을 어떻게 공유시키지
    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    class Node {
        private T value;
        private Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    public Node head;

    public SinglyLinkedList() {
//        this.head = null;
        head = new Node();//nullException계속나서 이렇게 해줬는데 안되나요? 네 안되요
    }


    @Override
    public boolean isEmpty() {
        if(head == null)
            return true;
        else
            return false;
    }

    @Override
    public void prepend(T value) {//새로운 노드만들어 -> 새로운 노드를 첫번쨰 노드에 연결해 -> head를 새로운 노드에 연결해
        //일단 next가 있는지부터 확인해볼까?
        Node newNode;
        Node currentNode= head;
        if(head != null) { //쉬운가정 = 다음 노드가 있어
           newNode = new Node(value,head.next);//새 노드랑 다음 노드랑 연결했어
            head.next = newNode;// head 연결 바꿔줬어
        }
        else {//다음 노드가 없을 경우야
//            head = new Node(); //nullException안나게 이렇게 했는데 이게 맞는걸까 좀더 나은 방법이 없을까
            newNode = new Node(value,null);//다음으로 연결되는 경우는 없고
            head.next = newNode;//헤드는 null이 아닌 새 노드로 잡아줬어
        }

    }

    @Override
    public void append(T value) {
        Node newNode = new Node(value, null);//맨뒤에 붙이는 거니까
        Node currentNode = head;
        while(currentNode.next != null) {
            currentNode = currentNode.next;
        }
        //세상끝까지 왔다
        currentNode.next = newNode;
    }

    @Override
    public void settingHead(int index) {//인덱스는 0부터
        try {//try-catch쓰면 안되요 if 분기로 실패출력 thorw 던져쥼

                Node currentNode = head;//0
            if(index == 0) {
              //  아무것도 안해
            }
            else {
                for (int i = 0; i < index; i++) {
                    currentNode = currentNode.next;//인덱스가 사이즈 이하이고, 0 도 아니니까 인덱스 만큼 이동시켜줌
                }
                head.next = currentNode.next;
            }
        } catch (NullPointerException e) {
            e.printStackTrace();// index
        }
    }

    @Override
    public T access(int index) {
        Node currentNode = head;
        try {// 요고 수정
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(currentNode);
        return currentNode.getValue();
    }

    @Override
    public boolean insert(int index, T value) {
        //깡통에 넣을 때
        //{앞에 뭔가 있을 때
        //뒤에도 뭔가 있을 때}
        try {
            if (head.next == null && index == 0) {
                prepend(value);
                return true;
            } else if (index <= size() - 1){
                Node currentNode = head;
                for (int i = 0; i < index - 1; i++) {
                    currentNode = currentNode.next;
                }
                Node newNode = new Node(value, currentNode.next);// 연결지어주고
                currentNode.next = newNode;// 연결지어주고
                return true;
            }
            else  {
                append(value);//이부분 수정
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void print() {
    }

    @Override
    public int size() {
        int counter = 0;
        Node currentNode = head;
        if(head != null) {
            while(currentNode.next != null) {
                counter++;
                currentNode = currentNode.next;
            }
        }
        return counter;
    }

//    public void insert(int index, int value)
  /*  prepend(value) {

    }

    append(value) {

    }

    setHead(index) {

    }

    access(index) {

    }

    insert(index, value) {

    }

    remove(index) {

    }

    print() {

    }*/
}