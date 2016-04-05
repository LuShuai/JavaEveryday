package datastructure.superStack;

/**
 * Created by shuailu on 2/16/16.
 */
public class Tester {

    public static void main(String[] args) {
        SuperStack superStack = new SuperStack();

        superStack.push(1);
        superStack.push(1);
        superStack.push(1);
        superStack.push(1);
        superStack.push(1);
        superStack.push(1);


        System.out.println(superStack.pop());
        System.out.println(superStack.pop());

        superStack.increase(1, 1);
        superStack.increase(3, 5);

        System.out.println(superStack.pop());
        System.out.println(superStack.pop());
        System.out.println(superStack.pop());
        System.out.println(superStack.pop());

    }
}
