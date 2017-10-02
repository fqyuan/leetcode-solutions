class Solution {
        public void nextPermutation(int[] nums) {
            if (nums.length < 2) return ;
            int i = nums.length - 2;
            while(i >= 0 && nums[i] >= nums[i + 1]) i--;
            if(i < 0) {
                for(i = 0; i < nums.length/2; i++) {
                    swap(nums, i,nums.length - i -1);
                }
                
            } else {
                int j = nums.length - 1;
                while(nums[j] <= nums[i]) j--;
                swap(nums, j,i);
           
                i++;
                int n = (nums.length -1  + i)/2;
                int k = nums.length - 1;
                while(i <= n){
                    swap(nums,k, i);
                    i++;
                    k--;
                }
            }
            
        }
        private void swap(int[] nums, int a, int b) {
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
        }
}