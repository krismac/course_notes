package ThemePark.Visitors;

public class Visitor {
    private int age;
    private int heightInCm;
    private double money;

    public Visitor(int age, int heightInCm, double money) {
        this.age = age;
        this.heightInCm = heightInCm;
        this.money = money;
    }

    public int getAge() {
        return age;
    }

    public int getHeightInCm() {
        return heightInCm;
    }

    public double getMoney() {
        return money;
    }


}
