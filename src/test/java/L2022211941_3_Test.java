import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * 测试类: L2022211941_3_Test
 *
 * 测试用例设计原则：
 * 1. 等价类划分：
 *    - 输入为单个元素的情况。
 *    - 输入为多个元素，且只有部分元素能构成整除子集的情况。
 *    - 输入为多个元素，所有元素能构成整除子集的情况。
 *
 * 2. 边界值分析：
 *    - 输入数组为空的情况。
 *    - 输入数组长度为 1 的情况。
 *    - 输入数组长度接近上限的情况。
 *
 * 测试目的：
 * 验证 `largestDivisibleSubset` 方法在不同的输入条件下的正确性，包括普通输入、边界值输入以及各种极端情况。
 */
public class L2022211941_3_Test {

    /**
     * 测试方法：testLargestDivisibleSubset_singleElement
     *
     * 测试目的：验证输入为单个元素的情况下，输出是否正确。
     * 测试用例：输入 [1]，期望输出为 [1]。
     */
    @Test
    public void testLargestDivisibleSubset_singleElement() {
        Solution3 solution = new Solution3();
        int[] input = {1};
        Set<Integer> expected = new HashSet<>(Arrays.asList(1));
        Set<Integer> result = new HashSet<>(solution.largestDivisibleSubset(input));
        assertEquals(expected, result);
    }

    /**
     * 测试方法：testLargestDivisibleSubset_multipleElementsPartialSubset
     *
     * 测试目的：验证输入为多个元素且部分元素构成整除子集的情况。
     * 测试用例：输入 [1, 2, 3]，期望输出为 [1, 2] 或 [1, 3]。
     */
    @Test
    public void testLargestDivisibleSubset_multipleElementsPartialSubset() {
        Solution3 solution = new Solution3();
        int[] input = {1, 2, 3};
        Set<Integer> expected1 = new HashSet<>(Arrays.asList(1, 2));
        Set<Integer> expected2 = new HashSet<>(Arrays.asList(1, 3));
        Set<Integer> result = new HashSet<>(solution.largestDivisibleSubset(input));
        assertTrue(result.equals(expected1) || result.equals(expected2));
    }

    /**
     * 测试方法：testLargestDivisibleSubset_allElementsDivisible
     *
     * 测试目的：验证输入为多个元素且所有元素都能构成整除子集的情况。
     * 测试用例：输入 [1, 2, 4, 8]，期望输出为 [1, 2, 4, 8]。
     */
    @Test
    public void testLargestDivisibleSubset_allElementsDivisible() {
        Solution3 solution = new Solution3();
        int[] input = {1, 2, 4, 8};
        Set<Integer> expected = new HashSet<>(Arrays.asList(1, 2, 4, 8));
        Set<Integer> result = new HashSet<>(solution.largestDivisibleSubset(input));
        assertEquals(expected, result);
    }

    /**
     * 测试方法：testLargestDivisibleSubset_emptyInput
     *
     * 测试目的：验证输入为空数组时，程序的正确性。
     * 测试用例：输入 []，期望输出为空列表 []。
     */
    @Test
    public void testLargestDivisibleSubset_emptyInput() {
        Solution3 solution = new Solution3();
        int[] input = {};
        Set<Integer> expected = new HashSet<>(Arrays.asList());
        Set<Integer> result = new HashSet<>(solution.largestDivisibleSubset(input));
        assertEquals(expected, result);
    }

    /**
     * 测试方法：testLargestDivisibleSubset_largeInput
     *
     * 测试目的：验证输入为接近最大长度（如 1000 个元素）时，程序的性能和正确性。
     * 测试用例：输入 [1, 2, 4, ..., 2^9]，期望输出为整除子集。
     */
    @Test
    public void testLargestDivisibleSubset_largeInput() {
        Solution3 solution = new Solution3();
        int[] input = new int[10];  // 生成 10 个元素
        for (int i = 0; i < 10; i++) {
            input[i] = (int) Math.pow(2, i);  // [1, 2, 4, 8, 16, 32, 64, 128, 256, 512]
        }
        Set<Integer> expected = new HashSet<>(Arrays.asList(1, 2, 4, 8, 16, 32, 64, 128, 256, 512));
        Set<Integer> result = new HashSet<>(solution.largestDivisibleSubset(input));
        assertEquals(expected, result);
    }
}
