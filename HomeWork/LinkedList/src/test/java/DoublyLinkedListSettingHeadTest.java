import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DoublyLinkedListSettingHeadTest {
    LinkedList<Integer> doubLinkedList;
    @Before
    public void init() {
        doubLinkedList = new DoublyLinkedList<>();
    }
    @Test
    public void naiveSettingHeadTest() {
        doubLinkedList.append(3);
        doubLinkedList.append(1);
        Assert.assertThat(doubLinkedList.access(1), CoreMatchers.is(3));
        doubLinkedList.settingHead(1);
        Assert.assertThat(doubLinkedList.access(1), CoreMatchers.is(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void settingHeadIndexOverSizeTest() {
        doubLinkedList.append(3);
        doubLinkedList.append(1);
        doubLinkedList.settingHead(3);
    }


}