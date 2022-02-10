/**
 * @author xiaopantx
 * @version 1.0
 * @description
 */
public class Sum {

    public static int sum(int[] arr, int l) {
        if (l == arr.length)
            return 0;
        return arr[l] + sum(arr, l + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int res = sum(arr,0);
        System.out.println(res);
    }
}
