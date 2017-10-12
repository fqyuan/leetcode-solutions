class Solution {
	    public void sortColors(int[] nums) {
	        int[] count = new int[3];
	        for(int e : nums){
	            count[e]++;
	        }
	        int i = 0;
	        for(int j = 1; j < count.length; j++) count[j] += count[j-1];
	        for(; i < count[0]; i++) nums[i] = 0;
	        for(;i < count[1]; i++) nums[i] = 1;
	        for(; i < count[2]; i++) nums[i] = 2;
	    }
}