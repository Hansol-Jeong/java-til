public class CircularQueue implements Queue {
    private int capacity;
    private int front;
    private int rear;
    private int[] array;
    private boolean isFull;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.front = 0;
        this.rear = 0;
        this.array = new int[capacity];
        this.isFull = false;
    }

    @Override
    public boolean put(int value) {
        if (!isFull) { // 꽉 차지 않았으면
            array[rear++] = value;// front 0 : rear 1
            return true;
        } else
            throw new IndexOutOfBoundsException();
    }

    @Override
    public int get()  {
        if(++front%capacity == rear)
            throw new IndexOutOfBoundsException();//만약 +1 위치가 rear와 같다면
        else
             {
                front = ++front % capacity;
                return array[front];
            } //그게 아니라면
}

    @Override
    public int peek() {
        if(++front%capacity <= rear)
            return array[front];
        else
            throw  new NullPointerException();
    }
    @Override
    public String toString() {
        String string = "";
        for(int i = 0; i < capacity; i++) {
            string = string + array[front];
            front = ++front % capacity;
        }
        return string;
    }

    public boolean isFull() {
        return rear + 1 % capacity == 0;
    }
}
