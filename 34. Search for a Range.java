class Solution {
 public int[] searchRange(int[] nums, int target) {

	        int[] a = {-1,-1};
	        search(nums, 0 , nums.length -1 ,target, a);
	        return a;
	    }
	    private void search(int[] nums, int lo, int hi, int target, int[] a){
	        while (lo <= hi) {
	           int mid = (lo+ hi) / 2;
	            if(nums[mid] < target) lo = mid + 1;
                else if (nums[mid] > target)  hi = mid - 1;
                else {
	                if(mid == 0 || nums[mid-1] < target ) a[0] = mid;
	                if(mid == nums.length-1 || nums[mid+1] > target) a[1] = mid;
	                if(a[0] == -1) search(nums, lo , mid -1, target, a);
	                if(a[1] == -1) search(nums, mid+1, hi, target, a);
	                 return;  
	            }
	        }
	    }
}