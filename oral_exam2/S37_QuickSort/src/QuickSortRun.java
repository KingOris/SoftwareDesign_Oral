import java.util.Random;

/**
 * @author Yuhang Chen
 * @version 1.0.0
 * The main class QuickSortRun
 */
public class QuickSortRun {
    public static void main(String[] args) {
        //To create the 100 number array
        Random random = new Random();
        int[] a = new int[100];
        int num = 0;
        while (num != 99) {
            int rand = random.nextInt(101);
            a[num] = rand;
            num++;
        }

        QuickSortAlgorithm quickSortAlgorithm = new QuickSortAlgorithm(a);

        quickSortAlgorithm.printInitial();
        while (!quickSortAlgorithm.checkSort()) {
            quickSortAlgorithm.quikSort();
        }

    }
}
