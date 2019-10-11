import java.util.Arrays;

public class ArrayQueue<T> implements Queue<T> {
    private static int StartingCapacity = 100;

    private int currentCapacity;
    private int front;
    private int back;
    private T[] innerArray;

    public ArrayQueue() {
        innerArray = (T[]) new Object[StartingCapacity];
        currentCapacity = StartingCapacity;
        front = 0; back = -1;
    }

    public boolean empty(){
        return back < front;
    }

    public void enqueue(T item){
        if (currentCapacity == back + 1) {
            innerArray = Arrays.copyOf(innerArray, currentCapacity * 2);
            currentCapacity *= 2;
        }
        innerArray[++back] = item;
    }

    public T dequeue() throws Exception {
        if (empty()){
            throw new Exception("Queue is empty but you're trying to dequeue");
        }
        return innerArray[front++];
    }

}
