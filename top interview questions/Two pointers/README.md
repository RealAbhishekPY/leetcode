# Two-Pointer Technique in Java for Solving DSA Problems

The **two-pointer technique** is a powerful and efficient method for solving various DSA problems, especially those involving arrays and strings. It involves using two pointers to traverse the data structure from different directions.

#### Example Problem: Remove Duplicates from Sorted Array
Given a sorted array, remove the duplicates in-place such that each element appears only once and return the new length.

#### Solution Using Two Pointers
```java
public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 4, 4};
        int length = removeDuplicates(nums);
        System.out.println("New length: " + length); // Output: New length: 4
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " "); // Output: 1 2 3 4
        }
    }
}
```

### Explanation:
- **Pointers**: Use two pointers, `i` and `j`. `i` tracks the position of the last unique element, while `j` traverses the array.
- **Comparison**: Compare elements at `i` and `j`. If they are different, increment `i` and update `nums[i]` with `nums[j]`.
- **Result**: The new length of the array is `i + 1`.

#### Example Problem: Container With Most Water
Given an array of integers representing the heights of vertical lines, find the maximum area of water that can be contained.

#### Solution Using Two Pointers
```java
public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, width * minHeight);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Max `left` and `right`, to traverse the array from both ends.
- **Area Calculation**: Calculate the area formed by the lines at `left` and `right`.
- **Move Pointers**: Move the pointer pointing to the shorter line inward to potentially find a larger area.

#### Example Problem: Valid Palindrome
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

#### Solution Using Two Pointers
```java
public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println("Is palindrome: " + isPalindrome(str)); // Output: Is palindrome: true
    }
}
```

### Explanation:
- **Pointers**: Use two pointers, `left` and `right`, to traverse the string from both ends.
- **Skip Non-Alphanumeric**: Skip non-alphanumeric characters.
- **Comparison**: Compare characters at `left` and `right` after converting them to lowercase.
- **Result**: Return `true` if all characters match, otherwise `false`.

### Benefits of Two-Pointer Technique
- **Efficiency**: Reduces time complexity by avoiding nested loops.
- **Simplicity**: Easy to implement and understand.
- **Versatility**: Applicable to a wide range of problems involving arrays and strings.

Feel free to ask if you have any specific problems or concepts you'd like to explore further!
