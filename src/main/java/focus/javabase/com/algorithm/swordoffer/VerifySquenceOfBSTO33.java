package focus.javabase.com.algorithm.swordoffer;

/**
 * @Author chenjianrong-lhq
 * @Description 验证是否是二叉搜索树的后序遍历序列
 * @Date 2020-09-02 18:17
 **/
public class VerifySquenceOfBSTO33 {


    // 5, 7, 6, 9, 11, 10, 8
    // 7, 4, 6, 5
    public static boolean verifySquenceOfBST(int[] nums, int left, int right) {
        if (nums == null || left > right) {
            return false;
        }

        if (left == right) {
            return true;
        }

        // 从左 寻找到比key大的 index
        int index = left;
        while (nums[index] <= nums[right]) {
            index++;
            if (index >= right) {
                return true;
            }
        }

        // 判断后面的值是否有小于key的
        int lastIndex = index + 1;
        while (lastIndex < right) {
            if (nums[lastIndex] < nums[right]) {
                return false;
            }
            lastIndex++;
        }

        // 分别判断左子树 右子树 是否为 二叉搜索树
        return verifySquenceOfBST(nums, left, index - 1)
                && verifySquenceOfBST(nums, index, right - 1);
    }
}