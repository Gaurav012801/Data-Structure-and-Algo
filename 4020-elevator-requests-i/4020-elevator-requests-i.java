class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int totalSecond=requests[0];
        for(int i=1;i<requests.length;i++){
            totalSecond+=Math.abs(requests[i-1]-requests[i]);
        }
        return totalSecond;
    }
}