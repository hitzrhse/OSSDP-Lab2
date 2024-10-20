import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 *
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,2]
 * 解释：[1,3] 也会被视为正确答案。
 * 示例 2：
 *
 * 输入：nums = [1,2,4,8]
 * 输出：[1,2,4,8]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 2 * 109
 * nums 中的所有整数 互不相同
 *
 */

class Solution3 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return new ArrayList<>(); // 如果数组为空，返回空列表
        }

        Arrays.sort(nums);  // 将数组排序

        // 动态规划数组，dp[i] 表示以 nums[i] 结尾的最大整除子集的大小
        int[] dp = new int[len];
        Arrays.fill(dp, 1); // 每个元素至少可以整除自身，初始值为 1

        int maxSize = 1;  // 最大整除子集的大小
        int maxVal = nums[0]; // 最大整除子集中的最大值

        // 第 1 步：动态规划找出最大子集的个数和最大值
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                // 如果 nums[i] 可以被 nums[j] 整除
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 更新最大子集的大小和最大值
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxVal = nums[i];
            }
        }

        // 第 2 步：倒推获得最大子集
        List<Integer> res = new ArrayList<>();
        for (int i = len - 1; i >= 0; i--) {
            // 如果当前元素是最大子集的一部分，并且它可以被 maxVal 整除
            if (dp[i] == maxSize && maxVal % nums[i] == 0) {
                res.add(nums[i]);
                maxVal = nums[i];  // 更新最大值
                maxSize--;  // 减少要找的子集大小
            }
        }

        return res;
    }
}

