/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 *
 * https://leetcode-cn.com/problems/add-binary/description/
 *
 * algorithms
 * Easy (50.98%)
 * Likes:    269
 * Dislikes: 0
 * Total Accepted:    50.4K
 * Total Submissions: 98.1K
 * Testcase Example:  '"11"\n"1"'
 *
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 
 * 输入为非空字符串且只包含数字 1 和 0。
 * 
 * 示例 1:
 * 
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 
 * 示例 2:
 * 
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * 
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        int la = ca.length - 1;
        int lb = cb.length - 1;
        boolean up = false;
        boolean cc = false;
        while(la >= 0 || lb >= 0){
            if(up){
                up = false;
                cc = !cc;
            }
            if(lb>=0){
                if(cb[lb] == '1'){
                    if(cc){
                        up = true;
                    }
                    cc = !cc;
                }
                lb--;
            }
            if(la>=0){
                if(ca[la] == '1'){
                    if(cc){
                        up = true;
                    }
                    cc = !cc;
                }
                la--;
            }
            if(cc){
                sb.append('1');
            }else{
                sb.append('0');
            }
            cc = false;
        }
        if(up){
            sb.append('1');
        }
        sb.reverse();
        return sb.toString();
    }
}
// @lc code=end

