import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DoublyLinkedListPrependTest {
//TDD -> 비즈니스 코드 작성 전 예상 가능한 모든 경우의 수 테스트 케이스 작성
    LinkedList<Integer> doubLinkedList;
   @Before
        public void init() {
        doubLinkedList = new DoublyLinkedList<>();
   }
    @Test
    public void isEmptyTest() {

        Assert.assertThat(doubLinkedList.isEmpty(), CoreMatchers.is(true));
    }//지워 졌을 경우

    @Test
    public void prependSizeTest() {//도대체 왜 doub~.getHead가 안되는건데

        doubLinkedList.prepend(3);
        Assert.assertThat(doubLinkedList.size(), CoreMatchers.is(1));

        doubLinkedList.prepend(1);
        Assert.assertThat(doubLinkedList.size(), CoreMatchers.is(2));
    }
    @Test
    public void prependAccessTest() {

        doubLinkedList.prepend(3);
        doubLinkedList.prepend(1);
        Assert.assertThat(doubLinkedList.access(1), CoreMatchers.is(1));
        Assert.assertThat(doubLinkedList.access(2), CoreMatchers.is(3));
    }
    @Test(expected = NullPointerException.class)
    public void prependHead_TailTest() {

        doubLinkedList.prepend(3);
        doubLinkedList.prepend(1);
        doubLinkedList.prepend(2);

        System.out.println(doubLinkedList.size());//여기부터 디버그해봐 뭔가 이상해 next에 계속있어
        for( int i = 0; i< doubLinkedList.size() + 3; i++) {
            System.out.println(doubLinkedList.access(i));
        }

//        Assert.assertThat(doubLinkedList.head.next);
//        Assert.assertThat(doubLinkedList.tail.prev);
    }
}