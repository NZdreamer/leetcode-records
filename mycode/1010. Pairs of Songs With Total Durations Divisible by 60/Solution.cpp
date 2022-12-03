#include <vector>

using namespace std;

class Solution {
public:
    int numPairsDivisibleBy60(vector<int>& time) {
        int res = 0;
        // unordered_map<int, int> map;
        vector<int> v(60);  // vector of size 60, with defalut value 0
        for (int t : time) {
            t = t % 60;
            res += v[(60 - t) % 60];
            v[t]++;
            // if (map.find((60 - t) % 60) != map.end()) {
            //     res += map[(60 - t) % 60];
            // }
            // if (map.find(t) == map.end()) {
            //     map[t] = 1;
            // }
            // else map[t]++;
            
        }
        return res;
    }
};