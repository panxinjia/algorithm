import com.xiaopan.queue.ArrayQueue;
import org.junit.jupiter.api.Test;

/**
 * @author xiaopantx
 * @version 1.0
 * @description
 */
public class ArrayQueueTests {

    @Test
    public void test() {
        ArrayQueue<Integer> queue = new ArrayQueue<>();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            if (i % 3 ==0)
                queue.dequeue();
        }

        System.out.println(queue);

        System.out.println(queue.dequeue());
        System.out.println(queue.front());
        System.out.println(queue.front());
        System.out.println(queue.front());
        System.out.println(queue);
    }
}
