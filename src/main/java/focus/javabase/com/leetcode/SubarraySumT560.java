package focus.javabase.com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumT560 {

    // 暴力法
    public static int subarraySum(int[] nums, int k) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    result++;
                }
            }
        }
        return result;
    }

    // 哈希表存中间数据 sum(i,j)=sum(0,j)-sum(0,i) j>=i
    public static int subarraySum0(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 1; i <= nums.length; i++) {
            hashMap.put(i, hashMap.getOrDefault(i - 1, 0) + nums[i - 1]);
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = i; j <= nums.length; j++) {
                if (hashMap.get(j) - hashMap.get(i) + nums[i - 1] == k) {
                    result++;
                }
            }
        }
        return result;
    }

    // 哈希表存中间数据 sum(i,j)=sum(0,j)-sum(0,i) j>=i  [1,1,1]
    // sum(2,3)=sum(0,3)-sum(0,2)--->  sum(2,3) + sum(0,2) = sum (0,3)
    // pre[j-1]=pre[i]-k
    public static int subarraySum1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int pre = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                result += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }

        return result;
    }
}