public class Main {
    public static void main(String[] args) {
        var queue = new Queue<String>();

        queue.Enqueue("first");
        queue.Enqueue("second");
        queue.Enqueue("third");
        queue.Enqueue("fourth");

        for(var el: queue){
            System.out.println(el);
        }
    }
}

