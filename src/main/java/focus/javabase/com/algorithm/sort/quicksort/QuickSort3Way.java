package focus.javabase.com.quicksort;

/**
 * @author chenjianrong-lhq 2019年07月08日 15:50:14
 * @Description: 3路快排
 * @ClassName: QuickSort3Way
 */
public class QuickSort3Way {


    public static void sort(int[] input) {
        //input=shuffle(input);
        sort(input, 0, input.length - 1);
    }

    public static void sort(int[] input, int lowIndex, int highIndex) {
        if (highIndex <= lowIndex) {
            return;
        }
        int lt = lowIndex;
        int gt = highIndex;
        int i = lowIndex + 1;

        int pivotIndex = lowIndex;
        int pivotValue = input[pivotIndex];


        while (i <= gt) {
            if (SortUtils.less(input[i], pivotValue)) {
                SortUtils.exchange(input, i++, lt++);
            } else if (SortUtils.less(pivotValue, input[i])) {
                SortUtils.exchange(input, i, gt--);
            } else {
                i++;
            }
        }

        sort(input, lowIndex, lt - 1);
        sort(input, gt + 1, highIndex);
    }
}
