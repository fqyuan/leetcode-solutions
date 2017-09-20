class Solution {
            List<String> res = new LinkedList<String>();

    public List<String> generateParenthesis(int n) {
        bt("",0,0,n);
        return res;
    }
    private void bt(String str, int open, int close, int n){
        if (str.length()==2*n) {
            res.add(str);
            return;
        }
        if(open < n) bt(str+"(", open + 1, close, n);
        
        if(close < open) bt(str+")", open, close + 1, n);
    }
}