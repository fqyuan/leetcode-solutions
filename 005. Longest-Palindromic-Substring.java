class Solution {
    public String longestPalindrome(String s) {
        int center = 0;
        int length =0;
        for(int i = 0; i < s.length(); i++){
            int a = extend(s,i,i);
            int b = extend(s,i,i+1);
            if(Math.max(a,b) > length){
                length = Math.max(a,b);
                center = i;
            }
        }
        return s.substring(center - (length-1)/2, center + length/2+1);
    }
    private int extend(String s, int l, int r) {
        while(l  >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l-1;
    }
}