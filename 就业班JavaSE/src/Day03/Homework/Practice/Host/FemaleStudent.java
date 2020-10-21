package Day03.Homework.Practice.Host;

public class FemaleStudent extends Student implements Host{
    @Override
    public void eat() {
        System.out.println("我是女同学，我嗑瓜子，吃水果...");
    }

    @Override
    public void host() {
        System.out.println("女士们，先生们，大家好，我是主持人......");
    }
}
