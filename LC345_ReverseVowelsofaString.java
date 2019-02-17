class Solution {
    public String reverseVowels(String s) {
        char[] chs = s.toCharArray();
        String strVowels = "aeiouAEIOU";
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < chs.length; i++){
            if(strVowels.indexOf(chs[i]) != -1)
                stack.push(chs[i]);
        }
        for(int i = 0; i < chs.length; i++){
            if(strVowels.indexOf(chs[i]) != -1)
                chs[i] = stack.pop();
        }

        return new String(chs);
    }
}
