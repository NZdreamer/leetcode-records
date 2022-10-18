int solution(int nServers, int workLimit, int recoveryTime, String[] events) {
    int[] served = new int[nServers];
    int[] work = new int[nServers];
    int[] maintime = new int[nServers];
    
    int s = 0;
    for (int i = 0; i < events.length; i++) {
        s = s % nServers;
        if (events[i].equals("REQUEST")) {
            while (maintime[s] != 0) {
                s++;
                s = s % nServers;
            }
            served[s]++;
            work[s]++;
            if (work[s] == workLimit) {
                maintime[s] = recoveryTime;
                work[s] = 0;
            }
            for (int j = 0; j < nServers; j++) {
                if (maintime[j] != 0) {
                    maintime[j]--;
                }
            }
            s++;
            s = s % nServers;
        }
        else {
            int upS = Integer.valueOf(events[i].split(" ")[1]);
            work[upS] = 0;
            maintime[upS] = 0;
        }
    }
    
    int res = 0;
    int idx = 0;
    for (int i = 0; i < served.length; i++) {
        if (res >= served[i]) {
            res = Math.max(res, served[i]);
            idx = i;
        }
        
    }
    return idx;
}
