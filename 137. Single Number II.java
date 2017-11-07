class Solution {
    public int singleNumber(int[] nums) {
        int a = 0; 
        int b = 0;
        for (int e : nums) {
            a = (e^a) & ~b;
            b = (e^b) & ~a;
        }
        return a;
    }
}