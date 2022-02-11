import com.xiaopan.arr.Array;
import org.junit.jupiter.api.Test;

/**
 * @author xiaopantx
 * @version 1.0
 * @description
 */
public class ArrayTests {

    @Test
    public void test() {
        // 动态数组测试
        Array<Integer> array = new Array<>(10);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);

        array.addFirst(-1);
        array.add(100, 3);
        System.out.println(array);

        array.set(1, 0);
        array.set(1, 1);
        System.out.println(array);

        Integer first = array.removeFirst();
        Integer last = array.removeLast();
        System.out.println("first -> " + first + ", last -> " + last + ", array -> " + array);

        array.removeAll(1);
        System.out.println(array);

        array.remove(2,3,4,4,5);
        System.out.println(array);

        System.out.println(array.find(10));
        System.out.println(array.get(1));

    }
}
