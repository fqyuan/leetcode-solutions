class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //  List<List<String>> res = new List<List<>>();
          Hashtable<List<Integer>, List<String>> table = new Hashtable<>();
          for(String e : strs){
              List<Integer> count = new ArrayList<>(26);
              for(int i = 0; i < 26; i++) count.add(0);
              for(char c : e.toCharArray()){
                  int i = c - 'a';
                  count.set(i,count.get(i)+1);
              }
              if(!table.containsKey(count)) {
                table.put(count, new ArrayList<>());
              }
              table.get(count).add(e);
          }
            return new ArrayList<List<String>>(table.values());
      }
}