import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DoublyLinkedListAccessTest {
    LinkedList<Integer> doubLinkedList;

    @Before
    public void init() {
        doubLinkedList = new DoublyLinkedList<>();
    }

    @Test
    public void naiveAccessTest() {

        doubLinkedList.prepend(3);
        doubLinkedList.prepend(1);

        Assert.assertThat(doubLinkedList.access(1), CoreMatchers.is(1));
        Assert.assertThat(doubLinkedList.access(2), CoreMatchers.is(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void overIndexAccessTest() {
        doubLinkedList.access(1);
    }
}