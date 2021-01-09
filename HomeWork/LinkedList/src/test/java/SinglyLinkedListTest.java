import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SinglyLinkedListTest {
    SinglyLinkedList<Integer> integerSinglyLinkedList;
    SinglyLinkedList<String> stringSinglyLinkedList;
    @Before
    public void init() {
//       LinkedList<Integer> list = new SinglyLinkedList<>(); 이ㅓㄱ왜안되는데ㅓ램절딜
        integerSinglyLinkedList = new SinglyLinkedList<>();
        stringSinglyLinkedList = new SinglyLinkedList<>();
    }

    @Test
    public void isEmpty() {
        Assert.assertThat(integerSinglyLinkedList.isEmpty(), CoreMatchers.is(true));
        Assert.assertThat(stringSinglyLinkedList.isEmpty(), CoreMatchers.is(true));
    }

    @Test
    public void prepend() {
        //Integer일 경우
        integerSinglyLinkedList.prepend(3);
        stringSinglyLinkedList.prepend("홀리몰리");
        Assert.assertThat(integerSinglyLinkedList.size(), CoreMatchers.is(1));
        Assert.assertThat(stringSinglyLinkedList.size(), CoreMatchers.is(1));
        //지금 내가하는 테스트가 맞는건지 어떻게 아는가
    }//access를 통한 체크, 사이즈 체크 && 값 체크 다른 메소드로서
    //아무것도 작성 안한 상태에서 오른쪽에 테스트 먼저작성 -> 여러개 테스트먼저작성(난이도별) -> 통과 다 될때까지 왼쪽 수정 -> 테스트 수정 -> 다시 구현

    @Test//테스트 할 때마다 초기화되요?  ㅇㅇ TDD ->무조건 x 유닛테스트는 무조건
    public void append() {
        integerSinglyLinkedList.append(5);
        integerSinglyLinkedList.append(10);
        stringSinglyLinkedList.append("롤리폴리");
        stringSinglyLinkedList.append("롤리롤리폴리");
        Assert.assertThat(integerSinglyLinkedList.size(), CoreMatchers.is(2));
        Assert.assertThat(integerSinglyLinkedList.size(), CoreMatchers.is(2));
    }

    @Test
    public void setHead() {
        integerSinglyLinkedList.append(5);
        integerSinglyLinkedList.append(10);
        integerSinglyLinkedList.settingHead(1);
        Assert.assertThat(integerSinglyLinkedList.size(), CoreMatchers.is(1));
//        integerSinglyLinkedList.setHead(2);//이게 에러가 안나면 안되는데
    }

    @Test
    public void access() {
        integerSinglyLinkedList.append(5);
        Assert.assertThat(integerSinglyLinkedList.access(1), CoreMatchers.is(5));
    }

    @Test
    public void insert() {
        integerSinglyLinkedList.insert(0,1);
        Assert.assertThat(integerSinglyLinkedList.access(1), CoreMatchers.is(1));
        integerSinglyLinkedList.insert(0,2);
        Assert.assertThat(integerSinglyLinkedList.access(1),CoreMatchers.is(2));
    }
}