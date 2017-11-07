class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dic = new HashSet<>();
        for(String e : wordList) {
            dic.add(e);
        }
         if (!dic.contains(endWord)) return 0;
        HashSet<String> headSet = new HashSet<>();
        HashSet<String> tailSet = new HashSet<>();
        HashSet<String> visitted = new HashSet<>();
        headSet.add(beginWord);
        tailSet.add(endWord);
        visitted.add(endWord);
        visitted.add(beginWord);
        int length = 2;
        while(!headSet.isEmpty() && !tailSet.isEmpty()){
            if(headSet.size() > tailSet.size()){
                HashSet<String> tmp = headSet;
                headSet = tailSet;
                tailSet = tmp;
            }
            HashSet<String> tmp = new HashSet<>();
            for (String e : headSet){
                char[] str = e.toCharArray();
                for(int i = 0; i < e.length(); i++){
                    for(char c  = 'a'; c <= 'z'; c++){
                       
                            char old = str[i];
                            str[i] = c;
                            String s = String.valueOf(str);
                            if(tailSet.contains(s)) return length;
                            if(!visitted.contains(s) && dic.contains(s)) {
                                tmp.add(s);
                                visitted.add(s);
                            } 
                            str[i] = old;
                        
                    }
                }
            }
            headSet = tmp;
            length++;
        }
        return 0;
    }
}