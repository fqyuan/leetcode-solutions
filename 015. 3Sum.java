class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int b = 0; b < nums.length - 2; b++) {
            if(b != 0 && nums[b - 1] == nums[b]) continue;  
            //pre = nums[b];
            int base = 0 -nums[b];
            int i = b + 1;
            int j = nums.length - 1;
            while(i < j) {
                if(nums[i] + nums[j] == base) {
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(nums[b]);
                     tmp.add(nums[i]);
                     tmp.add(nums[j]);
                    res.add(tmp);
                    do {
                        i++;
                        j--;
                    } while(i < j && nums[i] == nums[i - 1] && nums[j] == nums[j + 1]);
                } else if(nums[i] + nums[j] > base) {
                    j--;
                } else {
                    i++;
                } 
            }
            
        }
        return res;
    }
}
