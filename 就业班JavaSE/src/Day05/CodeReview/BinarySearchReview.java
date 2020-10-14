package Day05.CodeReview;

public class BinarySearchReview {
    public static void main(String[] args) {
        int[] intArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearch(intArr, 23));
    }

//    private static int binarySearch(int[] intArr, int number) {
//        int start = 0;
//        int end = intArr.length - 1;
//        while (start <= end) {
//            if (number != intArr[start]) {
//                start++;
//            } else if (number != intArr[end]) {
//                end--;
//            } else if (number == intArr[start]) {
//                return start;
//            } else if (number == intArr[end]) {
//                return end;
//            }
//        }
//        return -1;
//    }

    private static int binarySearch(int[] intArr, int number) {
        int start = 0;
        int end = intArr.length - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (number < intArr[mid]) {
                end = mid - 1;
            } else if (number > intArr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
