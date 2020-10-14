package Day08.Code;

public final class Day08_Code9 {
    public static void main(String[] args) {
        StringBuilder stringBuilder1 = new StringBuilder();
        String string = "111";
        StringBuilder stringBuilder2 = new StringBuilder(string);
        stringBuilder2.append("哈哈哈");
        System.out.println(stringBuilder2.length());
        System.out.println(stringBuilder2.toString());
        System.out.println(stringBuilder2.reverse());
    }

}
