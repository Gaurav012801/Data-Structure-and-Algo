class Solution {
    public int repeatedStringMatch(String a, String b) {

        StringBuilder s = new StringBuilder();

        int count = 0;

        // Repeat until the length is at least b.length()
        while (s.length() < b.length()) {
            s.append(a);
            count++;
        }

        // Check if b exists
        if (s.indexOf(b) != -1) {
            return count;
        }

        // b can extend at most one more repetition of a
        s.append(a);

        if (s.indexOf(b) != -1) {
            return count + 1;
        }

        return -1;
    }
}