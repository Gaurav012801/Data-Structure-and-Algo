class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Store reserved seats as a bitmask for each row
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            // Only seats 2 to 9 matter
            if (col >= 2 && col <= 9) {
                int mask = 1 << (col - 2);
                map.put(row, map.getOrDefault(row, 0) | mask);
            }
        }

        // Initially every row can fit 2 families
        int ans = (n - map.size()) * 2;

        for (int mask : map.values()) {

            // 2,3,4,5
            int left = 0b00001111;

            // 4,5,6,7
            int middle = 0b00111100;

            // 6,7,8,9
            int right = 0b11110000;

            boolean canLeft = (mask & left) == 0;
            boolean canMiddle = (mask & middle) == 0;
            boolean canRight = (mask & right) == 0;

            if (canLeft && canRight) {
                ans += 2;
            } 
            else if (canLeft || canMiddle || canRight) {
                ans += 1;
            }
        }

        return ans;
    }
}