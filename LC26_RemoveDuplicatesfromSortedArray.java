class Solution {
    public int removeDuplicates(int[] nums) {
        if((nums == null) || (nums.length ==0))
            return 0;
        int idx = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[idx]){
                if(i > idx+1)
                    nums[idx+1] = nums[i];
                idx++;
            }
        }
        return idx+1;
    }
}
// 要判断idx和当前数值之间有间隙，否则只idx++，不做移动。 1 1 3 (要覆盖第二个1，覆盖第一个1就错了)
