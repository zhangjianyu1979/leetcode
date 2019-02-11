class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        int[] count = new int[26];
        for (char item : s.toCharArray()){
            count[item-'a']++;
        }
        for (char item : t.toCharArray()){
            count[item-'a']--;
        }
        for(int i = 0; i < 26 ; i++){
            if(count[i]!= 0)
                return false;
        }
        return true;
    }
}
