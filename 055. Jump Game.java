class Solution{
	public boolean canJump(int[] nums){    // dp is time limit exceed
		int firstgood = nums.length-1;
		for(int i = nums.length-2; i >= 0; i--){
			if(i + nums[i]>= firstgood) firstgood = i;
		}
		return firstgood == 0;
	}
}