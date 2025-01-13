import java.util.*;

class Solution {
    static class Stock{
        int idx;
        int price;
        
        public Stock(int idx, int price){
            this.idx = idx;
            this.price = price;
        }
    }
    public int[] solution(int[] prices) {
        ArrayDeque<Stock> deque = new ArrayDeque<>();
        
        int[] ans = new int[prices.length];
        
        for(int i = 0; i < prices.length; i++){
            int price = prices[i];
            
            while(!deque.isEmpty()){
                if(deque.peekLast().price > price){
                    Stock stock = deque.pollLast();
                    
                    ans[stock.idx] = i - stock.idx;
                }else{
                    break;
                }
            }
            deque.addLast(new Stock(i, price));
        }
        
        while(!deque.isEmpty()){
            Stock stock = deque.pollLast();
            ans[stock.idx] = (prices.length - 1) - stock.idx;
        }

        return ans;
    }
}