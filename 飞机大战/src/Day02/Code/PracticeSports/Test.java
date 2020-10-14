package Day02.Code.PracticeSports;

public class Test {
    public static void main(String[] args) {
        BasketballPlayer basketballPlayer = new BasketballPlayer("乒乓球运动员", 60);
        BasketballCoach basketballCoach = new BasketballCoach("乒乓球教练", 20);

        PingPangPlayer pingPangPlayer = new PingPangPlayer("篮球运动员", 60);
        PingPangCoach pingPangCoach = new PingPangCoach("篮球教练", 20);

        System.out.println(basketballPlayer.getName() + "..." + basketballPlayer.getAge());
        basketballPlayer.eat();
        basketballPlayer.play();

        System.out.println(basketballCoach.getName() + "..." + basketballCoach.getAge());
        basketballCoach.eat();
        basketballCoach.teach();

        System.out.println(pingPangPlayer.getName() + "..." + pingPangPlayer.getAge());
        pingPangPlayer.eat();
        pingPangPlayer.play();
        pingPangPlayer.speakEnglish();

        System.out.println(pingPangCoach.getName() + "..." + pingPangCoach.getAge());
        pingPangCoach.eat();
        pingPangCoach.teach();
        pingPangCoach.speakEnglish();
    }
}
