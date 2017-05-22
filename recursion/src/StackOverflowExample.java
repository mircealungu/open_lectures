/**
 * Created by mircea on 22.05.17.
 */

public class StackOverflowExample {

    public static void recursivePrint(int num) {
        System.out.println("Number: " + num);

        if(num == 0)
            return;
        else
            recursivePrint(++num);
    }

    public static void main(String[] args) {
        StackOverflowExample.recursivePrint(1);
    }
}
