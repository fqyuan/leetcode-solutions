public class Solution {
  public double myPow(double x, int n) {  
        if(n == 0) return 1;
        if(n == 1)  return x;
        if(n == -1) return 1/x;public class Solution {
        if(n == 2) return x*x;
        if (n%2 == 0) return myPow(myPow(x,n/2),2);
        else if (n > 0)
            return myPow(myPow(x,n/2), 2)*x;
        else
            return 1/x*myPow(myPow(x,n/2), 2);
    }
}