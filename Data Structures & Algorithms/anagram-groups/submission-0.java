class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        int n = strs.length;
        boolean[] visited = new boolean[strs.length];
        for(int i = 0; i < n; i++){
            if(visited[i]){
                continue;
            }
            List<String> list = new ArrayList<>();
            visited[i] = true;
            list.add(strs[i]);
            for(int j = i + 1; j < n; j++){
                if(!visited[j] && isAnagram(strs[i], strs[j])){
                    list.add(strs[j]);
                    visited[j] = true;
                }
            }
            res.add(list);
        }
        return res;
    }
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int n = s.length();
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        for (int i : freq) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
