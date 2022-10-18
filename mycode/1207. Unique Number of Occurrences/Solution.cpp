#include <unordered_map>
#include <vector>
#include <unordered_set>

using namespace std;

class Solution {
    public:
        bool uniqueOccurrences(vector<int>& arr) {
            unordered_set<int> occ;
            unordered_map<int, int> map;
            for (int num : arr) {
                if (map.find(num) == map.end()) {
                    map[num] = 1;
                }
                else {
                    // int feq = map[num];
                    // map[num] = feq + 1;
                    map[num]++;
                }
            }
            for (pair<int, int> p : map) {
                if (occ.find(p.second) != occ.end()) return false;
                occ.insert(p.second);
            }
            return true;
        }
    };