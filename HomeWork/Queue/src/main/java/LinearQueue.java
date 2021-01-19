import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinearQueue implements Queue {
    private int capacity;
    private int front;
    private int rear;
    private int[] array;

    public LinearQueue(int capacity) {
        this.capacity = capacity;
        this.front = 0;
        this.rear = 0;
        this.array = new int[capacity];
    }

    @Override
    public boolean put(int value) {
        if(rear + 1 < capacity) {
            array[rear] = value;
            rear++;
            return true;
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public int get() {
        try {
                return array[front];
            } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        finally {
            front = front + 1;
        }
        return 0;
    }

    @Override
    public int peek() {
        return array[front];
    }

    @Override
    public String toString() {
        String string = "";
        for(int i = front; i < rear + 1; i++) {
            string = string + array[i] + ",";
        }
        return string;
    }

}
