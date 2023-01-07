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

class LinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public LinkedList(T data){
        this.head.data = data;
        this.head.next = null;
        this.size = 1;
    }

    public int GetSize(){
        return size;
    }

    public T Get(int index){
        var curr = head;
        var i = 0;

        while(true){
            if(i == index){
                return curr.data;
            }

            curr = curr.next;
            i++;
        }
    }

    public void Add(T data){
        if(head ==  null){
            head = new Node<T>();
            head.data = data;
            head.next = null;
            size++;
            return;
        }

        var curr = head;

        while(true){
            if(curr.next == null){
                curr.next = new Node<T>();
                curr.next.data = data;
                curr.next.next = null;
                size++;
                break;
            }

            curr = curr.next;
        }
    }

    public void RemoveAt(int index){
        var curr = head;
        var i = 0;

        if(index == 0){
            head = head.next;
            size--;
            return;
        }

        while(true){
            if(i == index){
                if(curr.next == null){
                    RemoveLast();
                    return;
                }

                curr.data = curr.next.data;
                curr.next = curr.next.next;

                size--;
                return;
            }

            curr = curr.next;
            i++;
        }
    }

    public void Remove(T data){
        var curr = head;
        var i = 0;

        if(head.data.equals(data)){
            RemoveFirst();
            return;
        }

        while(true){
            if(curr.next.data.equals(data)){
                curr.next = curr.next.next;
                return;
            }

            curr = curr.next;
        }
    }

    public void RemoveFirst(){
        head = head.next;
        size--;
    }

    public void RemoveLast(){
        var curr = head;

        while(curr.next.next != null){
            curr = curr.next;
        }

        curr.next = null;
        size--;
    }

    public void Clear(){
        head = null;
    }

    public Boolean Contains(T data){
        var curr = head;
        var i = 0;

        if(head.data.equals(data)){
            return true;
        }

        while(true){
            if(curr.next == null){
                return false;
            }

            if(curr.next.data.equals(data)){
                return true;
            }

            curr = curr.next;
        }
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node<T> current = head;

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            T data = current.data;
            current = current.next;
            return data;
        }
    }

    private class Node <T>{
        public T data;
        public Node<T> next;
    }
}

