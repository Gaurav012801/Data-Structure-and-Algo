class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        double total=0;
        Arrays.sort(prices);
        Arrays.sort(discounts);
        int price=prices.length-1;
        int discount=discounts.length-1;
        while(price>=0 && discount>=0){
            total+=prices[price]*(100-discounts[discount])/100.0;
            price--;
            discount--;
        }
        while(price>=0){
            total+=prices[price];
            price--;
        }
        return total;
    }
}