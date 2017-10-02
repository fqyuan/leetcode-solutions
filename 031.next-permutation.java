class Solution {
        public void nextPermutation(int[] nums) {
            if (nums.length < 2) return ;
            int i = nums.length - 2;
            while(i >= 0 && nums[i] >= nums[i + 1]) i--;
            if(i >= 0) {
                int j = nums.length - 1;
                while(nums[j] <= nums[i]) j--;
                swap(nums, j,i);  
            }
            reverse(nums, i);   
        }
        private void reverse (int[] nums, int begin){
            int end = nums.length- 1;
            while(++begin < end) {
                swap(nums, begin, end--);
            }
        }
        private void swap(int[] nums, int a, int b) {
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
        }
}