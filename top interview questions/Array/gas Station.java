public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, currentGas = 0, startIndex = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i] - cost[i];
            currentGas += gas[i] - cost[i];
            if (currentGas < 0) {
                startIndex = i + 1;
                currentGas = 0;
            }
        }
        return totalGas >= 0 ? startIndex : -1;
    }
}
