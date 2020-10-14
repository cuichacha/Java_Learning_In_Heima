package Day05.Code;

public class SystemDemo {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = new int[10];

        System.out.println(System.currentTimeMillis());
        System.arraycopy(arr1, 0, arr2, 5, arr1.length);
//        System.exit(0);
        System.out.println(arr2[7]);
    }
}
