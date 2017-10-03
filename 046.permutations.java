class Solution {
	    public List<List<Integer>> permute(int[] nums) {
	        List<List<Integer>> res = new ArrayList<>();
	        backtrack(res, new ArrayList<>(), nums);
	        return res;
	    }
	    private void backtrack(List<List<Integer>> res, List<Integer> sublist, int[] nums){
	    	if(sublist.size() == nums.length) {
	    		res.add(new ArrayList<>(sublist));
	    		return;
	    	}
	    	for(int e : nums) {
	    		if(sublist.contains(e)) continue;
	    		sublist.add(e);
	    		backtrack(res, sublist, nums);
	    		sublist.remove(sublist.size() - 1);
	    	}
	    }
}