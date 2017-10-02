class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if(nums.length < 3) return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++){
        	if(nums[i] + nums[i+1] + nums[i+2]+ nums[i+3] > target) break; // i too large
        	if(nums[i] + nums[nums.length - 1]+nums[nums.length - 2]+nums[nums.length - 3] < target) continue; // i too small
    		if (i > 0 && nums[i] == nums[i-1]) continue;  //eluminate duplicate except the first time 
    		for(int j = i + 1; j < nums.length - 2; j++) {
    			if(nums[i] + nums[j] + nums[j+1]+ nums[j+2] > target) break; // j too large
        		if(nums[i] + nums[j]+nums[nums.length - 2]+nums[nums.length - 1] < target) continue; // j too small
    			if (j > i+1 && nums[j] == nums[j-1]) continue;  //eluminate duplicate except the first time 
    			int lo = j + 1, hi = nums.length - 1;
    			while(lo < hi){
    				int sum =  nums[i] + nums[j] + nums[lo] + nums[hi];
    				if(sum < target) lo++;
    				else if(sum > target) hi--;
    				else {
    					res.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
    					while(lo < hi && nums[++lo] == nums[lo - 1]);
    					while(lo < hi && nums[--hi] == nums[hi + 1]);

    				}
    			}
    		}
    	}
    	return res;
    }
}