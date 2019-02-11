// V1
// O(n2) 
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++){
            for(int j = i + 1; j < prices.length; j++){
                maxProfit = Math.max(prices[j] - prices[i], maxProfit);
            }
        }
        return maxProfit;
    }
}

// V2
// ...O(n)  
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minVal = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++){
            minVal = Math.min(minVal, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minVal);
        }
        return maxProfit;
    }
}

// 20190210 
class Solution {
    public int maxProfit(int[] prices) {
        if((prices == null)||(prices.length < 2))
            return 0;

        int profit = 0, smallest = prices[0];
        for(int i = 0 ; i < prices.length; i++){
            smallest = Math.min(smallest, prices[i]);
            profit = Math.max(profit, prices[i]- smallest);
        }
        return profit;
    }
}
