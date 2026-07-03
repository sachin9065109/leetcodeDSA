class Solution {

    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length())
            return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char c : s1.toCharArray())
            freq1[c - 'a']++;

        int window = s1.length();

        for (int i = 0; i < window; i++)
            freq2[s2.charAt(i) - 'a']++;

        if (Arrays.equals(freq1, freq2))
            return true;

        for (int i = window; i < s2.length(); i++) {

            freq2[s2.charAt(i) - 'a']++;

            freq2[s2.charAt(i - window) - 'a']--;

            if (Arrays.equals(freq1, freq2))
                return true;
        }

        return false;
    }
}