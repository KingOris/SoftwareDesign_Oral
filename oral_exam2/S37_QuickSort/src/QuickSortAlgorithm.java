import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * The QuickSortAlgorithm contain the algorithm to sort a mount of integer
 */
public class QuickSortAlgorithm {
    /**
     * A private arraylist to contain some arraylist which contains integer
     */
    private ArrayList<ArrayList<Integer>> array1;
    /**
     * The first pivot to separate those integer
     */
    private int pivot1;
    /**
     * The second pivot to separate those integer
     */
    private int pivot2;

    /**
     * A constructor for QuickSortAlgorithm
     *
     * @param a The 100 integer array
     */
    public QuickSortAlgorithm(int[] a) {
        array1 = new ArrayList<>();
        array1.add(convert(a));
    }

    /**
     * The setPivot method to set 2 different pivot
     *
     * @param num the size of the arraylist
     * @param i   the location of in the arraylist
     */
    public void setPivot(int num, int i) {
        Random random = new Random();
        pivot1 = random.nextInt(num);
        int pivot2 = random.nextInt(num);
        while (pivot1 == pivot2) {
            pivot2 = random.nextInt(num);
        }
        this.pivot2 = pivot2;
        if (array1.get(i).get(this.pivot2) < array1.get(i).get(pivot1)) {
            this.pivot2 = pivot1;
            pivot1 = pivot2;
        }
    }

    /**
     * The method quikSort to sort the integer array and delete the empty arraylist
     */
    public void quikSort() {
        //To get the size of the array1
        int size = array1.size();
        //To check every arraylist in the array1
        for (int i = 0; i < size; i++) {
            if (array1.get(0).size() != 1) {
                //To check the first arraylist in the array 1
                setPivot(array1.get(0).size(), 0);
                //To get the 2 pivot value
                System.out.println("randomly select pivots --> " + array1.get(0).get(pivot1) + " and " + array1.get(0).get(pivot2));
                ArrayList<Integer> arrayList1 = new ArrayList<>();
                ArrayList<Integer> arrayList2 = new ArrayList<>();
                ArrayList<Integer> arrayList3 = new ArrayList<>();
                for (int n = 0; n < array1.get(0).size(); n++) {
                    if (array1.get(0).get(n) <= array1.get(0).get(pivot1)) {
                        arrayList1.add(array1.get(0).get(n));
                    } else if (array1.get(0).get(n) >= array1.get(0).get(pivot2)) {
                        arrayList3.add(array1.get(0).get(n));
                    } else {
                        arrayList2.add(array1.get(0).get(n));
                    }
                }
                if (!arrayList1.isEmpty()) {
                    array1.add(arrayList1);
                }
                if (!arrayList2.isEmpty()) {
                    array1.add(arrayList2);
                }
                if (!arrayList3.isEmpty()) {
                    array1.add(arrayList3);
                }
                array1.remove(0);
            } else {
                array1.add(array1.get(0));
                array1.remove(0);
            }
        }
        printSub();
    }

    /**
     * The checkSort method is to check if the sort finished
     *
     * @return true if the sort finished; false if the sort doesn't finish
     */
    public boolean checkSort() {
        for (int i = 0; i < array1.size(); i++) {
            for (int n = 1; n < array1.get(i).size(); n++) {
                if (array1.get(i).get(n) < array1.get(i).get(n - 1)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * The convert method is to add all the number into arraylist
     *
     * @param a the array of integer number
     * @return the arraylist
     */
    public ArrayList<Integer> convert(int[] a) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            arrayList.add(a[i]);
        }
        return arrayList;
    }

    /**
     * The printInitial method is to print all the number in the first arraylist
     */
    public void printInitial() {
        System.out.print("initial = ");
        printArray();
    }

    /**
     * The printArray funtion is to print all the element in the arraylist
     */
    public void printArray() {
        Iterator<ArrayList<Integer>> iterator = array1.iterator();
        if (!checkSort()) {
            while (iterator.hasNext()) {
                System.out.print("[");
                ArrayList<Integer> arrayList = iterator.next();
                for (int i = 0; i < arrayList.size(); i++) {
                    System.out.print("" + arrayList.get(i));
                    System.out.print(" ");
                }
                System.out.print("] ");
            }
        } else {
            System.out.print("[");
            while (iterator.hasNext()) {
                ArrayList<Integer> arrayList = iterator.next();
                for (int i = 0; i < arrayList.size(); i++) {
                    System.out.print("" + arrayList.get(i));
                    System.out.print(" ");
                }
            }
            System.out.print("] ");
        }
        System.out.println();
    }

    /**
     * The printSub funtion is to print the sub array
     */
    public void printSub() {
        if (!checkSort()) {
            System.out.print("sub arrays = ");
        } else {
            System.out.print("finial array = ");
        }
        printArray();
    }

}
