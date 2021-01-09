import org.junit.Before;
import org.junit.Test;

public class DoublyLinkedListPrintTest {
    LinkedList<Integer> doubLinkedList;
    @Before
    public void init() {
        doubLinkedList = new DoublyLinkedList<>();
    }
    @Test
    public void printTest() {
        doubLinkedList.prepend(1);
        doubLinkedList.insert(1,3);
        doubLinkedList.insert(1,2);
        doubLinkedList.insert(1,4);

        doubLinkedList.print();
    }
}