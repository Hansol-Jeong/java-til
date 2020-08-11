package p01;
/**
 * AbstractStack->Stack
 *
 * is_empty()
 * push()
 * pop()
 * peek()
 */
abstract class Ab{
    protected int capacity;
    protected int top=0;

    public Ab(int capacity) {
        this.capacity = capacity;
        this.top = 0;
    }
    public boolean isEmpty() {
        return this.top == 0;
    }
    public abstract void push(int value);
    public abstract int pop();
    public abstract int peek();
}
class AS extends Ab {
    private int [] array;

    public AS(int capacity) {
        super(capacity);
        array = new int[capacity];
    }

    @Override
    public void push(int value) {
        if (top == capacity) {
            int [] new_array = new int[capacity * 2];
            System.arraycopy(array,0,new_array, 0, array.length);
            array = new_array;
        }
        array[top++]=value;
    }

    @Override
    public int pop() {
        if(isEmpty())
            return -1;
        return array[--top];
    }

    @Override
    public int peek() {
        if(isEmpty())
            return -1;
        return array[top-1];
    }
}
public class AbstractClassPractice_Practice {
    public static void main(String[] args) {
        AS as = new AS(10);
        for (int i=0; i < 15; i++){
            as.push(i);
        }
        System.out.println(as.peek());

        for(int i=0; i < 21; i++) {
            System.out.println(as.pop());
        }
    }
}
