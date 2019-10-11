import java.util.Arrays;

public class ArrayStack<T> implements Stack<T>{
    private static int StartingCapacity = 100;

    private int currentCapacity;
    private int back;
    private T[] innerArray;

    public ArrayStack() {
        innerArray = (T[]) new Object[StartingCapacity];
        currentCapacity = StartingCapacity;
        back = -1;
    }

    public boolean empty(){
        return back == -1;
    }

    public void push(T item){
        if (currentCapacity == back + 1) {
            innerArray = Arrays.copyOf(innerArray, currentCapacity * 2);
            currentCapacity *= 2;
        }
        innerArray[++back] = item;
    }

    public T pop() throws Exception {
        if (empty())
            throw new Exception("Stack is Empty but you're trying to pop");
        return innerArray[back--];
    }

    public T peek() throws Exception {
        if (empty())
            throw new Exception("Stack is Empty but you're trying to pop");
        return innerArray[back];
    }

}
