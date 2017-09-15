public class Solution {	   
public String convert(String s, int numRows) {
            
	    	char[] c = s.toCharArray();
	       StringBuilder[] m = new StringBuilder[numRows];
            for(int i = 0; i < m.length; i++) m[i] = new StringBuilder(); 
	       int i = 0;
	       while(i < c.length){
	    	   for (int id = 0; id < numRows && i < c.length; id++){
	    		   m[id].append(c[i++]);
	    	   }
	    	   for(int iu = numRows - 2; iu >= 1 && i < c.length; iu--){
	    		   m[iu].append(c[i++]);
	    	   }
	       }
	       for (int j = 1; j < m.length; j++)
	       {
	    	   m[0].append(m[j]);
	       }
	       return m[0].toString();
	    }
}