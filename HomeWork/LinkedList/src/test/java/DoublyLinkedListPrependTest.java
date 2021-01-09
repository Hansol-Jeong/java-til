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
        //노드가 비어있는지 검사를 하고싶다면 -> 다필요없고 그냥 head == null 이면 충분해
        Assert.assertThat(doubLinkedList.isEmpty(), CoreMatchers.is(true));
    }

    @Test
    public void prependSizeTest() {//도대체 왜 doub~.getHead가 안되는건데
        //처음 연결하는 경우 사이즈는 1 이어야 함
        doubLinkedList.prepend(3);
        Assert.assertThat(doubLinkedList.size(), CoreMatchers.is(1));
        //뭐가 있는 경우 다시 prepend를 쏴주면 사이즈가 2가 되어야 함
        doubLinkedList.prepend(1);
        Assert.assertThat(doubLinkedList.size(), CoreMatchers.is(2));
    }
    @Test
    public void prependAccessTest() {
       //첫 번쨰 인덱스는 3, 두 번째 인덱스는 1이어야 해
        doubLinkedList.prepend(3);
        doubLinkedList.prepend(1);
        Assert.assertThat(doubLinkedList.access(1), CoreMatchers.is(1));
        Assert.assertThat(doubLinkedList.access(2), CoreMatchers.is(3));
    }
    @Test(expected = NullPointerException.class)
    public void prependHead_TailTest() {
        //head 의 next는 2여야 하고 tail의 prev는 3이어야 해
        doubLinkedList.prepend(3);
        doubLinkedList.prepend(1);
        doubLinkedList.prepend(2);

        System.out.println(doubLinkedList.size());//여기부터 디버그해봐 뭔가 이상해 next에 계속있어
        for( int i = 0; i< doubLinkedList.size() + 3; i++) {
            System.out.println(doubLinkedList.access(i));
        }

//        Assert.assertThat(doubLinkedList.head.next); 이게 왜안됭애ㅑㅓㄷ래매럼ㅈ딜
//        Assert.assertThat(doubLinkedList.tail.prev);
    }
}