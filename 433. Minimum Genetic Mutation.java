// Simmilar as Word Ladder
// Use Queue to avoid memory exceed
class Solution {
   public int minMutation(String start, String end, String[] bank) {
        if(start.equals(end)) return 0;
char[] chars = {'A','T', 'C','G'};
HashSet<String> dic = new HashSet<>();
for(String e : bank) dic.add(e);
if(!dic.contains(end)) return -1;
Queue<String> headSet = new LinkedList<>();
//HashSet<String> tailSet = new HashSet<>();
HashSet<String> visitted = new HashSet<>();
headSet.add(start);
//tailSet.add(end);
visitted.add(start);
int count = 0;

while(!headSet.isEmpty()){
	int n = headSet.size();
    for (int k = 0; k < n; k++){
    	String e = headSet.poll();
        char[] str = e.toCharArray();
        for(int i = 0; i < e.length(); i++){
            for(char c : chars){
                    char old = str[i];
                    str[i] = c;
                    String s = String.valueOf(str);
                    if(s.equals(end)) return count + 1;
                    if(!visitted.contains(s) && dic.contains(s)) {
                    	headSet.offer(s);
                        visitted.add(s);
                    } 
                    str[i] = old;
            }
        }
     }
    count++;
}
 return -1;
}
}