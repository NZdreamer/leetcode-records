#include <iostream>
#include <string>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

vector<int> path;
int minValue = INT_MAX;

void dfs(vector<vector<int>> graph, int layer, vector<int> tmp, int dest, int node, unordered_set<int> set) {
  //cout << layer << " ";
  if (node == dest) {
    if (layer < minValue) {
      minValue = layer;
      path.assign(tmp.begin(), tmp.end());
    }
  }
  if (graph[node].size() == 0) return;
  for (int i = 0; i < graph[node].size(); i++) {
    if (set.find(node) != end(set)) continue;
    tmp.push_back(node);
    set.insert(node);
    dfs(graph, layer + 1, tmp, dest, graph[node][i], set);
    tmp.pop_back();
    set.erase(node);
  }
  //return;
}


string ShortestPath(string strArr[], int arrLength) {
  
  // code goes here  
  int n = stoi(strArr[0]);
  unordered_map<string, int> nodes_map;
  for (int i = 1; i < n + 1; i++) {
    nodes_map[strArr[i]] = i;
  }
  vector<vector<int>> graph;
  for (int i = n + 1; i < arrLength; i++) {
    int breakpoint = strArr[i].find('-');
    string p1 = strArr[i].substr(0, breakpoint);
    string p2 = strArr[i].substr(breakpoint + 1);
    graph[nodes_map[p1]].push_back(nodes_map[p2]);
    graph[nodes_map[p2]].push_back(nodes_map[p1]);
  }
  vector<int> tmp;
  unordered_set<int> set;
  tmp.push_back(1);
  set.insert(1);
  dfs(graph, 0, tmp, n, 1, set);
  if (path.size() == 0) return "-1";
  string res = "";
  for (int i = 0; i < path.size(); i++) {
    res += strArr[path.at(i)];
    res += "-";
  }
  res = res.substr(0, res.size() - 1);
  return res;
}



int main(void) { 
   
  // keep this function call here
  string A[] = coderbyteInternalStdinFunction(stdin);
  int arrLength = sizeof(A) / sizeof(*A);
  cout << "start";
  cout << ShortestPath(A, arrLength);
  cout << "end";
  return 0;
    
}