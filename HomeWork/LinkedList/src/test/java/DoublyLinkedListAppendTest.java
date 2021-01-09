import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DoublyLinkedListAppendTest {
    LinkedList<Integer> doubLinkedList;
    @Before
    public void init() {
        doubLinkedList = new DoublyLinkedList<>();
    }
    @Test
    public void appendSizeTest() {
        doubLinkedList.append(3);
        Assert.assertThat(doubLinkedList.size(), CoreMatchers.is(1));
        doubLinkedList.append(1);
        Assert.assertThat(doubLinkedList.size(), CoreMatchers.is(2));
    }

    @Test
    public void appendAccessTest() {
        doubLinkedList.append(3);
        doubLinkedList.append(1);
        Assert.assertThat(doubLinkedList.access(1), CoreMatchers.is(3));
        Assert.assertThat(doubLinkedList.access(2), CoreMatchers.is(1));
    }
    @Test(expected = NullPointerException.class)
    public void prependHead_TailTest() {
        doubLinkedList.append(3);
        doubLinkedList.append(1);
        doubLinkedList.append(2);

        System.out.println(doubLinkedList.size());
        for (int i = 0; i < doubLinkedList.size() + 3; i++) {
            System.out.println(doubLinkedList.access(i));
        }
    }
}