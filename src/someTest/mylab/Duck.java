package someTest.mylab;

/**
 * Created by shuailu on 1/27/16.
 */
public class Duck extends Animal {

    int numOfLegs = 2;

    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.setNumOfLegs(6);


        System.out.println("Duck has " + duck.getNumOfLegs() + " legs");
    }

}
