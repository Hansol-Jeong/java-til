import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListLastTest {
    LinkedList<Integer> doubLinkedList;
    @Before
    public void init() {
        doubLinkedList = new DoublyLinkedList<>();
    }
    @Test
    public void integrationTest() {
        Assert.assertThat(doubLinkedList.isEmpty(), CoreMatchers.is(true));
        doubLinkedList.prepend(1);
        Assert.assertThat(doubLinkedList.access(1), CoreMatchers.is(1));
        doubLinkedList.append(2);
        Assert.assertThat(doubLinkedList.access(2), CoreMatchers.is(2));
        doubLinkedList.settingHead(1);
        Assert.assertThat(doubLinkedList.access(1), CoreMatchers.is(2));
        doubLinkedList.insert(1,3);
        Assert.assertThat(doubLinkedList.access(1), CoreMatchers.is(3));
        Assert.assertThat(doubLinkedList.size(), CoreMatchers.is(2));
        doubLinkedList.print();
    }
}