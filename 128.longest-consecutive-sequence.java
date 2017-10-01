class Solution {
	  public int longestConsecutive(int[] nums) {
            if (nums.length == 0) return 0;
	        int max = 1;
	        HashSet<Integer> set = new HashSet<>();
	        for(int e : nums) set.add(e);  // add all

	        for(int e: nums){    //remove all   O(n)
	        	if(!set.contains(e)) continue;
	            int len = 1;
	            int t=e -1;
	            set.remove(e);
	            while(set.contains(t)) {
	                set.remove(t--);
	                len++;
	            }
	             t = e+1;
	            while(set.contains(t)){
	                set.remove(t++);
	                len++;
	            }
	            if(len > max) max = len;
	        }
	        return max;
	    }  
	
	
}