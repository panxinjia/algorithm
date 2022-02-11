import com.xiaopan.stack.ArrayStack;
import org.junit.jupiter.api.Test;

/**
 * @author xiaopantx
 * @version 1.0
 * @description
 */
public class ArrayStackTests {

    @Test
    public void test() {
        ArrayStack<Integer> stack = new ArrayStack<>();

        for (int i = 0; i <= 10; i++) {
            stack.push(i);
            if (i % 2 == 0)
                stack.pop();
        }

        System.out.println("size: " + stack.size() + ", " + stack);

        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.peek());

        System.out.println(stack);
    }
}
