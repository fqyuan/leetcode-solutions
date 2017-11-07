class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0) return 0;
        int[] memo = new int[s.length() + 1];
        memo[memo.length - 1] = 1;
        if (s.charAt(s.length() - 1) != '0') memo[memo.length -2] =  1;
        for(int i = s.length() - 2; i >=0; i--){
            if(s.charAt(i)=='0') continue;
            memo[i] = Integer.parseInt(s.substring(i, i + 2)) < 27 ? memo[i + 1] + memo[i + 2] : memo[i + 1]; 
        }
        return memo[0];
    }
}