package Day03.Homework.Practice.Celebrity;

public class Test {
    public static void main(String[] args) {
        Celebrity celebrity = new SubCelebrity("啦啦啦", "0");
        celebrity.introduce();

        SubCelebrity subCelebrity = (SubCelebrity) celebrity;
        subCelebrity.dance();
    }
}
