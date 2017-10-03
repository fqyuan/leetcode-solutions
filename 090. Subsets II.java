class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            Arrays.sort(nums);
	        backtrack(nums, 0, list, new ArrayList<>());
	        return list;
	    }
	    private void backtrack(int[] nums, int begin, List<List<Integer>> list, List<Integer> sublist){
	    	list.add(new ArrayList<>(sublist));
	        
            for(int i = begin; i < nums.length; i++){
                if(i> begin&& nums[i] == nums[i - 1]) continue;
                sublist.add(nums[i]);
                backtrack(nums, i+1, list, sublist); // contain nums[i]
                sublist.remove(sublist.size()-1);    
            }
	    }
    
}