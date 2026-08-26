class Solution {

    public String shortestBeautifulSubstring(String s, int k) {

        int start = 0;
        int count = 0;

        String ans = "";

        for (int end = 0; end < s.length(); end++) {

            // Add current character
            if (s.charAt(end) == '1') {
                count++;
            }

            // We have exactly k ones
            while (count == k) {

                String current = s.substring(start, end + 1);

                // Update answer
                if (ans.equals("")
                        || current.length() < ans.length()
                        || (current.length() == ans.length()
                            && current.compareTo(ans) < 0)) {

                    ans = current;
                }

                // Remove from left
                if (s.charAt(start) == '1') {
                    count--;
                }

                start++;
            }
        }

        return ans;
    }
}