/*
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays
 *
 * algorithms
 * Hard (21.88%)
 * Total Accepted:    188.6K
 * Total Submissions: 861.6K
 * Testcase Example:  '[1,3]\n[2]'
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * Example 1:
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * The median is 2.0
 * 
 * 
 * 
 * Example 2:
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 * 
 */
 class Solution {
	    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	    	boolean EVEN = true;
	    	boolean ODD = false;
	    	boolean flag = (nums1.length + nums2.length)%2 == 0 ? EVEN : ODD;
	    	        int i = 0;
	        int j = 0;
	        int left = (nums1.length + nums2.length)/2;
	        if (flag == EVEN) left = left - 1;

	        for (int n = 0; n < left; n++ ) {
	        	if(i < nums1.length && j <nums2.length) {
	        		if (nums1[i] < nums2[j])
		                i++;
		            else 
		                j++;
	        	} else if(i < nums1.length) {
	        		i++;
	        	}else {
	        		j++;
	        	}
	        	
	            
	        }
	        if (flag == ODD) {
	        	if(i < nums1.length && j <nums2.length) {
	        		return Math.min(nums1[i],nums2[j]);
	        	} else if(i < nums1.length) {
	        		return nums1[i];
	        	}else {
	        		return nums2[j];
	        	}
	        	
	        }
	            
	        else {
	        	double sum = 0;
	        	for(int t = 0; t < 2; t++){
	        	if(i < nums1.length && j <nums2.length) {
	        		
		        		if (nums1[i] < nums2[j])
		        			sum += nums1[i++];
		        		else 
		        			sum += nums2[j++];
	 
	        	} else if(i < nums1.length) {
	        		sum += nums1[i++] ;
	    
	        	}else {
	        		sum += nums2[j++];
	        	}
	        	}
	        	return sum/2;
	        }
	           
	    }
	}