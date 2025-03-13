### Code
```java
class Solution {
    public List<List<String>> groupAnagrams(String[] array) {
        if (array == null || array.length == 0) {
            return Collections.emptyList();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String str : array) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
```

### Code Overview
The code is a Java solution to group anagrams from a given array of strings. Anagrams are words that contain the same characters in different orders. The solution involves sorting the characters of each string to use as a key in a map, where the values are lists of anagrams.

### Code Breakdown

1. **Imports and Class Definition**:
    ```java
    import java.util.*;

    class Solution {
    ```
    - The code imports necessary classes from the `java.util` package.
    - Defines a class named `Solution`.

2. **Main Method**:
    ```java
    public List<List<String>> groupAnagrams(String[] array) {
        if (array == null || array.length == 0) {
            return Collections.emptyList();
        }

        Map<String, List<String>> map = new HashMap<>();
    ```
    - The `groupAnagrams` method takes an array of strings as input and returns a list of lists of strings.
    - It first checks if the input array is null or empty and returns an empty list if true.
    - Initializes a `HashMap` to store sorted character strings as keys and lists of anagrams as values.

3. **Processing Each String**:
    ```java
    for (String str : array) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String key = new String(chars);
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
    }
    ```
    - Iterates through each string in the input array.
    - Converts the string to a character array and sorts it.
    - Converts the sorted character array back to a string to use as a key.
    - Uses `computeIfAbsent` to add the string to the corresponding list in the map, creating a new list if the key does not exist.

4. **Returning the Result**:
    ```java
    return new ArrayList<>(map.values());
    }
    ```
    - Converts the values of the map (which are lists of anagrams) to an `ArrayList` and returns it.

### Summary
- **Input**: An array of strings.
- **Output**: A list of lists, where each list contains anagrams.
- **Key Operations**:
  - Sorting characters of each string to create a key.
  - Using a map to group strings with the same sorted character key.
  - Efficiently handling map operations with `computeIfAbsent`.

