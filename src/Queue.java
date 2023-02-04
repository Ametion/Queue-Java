import java.util.Iterator;

public class Queue<T> implements Iterable<T>{
    private LinkedList<T> queue = new LinkedList<>();

    public void Enqueue(T data){
        queue.Add(data);
    }

    public void Dequeue(){
        queue.RemoveFirst();
    }

    public T Front(){
        return queue.Get(0);
    }

    public T Back(){
        return queue.Get(queue.GetSize() - 1);
    }

    public Boolean IsEmpty(){
        return queue.GetSize() == 0;
    }

    public int GetSize(){
        return queue.GetSize();
    }

    public void Clear(){
        queue.Clear();
    }

    public Boolean Contains(T data){
        return queue.Contains(data);
    }

    public Iterator<T> iterator() {
        return queue.iterator();
    }
}