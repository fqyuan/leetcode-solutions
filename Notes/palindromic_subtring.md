# Palindromic Substring

标签（空格分隔）： Leetcode

---

#### [5. Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/description/)
> 最长子回文串

- DP算法
```java
public String longestPalindrome(String s) {
int n = s.length();
String res = null;
boolean[][] dp = new boolean[n][n];  //dp[i][j]  i ~ j 是否是Palindrome
for (int i = n - 1; i >= 0; i--) {
for (int j = i; j < n; j++) {
        dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]); // j > i + 3 => j - 1不越界
        if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
            res = s.substring(i, j + 1);
        }
    }
}
return res;
}
```
- Extend Around Center算法
```java
class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        int max = 0;
        for(int i = 0; i < s.length(); i++) {
            int odd = extend(s, i,i);
            int even = extend(s, i, i+1);
            if(odd > max) {
                res = s.substring(i - odd / 2, i + odd / 2 + 1);
                max = odd;
            }
            if(even > max) {
                res = s.substring(i - even / 2 + 1, i + even / 2 + 1);
                max = even;
            }
        }
        return res;
    }
    
    public int extend(String s, int i, int j) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        // i j extend untill s(i, j) is not Palindromic
        return j - i - 1;
    }
}
```

#### [647. Palindromic Substrings](https://leetcode.com/problems/palindromic-substrings/description/)
> 子回文串总个数

- DP算法
```java
class Solution {
    public int countSubstrings(String s) {
        boolean[][] isP = new boolean[s.length()][s.length()]; //dp[i][j]  i ~ j 是否是Palindrome
        int count = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            for(int j = i; j < s.length(); j++) {
                //i x x x j  i+3 = j
                if(s.charAt(i) == s.charAt(j) && (j < i + 3|| isP[i + 1][j - 1])){
                    isP[i][j] = true;
                    ++count;
                }
            }
        }
        return count;
    }
}
```
- Extend Around Center算法
```java
class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            count += extend(s, i, i) + extend(s, i, i + 1);
        }
        return count;
    }
    
    public int extend(String s, int i, int j) {
        int count = 0;
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            count++;
            i--;
            j++;
        }
        return count;
    }
}
```

#### [516. Longest Palindromic Subsequence](https://leetcode.com/problems/longest-palindromic-subsequence/description/)
> 最长回文子序列，不需要连续, 中心extend方法不可行

- DP
2D DP matrix,  dp[i][j]  = >  s(i ~ j)中存在回文序列的最大长度
dp[i][j] = dp[i + 1][j - 1] + 2 if s[i] == s[j]
dp[i][j] = Max: dp[i + 1][j]  //不要左边 
          dp[i][j - 1] //不要右边
```JAVA
class Solution {
    public int longestPalindromeSubseq(String s) {
        //dp[i][j] = dp[i + 1][j - 1] + 2 if s[i] == s[j]
        // dp[i][j] = Max: dp[i + 1][j]  //不要左边 
       //                  dp[i][j - 1] //不要右边
 
        int[][] dp = new  int[s.length()][s.length()];  // dp[i][j] i ~ j 最大长度
        for(int i = s.length() - 1; i >= 0; i--) { // i 从右扫 <---
            for(int j = i; j < s.length(); j++)  { // j --->
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = j - i < 2 ? j - i + 1: dp[i + 1][j - 1] + 2; // j - i < 2 时 直接赋值1 or 2
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}
```
- 




