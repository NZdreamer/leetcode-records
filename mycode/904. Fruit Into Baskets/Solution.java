class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap();
        //int count = 0;
        int i = 0;
        int max = 0;
        
        for (int j = 0; j < fruits.length; j++) {
            //if (!map.containsKey(fruits[j])) count++;
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
            
            while (map.size() > 2) {
                map.put(fruits[i], map.get(fruits[i]) - 1);
                if (map.get(fruits[i]) == 0) {
                    map.remove(fruits[i]);
                    //count--;
                }
                i++;
            }
            
            max = Math.max(max, j - i + 1);
        }
        
        return max;
    }
}