class Solution {
	    public List<List<Integer>> permuteUnique(int[] nums) {
	        List<List<Integer>> list = new ArrayList<>();
	        Arrays.sort(nums);
	        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
	        return list;
	    }
	    private void backtrack(List<List<Integer>> list, List<Integer> sublist, int[] nums, boolean[] used){
	        if(sublist.size() == nums.length) 
	            list.add(new ArrayList<>(sublist));
	        else {
	            for(int i = 0; i < nums.length; i++){
	                if(used[i]||i > 0 && nums[i-1]==nums[i]&&!used[i-1]) continue;
	                used[i] = true;
	                sublist.add(nums[i]);
	                backtrack(list,sublist,nums,used);
	                sublist.remove(sublist.size() - 1);
	                used[i] = false;
	            }            
	        }

	    }
}