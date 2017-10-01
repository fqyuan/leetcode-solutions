/*
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length -1;
        while(lo < hi) {
            int[] res = partition(nums, lo, hi);
            if(res[1] < k) {
                lo = res[1] + 1;
            } else if (res[0] > k) {
                hi = res[0] - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }
    private int[] partition(int[] nums, int lo, int hi){  //three way partition
        int[] res = new int[2];
        int i = lo+1;
        int j = i;
        int k = hi;
        while(j <= k){
            if(nums[j] < nums[lo]){
                exchange(nums, i++ ,j++);
            } else if(nums[j] > nums[lo]) {
                exchange(nums,k--,j);
            } else {
                j++;
            }
        }
        exchange(nums, lo, i-1);
        res[0] = i;
        res[1] = k;
        return res;
    }
    private void exchange(int[] nums, int i, int j){
        int temp =  nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}