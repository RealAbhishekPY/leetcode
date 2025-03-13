### Code

```java
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (mapST.containsKey(charS)) {
                if (mapST.get(charS) != charT) {
                    return false;
                }
            } else {
                mapST.put(charS, charT);
            }

            if (mapTS.containsKey(charT)) {
                if (mapTS.get(charT) != charS) {
                    return false;
                }
            } else {
                mapTS.put(charT, charS);
            }
        }

        return true;
    }
}
```

### Explanation

1. **Class Definition**:
   ```java
   public class Solution {
   ```
   This defines a public class named `Solution`.

2. **Method Definition**:
   ```java
   public boolean isIsomorphic(String s, String t) {
   ```
   This defines a public method named `isIsomorphic` that takes two strings `s` and `t` as parameters and returns a boolean indicating whether `s` and `t` are isomorphic.

3. **Length Check**:
   ```java
   if (s.length() != t.length()) {
       return false;
   }
   ```
   This checks if the lengths of `s` and `t` are different. If they are, the method returns `false` because they cannot be isomorphic.

4. **Map Initialization**:
   ```java
   Map<Character, Character> mapST = new HashMap<>();
   Map<Character, Character> mapTS = new HashMap<>();
   ```
   This initializes two `HashMap`s: `mapST` to map characters from `s` to `t`, and `mapTS` to map characters from `t` to `s`.

5. **Loop Through Strings**:
   ```java
   for (int i = 0; i < s.length(); i++) {
       char charS = s.charAt(i);
       char charT = t.charAt(i);
   ```
   This loop iterates through each character in the strings `s` and `t`.

6. **Check and Update Maps**:
   ```java
   if (mapST.containsKey(charS)) {
       if (mapST.get(charS) != charT) {
           return false;
       }
   } else {
       mapST.put(charS, charT);
   }

   if (mapTS.containsKey(charT)) {
       if (mapTS.get(charT) != charS) {
           return false;
       }
   } else {
       mapTS.put(charT, charS);
   }
   ```
   For each character pair `(charS, charT)`, the code checks if `charS` is already mapped to a different character in `mapST` or if `charT` is already mapped to a different character in `mapTS`. If either condition is true, the method returns `false`. Otherwise, it updates the maps with the new character pair.

7. **Return Result**:
   ```java
   return true;
   ```
   If the loop completes without finding any conflicts, the method returns `true`, indicating that `s` and `t` are isomorphic.

### Summary
The `isIsomorphic` method uses two `HashMap`s to track the character mappings between `s` and `t`. It ensures that each character in `s` maps to a unique character in `t` and vice versa, preserving the order of characters.
