public class Solution {
    public boolean isPalindrome(String s) {
        // If the input string is null or has a length of 1 or less, it is a palindrome
        if (s == null || s.length() <= 1) {
            return true;
        }
        
        // Initialize two pointers
        int left = 0, right = s.length() - 1;
        
        // Use two-pointer approach to check for palindrome
        while (left < right) {
            // Move left pointer to the next alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // Move right pointer to the previous alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            // Compare characters at left and right pointers
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false; // Characters do not match, not a palindrome
            }
            left++;
            right--;
        }
        
        return true; // All characters match, it is a palindrome
    }
}    
