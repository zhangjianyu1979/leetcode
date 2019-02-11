class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null)
            return null;
        int[] res = new int[2];
        res[1] = numbers.length-1;
        res[0] = 0;
        while(res[0]< res[1]){
            if(numbers[res[0]] + numbers[res[1]] == target)
                break;
            if(numbers[res[0]] + numbers[res[1]]  < target)
                res[0]++;
            else
                res[1]--;
        }
        res[0]++;
        res[1]++;
        return res;
    }
}
