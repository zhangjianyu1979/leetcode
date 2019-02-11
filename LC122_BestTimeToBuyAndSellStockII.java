class Solution {
    public int maxProfit(int[] prices) {
        if((prices == null)||(prices.length < 2))
            return 0;

        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            int temp = prices[i]-prices[i-1];
            if(temp > 0)
                profit = profit + temp;
        }
        return profit;
    }
}
