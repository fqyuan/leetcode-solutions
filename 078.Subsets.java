//backtarck
class Solution {
	    public List<List<Integer>> subsets(int[] nums) {
	        List<List<Integer>> list = new ArrayList<>();
	        int used = 0;
	        backtrack(nums, 0, list, new Stack<>());
	        return list;
	    }
	    private void backtrack(int[] nums, int used, List<List<Integer>> list, Stack<Integer> sublist){
	    	if(used == nums.length) {
	    		list.add(new ArrayList<>(sublist));
	    		return;
	    	}
	    		    	
	    	sublist.push(nums[used]);
	    	backtrack(nums, used+1, list, sublist); // contain nums[i]
	    	sublist.pop();
	    	backtrack(nums, used+1, list, sublist); // not contain nums[i]

	    }
}