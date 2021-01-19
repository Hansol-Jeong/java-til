import org.junit.Test;

import static org.junit.Assert.*;

public class CircularQueueTest {
    @Test
    public void test() {
        CircularQueue queue = new CircularQueue(5);
        System.out.println(queue);

        queue.put(1);
        queue.put(2);
        queue.put(3);
        System.out.println(queue);

        System.out.println((queue.get()));
        System.out.println((queue.get()));
        System.out.println((queue.get()));
//        System.out.println((queue.get()));
        System.out.println(queue);

    }

}