class Solution {
    public boolean canBeEqual(String s1, String s2) {
        boolean evenindex = (s1.charAt(0) == s2.charAt(0) && s1.charAt(2) == s2.charAt(2)) ||
                             (s1.charAt(2) == s2.charAt(0) && s1.charAt(0) == s2.charAt(2));

        boolean oddindex = (s1.charAt(1) == s2.charAt(1) && s1.charAt(3) == s2.charAt(3)) ||
                             (s1.charAt(3) == s2.charAt(1) && s1.charAt(1) == s2.charAt(3));
        return evenindex && oddindex;
    }
}