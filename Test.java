import java.util.Random;

public class Test {

    public static void main(String [] args) {
        MaxHeap myHeap = new MaxHeap(50);
        Random rand = new Random();
        int randomNum = 0;
        for(int i = 0; i < 50; i++) {
            randomNum = rand.nextInt(100);
            myHeap.insert(randomNum);
        }

        myHeap.print();
        System.out.println("\nMax Value: " + myHeap.removeMax() + "\n");
        myHeap.print();
        System.out.println("\nMax Value: " + myHeap.removeMax() + "\n");
        myHeap.print();
        System.out.println("\nMax Value: " + myHeap.removeMax() + "\n");
        myHeap.print();
        System.out.println("\nMax Value: " + myHeap.removeMax() + "\n");
        myHeap.print();
        System.out.println("\nMax Value: " + myHeap.removeMax() + "\n");
        myHeap.print();
        System.out.println("\nMax Value: " + myHeap.removeMax() + "\n");
        myHeap.print();
        System.out.println("\nMax Value: " + myHeap.removeMax() + "\n");
        myHeap.print();
        System.out.println("\nMax Value: " + myHeap.removeMax() + "\n");
        myHeap.print();
    }


}
