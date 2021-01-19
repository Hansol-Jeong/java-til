import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DoublyLinkedListInsertTest {
    LinkedList<Integer> doubLinkedList;
    @Before
    public void init() {
        doubLinkedList = new DoublyLinkedList<>();
    }
    @Test
    public void naiveInsertTest() {
        doubLinkedList.prepend(1);
        doubLinkedList.insert(1,3);
        doubLinkedList.insert(1,2);
        doubLinkedList.insert(1,4);
for (int i = 0; i< doubLinkedList.size()+1; i++) {
    System.out.println(doubLinkedList.access(i));
}
//        Assert.assertThat(doubLinkedList.access(1), CoreMatchers.is(1));
//        Assert.assertThat(doubLinkedList.access(2), CoreMatchers.is(3));
//        Assert.assertThat(doubLinkedList.access(1), CoreMatchers.is(2));
        Assert.assertThat(doubLinkedList.access(2), CoreMatchers.is(4));
    }

    @Test
    public void InsertSizeTest() {
        doubLinkedList.prepend(1);
        doubLinkedList.insert(1,3);
        doubLinkedList.insert(1,2);
        doubLinkedList.insert(1,4);
        Assert.assertThat(doubLinkedList.size(), CoreMatchers.is(4));

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void IndexOutOfBoundsExceptionTest() {
        doubLinkedList.prepend(1);
        doubLinkedList.insert(1,2);
        Assert.assertThat(doubLinkedList.access(1), CoreMatchers.is(2));
        doubLinkedList.insert(3,1);
    }

}