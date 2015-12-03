package someTest;

/**
 * Created by shuailu on 10/29/15.
 */
public class GenericArrayTest {

    // generic method printArray
    public <E> void printArray(E[] inputArray) {
        // Display array elements
        for (E element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        GenericArrayTest instance = new GenericArrayTest();
        instance.printArray(new Character[]{1, 2, 3,});
    }

}
