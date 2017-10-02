class Solution {
     public void wiggleSort(int[] nums) {
         if(nums.length < 2) return;
         int[] sort = Arrays.copyOf(nums, nums.length);
         Arrays.sort(sort);
         int k = sort.length-1;
         for(int i = 1; i < nums.length; i+=2){  // odd position needs big number
             nums[i] = sort[k--];                   // diffirent direction to seperate the same number in the middle
         }                                       //  S S M | M_ B_ B_      
                                                //  M B_ S B_ S M_
         for(int i = 0; i < nums.length; i+=2) { // even postion needs small number
             nums[i] = sort[k--];
         }
         
         
         //System.out.println(Arrays.toString(nums));
     }
}
/*   Vitual index + 3-way partition
class Solution {
	 public void wiggleSort(int[] nums) {
    	 int mid  = findKth(nums, (nums.length+1)/2);
        int n = nums.length;

        int left = 0, i = 0, right = n - 1;

        while (i <= right) {

            if (nums[newIndex(i,n)] > mid) {
                exchange(nums, newIndex(left++,n), newIndex(i++,n));
            }
            else if (nums[newIndex(i,n)] < mid) {
                exchange(nums, newIndex(right--,n), newIndex(i,n));
            }
            else {
                i++;
            }
        }
    }

    private int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }
    public int findKth(int[] nums, int k){
        int lo = 0;
        int hi = nums.length - 1;
        k = nums.length- k;
        while(lo < hi){
            int t = partition(nums, lo, hi);
            if (t<k) lo = t+1;
            else if(t>k) hi = t-1;
            else break;
        }
        return nums[k];
    }
    private int partition(int[] nums, int lo, int hi){
        int i = lo;
        int j = hi + 1;
        while(true){
            while(i < hi && nums[++i] <= nums[lo]);
            while(lo < j && nums[--j] >= nums[lo]);
            if(i>= j) break;
            exchange(nums, i, j);
        }
        exchange(nums,j,lo);
        return j;
    }
    private void exchange(int[] nums, int lo, int hi){
        
        int tm= nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = tm;
    }
}
*/