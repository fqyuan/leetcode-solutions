class Solution {
    //int[] height;
    public int maxArea(int[] height) {
      //  this.height = height;
        int lo = 0;
        int hi = height.length - 1;
        int max = 0;
        int tmp;
        do {
            if(height[lo] < height[hi]){
                 tmp = (hi-lo)*height[lo];
                 int old = height[lo];
                 do {
                     lo++;
                 } while (lo < hi && old >= height[lo]);
            } else {
                 tmp = (hi-lo)*height[hi];
                 int old = height[hi];
                 do {
                     hi--;
                 } while (lo < hi && old >= height[hi]);
            }
            if(tmp>max) max = tmp;

        }while (lo < hi);
       return max;
    }

}