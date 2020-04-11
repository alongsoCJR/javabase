package focus.javabase.com.algorithm.sort.quicksort;

/**
 * @author chenjianrong-lhq 2019年07月08日 15:43:28
 * @Description: 双枢轴快排
 * @ClassName: QuickSortDualPivot
 */
public class QuickSortDualPivot {

    public static void sort(int[] input) {
        //input=shuffle(input);
        sort(input, 0, input.length - 1);
    }

    private static void sort(int[] input, int lowIndex, int highIndex) {

        if (highIndex <= lowIndex) {
            return;
        }

        int pivot1 = input[lowIndex];
        int pivot2 = input[highIndex];


        if (pivot1 > pivot2) {
            SortUtils.exchange(input, lowIndex, highIndex);
            pivot1 = input[lowIndex];
            pivot2 = input[highIndex];
            //sort(input, lowIndex, highIndex);
        } else if (pivot1 == pivot2) {
            while (pivot1 == pivot2 && lowIndex < highIndex) {
                lowIndex++;
                pivot1 = input[lowIndex];
            }
        }


        int i = lowIndex + 1;
        int lt = lowIndex + 1;
        int gt = highIndex - 1;

        while (i <= gt) {

            if (SortUtils.less(input[i], pivot1)) {
                SortUtils.exchange(input, i++, lt++);
            } else if (SortUtils.less(pivot2, input[i])) {
                SortUtils.exchange(input, i, gt--);
            } else {
                i++;
            }
        }


        SortUtils.exchange(input, lowIndex, --lt);
        SortUtils.exchange(input, highIndex, ++gt);

        sort(input, lowIndex, lt - 1);
        sort(input, lt + 1, gt - 1);
        sort(input, gt + 1, highIndex);

    }
}
