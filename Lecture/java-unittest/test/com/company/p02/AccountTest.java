package com.company.p02;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*; //assertThat
import static org.junit.Assert.*;

public class AccountTest {
    private Account account;

    //Before -> Test1 ->Before ->Test2실행
    //BeforeClass ->Before ->Test1-> (After) -> Before ->Test2 ->(After) -> (AfterClass)

    @BeforeClass
    public static void classSetUp() {
        //맨 처음 한번 실행
    }
    @Before
    public void setUpBySetBalanceOneHundred() {
        account = new Account(100); //1.Arrange
    }
    @Test
    public void answerIsMinusWithNegativeBalance() {
        account.withdraw(150); //2.Act
        boolean actualResult = account.isMinus();
        //boolean에 대한 assertion은 assertTrue나 assertFalse를 쓰면 좋다.
//        assertTrue(actualResult); //결과만 나옴
        assertThat(actualResult, equalTo(true)); //3.Assert
        //비교가능, 실패했을 때 정보를 잘 표현하기 위해서는 hamcrest의 CoreMatchers에 구현된 matcher를 쓰는 것이 좋다
//        assertThat(actualResult, is(equalTo(false))); //가독성 향상을 위한 is
        assertThat(actualResult,not(equalTo(false)));
    }
    @Test
    public void answerisNotMinusWithPositiveBalance() {
        account.withdraw(50);
        boolean actualResult = account.isMinus();

        assertThat(actualResult, is(not(equalTo(true))));
    }
    @Test
    public void checkPositiveBalanceAfterWithdrawal() {
        account.withdraw(80);
        int actualResult = account.getBalance();
        assertThat(actualResult, is(equalTo(20)));
    }
    @Test
    @Ignore("this will be tested later")// 되도록이면 남겨두지말아라
    public void checkNegativeBalanceAfterWithdrawal() {
        account.withdraw(80);
        int actualResult = account.getBalance();
        assertThat(actualResult, is(equalTo(-20)));
    }
  //ArithmeticException이 발생하는 지 assert하는 테스트

    //이 방법은 간단하다 하지만 인지적으로는 별로 좋지 않다.
    @Test(expected = ArithmeticException.class)
    public void checkExceptionByAnnotation() {
        account.throwException();
    }

    @Test
    public void checkExceptionByTryCatch() {
        try {
            account.throwException();
        } catch(ArithmeticException e) {
            assertThat(e.getClass(), equalTo(ArithmeticException.class));
        }
    }
}
