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
        //뭐가 있는 경우 다시 prepend를 쏴주면 사이즈가 2가 되어야 함
        doubLinkedList.append(1);
        Assert.assertThat(doubLinkedList.size(), CoreMatchers.is(2));
    }

    @Test
    public void appendAccessTest() {
        //첫 번쨰 인덱스는 3, 두 번째 인덱스는 1이어야 해
        doubLinkedList.append(3);
        doubLinkedList.append(1);
        Assert.assertThat(doubLinkedList.access(1), CoreMatchers.is(3));
        Assert.assertThat(doubLinkedList.access(2), CoreMatchers.is(1));
    }
    @Test(expected = NullPointerException.class)
    public void prependHead_TailTest() {
        //head 의 next는 2여야 하고 tail의 prev는 3이어야 해
        doubLinkedList.append(3);
        doubLinkedList.append(1);
        doubLinkedList.append(2);

        System.out.println(doubLinkedList.size());//여기부터 디버그해봐 뭔가 이상해 next에 계속있어
        for (int i = 0; i < doubLinkedList.size() + 3; i++) {
            System.out.println(doubLinkedList.access(i));
        }
    }
}