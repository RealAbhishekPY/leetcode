class RandomizedSet {
    Random rand = new Random();
    List<Integer> list = new ArrayList();
    Map<Integer, Integer> valToInd = new HashMap();

    public boolean insert(int num) {
        if (valToInd.containsKey(num)) {
            return false;
        }
        valToInd.put(num, list.size());
        list.add(num);
        return true;
    }

    public boolean remove(int num) {
        if (!valToInd.containsKey(num)) {
            return false;
        }

        int indexToRemove = valToInd.get(num);
        int valueLast = list.get(list.size() - 1);

        // update List
        list.set(indexToRemove, valueLast);
        list.remove(list.size() - 1);

        // update Map
        valToInd.put(valueLast, indexToRemove);
        valToInd.remove(num);

        return true;
    }

    public int getRandom() { // will fail if set is empty.
        int index = rand.nextInt(list.size());
        return list.get(index);
    }
}
