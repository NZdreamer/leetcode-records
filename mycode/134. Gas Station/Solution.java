class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // for (int i = 0; i < gas.length; i++) {
        //      if (canTravel(gas, cost, i)) return i;
        //  }
        // return -1;
        
        int tank = 0;
        int res = 0;
        
        int gasTotal = 0;
        int costTotal = 0;
        // for (int i = 0; i < gas.length; i++) {
        //     gasTotal += gas[i];
        //     costTotal += cost[i];
        // }
        // if (gasTotal < costTotal) return -1;
        
        for (int i = 0; i < gas.length; i++) {
            gasTotal += gas[i];
            costTotal += cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
                res = i + 1;
                tank = 0;
            }
        }
        if (gasTotal < costTotal) return -1;
        return res % gas.length;
        
    }
    
    // public boolean canTravel(int[] gas, int[] cost, int pos) {
    //     int remain = gas[pos];
    //     int size = gas.length;
    //     for (int i = 0; i < size; i++) {
    //         if (remain - cost[(pos + i) % size] < 0) return false;
    //         remain = remain - cost[(pos + i) % size] + gas[(pos + i + 1) % size];            
    //     }
    //     return true;
    // }
}