class Solution {
    public String sortVowels(String s) {
        int[] freq = new int[128];

        // Count vowels
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (isVowel(c)) {
                freq[c]++;
            }
        }

        StringBuilder ans = new StringBuilder();
        int index = 0;

        // Replace vowels in sorted order
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (isVowel(c)) {

                while (!isVowel((char) index) || freq[index] == 0) {
                    index++;
                }

                ans.append((char) index);
                freq[index]--;
            } else {
                ans.append(c);
            }
        }

        return ans.toString();
    }

    public boolean isVowel(char c) {
        return c == 'A' || c == 'E' || c == 'I' ||
               c == 'O' || c == 'U' ||
               c == 'a' || c == 'e' || c == 'i' ||
               c == 'o' || c == 'u';
    }
}