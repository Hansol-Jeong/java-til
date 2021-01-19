import org.junit.Test;

import static org.junit.Assert.*;

public class LinearQueueTest {
@Test
    public void test() {
    LinearQueue queue = new LinearQueue(5);
    System.out.println(queue);

    queue.put(1);
    queue.put(2);
    queue.put(3);
    System.out.println(queue);

    System.out.println((queue.get()));
    System.out.println((queue.get()));
    System.out.println((queue.get()));
    System.out.println((queue.get()));
    System.out.println(queue);

    queue.put(4);
    queue.put(5);
    queue.put(6);
    System.out.println(queue);

    System.out.println((queue.get()));
    System.out.println((queue.get()));
    System.out.println((queue.peek()));
    System.out.println((queue.peek()));
    System.out.println((queue.get()));
    System.out.println(queue);
}
}