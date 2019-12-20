/*
 * @lc app=leetcode.cn id=978 lang=java
 *
 * [978] 最长湍流子数组
 *
 * https://leetcode-cn.com/problems/longest-turbulent-subarray/description/
 *
 * algorithms
 * Medium (36.04%)
 * Likes:    24
 * Dislikes: 0
 * Total Accepted:    2.4K
 * Total Submissions: 6.5K
 * Testcase Example:  '[9,4,2,10,7,8,8,1,9]'
 *
 * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
 * 
 * 
 * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 * 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
 * 
 * 
 * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
 * 
 * 返回 A 的最大湍流子数组的长度。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：[9,4,2,10,7,8,8,1,9]
 * 输出：5
 * 解释：(A[1] > A[2] < A[3] > A[4] < A[5])
 * 
 * 
 * 示例 2：
 * 
 * 输入：[4,8,12,16]
 * 输出：2
 * 
 * 
 * 示例 3：
 * 
 * 输入：[100]
 * 输出：1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= A.length <= 40000
 * 0 <= A[i] <= 10^9
 * 
 * 
 */

// @lc code=start
class Solution {
    public int maxTurbulenceSize(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        if (A.length == 1){
            return 1;
        }
        int max = 1;
        int left = 0;
        int right = 1;
        int midle = right - 1;
        int temp = 0;
        while(right < A.length){
            if(temp==0){
                if(A[midle]>A[right]){
                    temp = 1;
                    left = midle;
                }
                if(A[midle]<A[right]){
                    temp = -1;
                    left = midle;
                }
            }else{
                int ac = A[midle] - A[right];
                int len = right - left;
                if(ac*temp>0){
                    left = midle;
                }else if(ac*temp<0){
                    temp = -temp;
                }else {
                    temp = 0;
                    left = midle;
                }
                if(len>max){
                    max = len;
                }
            }
            right++;
            midle = right - 1;
        }
        if(temp!=0&&right-left>max){
            max = right-left;
        }
        return max;
    }
}
// @lc code=end

