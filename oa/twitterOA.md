# Activate fountain



```java
class ActivateFountainsIntervalMergeOptimized {
    /**
     * *1 2 3 4 5  6
     * [2,1,2,1,2,4] n = 6
     * <p>
     * [(1,3),(1,3),(1,5),(3,5),(3,6), (2,6)]
     * <p>
     *
     * @param fountains
     * @return
     */
    public int activateFountains(int[] fountains) {
        int n = fountains.length;

        int interval[] = new int[n];

        for (int i = 1; i <= n; i++) {

            int left = Math.max(i - fountains[i - 1], 1);
            int right = Math.min(i + fountains[i - 1], n);

            interval[left - 1] = Math.max(interval[left - 1], right); //make sure at this point we reach as far as possible on right. 

        }


        int right = interval[0];
        int nextGreaterRight = right;

        int fountainsActivate = 1;

        /**
         * 1 2 3 4 5  6
         * [2,1,2,1,2,4] n = 6
         * <p>
         * [(1,3),(1,3),(1,5),(3,5),(3,6), (2,6)]
         * <p>
         * [5,6,6,0,0,0]
         *
         * @param fountains
         * @return
         */
        for (int i = 1; i < n; i++) {
            nextGreaterRight = Math.max(nextGreaterRight, interval[i]);

            /**
             * If the last fountain can cover only this point, then update with next fountain.
             */
            if (i == right) {
                fountainsActivate++;
                right = nextGreaterRight;
            }


        }

        return fountainsActivate;
    }
 public static void main(String[] args) {
        test(new int[]{0, 0, 0, 3, 0, 0, 2, 0, 0}, 2);
        test(new int[]{0, 0, 0, 3, 0, 0, 2, 0, 0}, 2);
        test(new int[]{3, 0, 2, 0, 1, 0}, 2);
        test(new int[]{3, 0, 1, 0, 1, 0}, 2);
        test(new int[]{3, 0, 1, 0, 0, 1}, 2);
        test(new int[]{2, 0, 2, 0, 1, 0}, 2);
        test(new int[]{2, 0, 0, 0, 0}, 3);
        test(new int[]{0, 0, 0, 0, 0}, 5);
        test(new int[]{1, 2, 1}, 1);
        test(new int[]{0, 1, 0}, 1);
        test(new int[]{2, 1, 2, 1, 2, 4}, 2);
        test(new int[]{0, 0, 0, 0, 2, 0, 2, 3}, 4);


    }

    private static void test(int[] fountains, int expected) {
        System.out.println(Printer.toString(fountains));

        ActivateFountainsIntervalMerge intervalsMerge = new ActivateFountainsIntervalMerge();
        ActivateFountainsIntervalMergeOptimized optimized = new ActivateFountainsIntervalMergeOptimized();
        System.out.println("intervalsMerge; Obtained :" + intervalsMerge.activateFountains(fountains) + "expected :" + expected);
        System.out.println("intervalsMerge-optimized; Obtained :" + optimized.activateFountains(fountains) + "expected :" + expected);
    }
}
```

# Anagram Difference

```java
public static List<Integer> getMinimumDifference(List<String> a, List<String> b) {
    // Write your code here
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<a.size();i++){
            result.add(countDifference(a.get(i),b.get(i)));
        }
    
        return result;
    }
    public static int countDifference(String s1 , String s2){
        if(s1.length()!=s2.length()){
            return -1;
        }
    int count = 0; 
  
        // store the count of character 
        int char_count[] = new int[26]; 
  
        // iterate though the first String and update  
        // count 
        for (int i = 0; i < s1.length(); i++)  
            char_count[s1.charAt(i) - 'a']++;         
  
        // iterate through the second string 
        // update char_count. 
        // if character is not found in char_count 
        // then increase count 
        for (int i = 0; i < s2.length(); i++)  
            if (char_count[s2.charAt(i) - 'a']-- <= 0) 
                count++; 
          
        return count; 
    }
```

# Authentication Tokens

```java
public static int numberOfTokens(int expiryLimit, List<List<Integer>> commands) {
	        if(commands == null || commands.isEmpty()) {
	            //invalid input
	            return 0;
	        }
	        //maintain tokenid with expiry in a map
	        Map<Integer, Integer> tokenIdToTokenExpiry = new HashMap<>();

	        for (List<Integer> token : commands) {
	            if(token.size() != 3){
	                //invalid input
	                return 0;
	            }
	            //tokenCommand can be either 0 (get) or 1 (reset)
	            Integer tokenCommand = token.get(0);
	            Integer tokenId = token.get(1);
	            Integer tokenTime = token.get(2);
	            
	            if(tokenCommand == 0){
	                // Get command
	                tokenIdToTokenExpiry.put(tokenId, tokenTime + expiryLimit);
	            } else {
	                //Reset command
	                if(tokenIdToTokenExpiry.containsKey(tokenId)){
	                    if(tokenTime <= tokenIdToTokenExpiry.get(tokenId)){
	                        //If not expired, update token time with new value
	                        tokenIdToTokenExpiry.put(tokenId, tokenTime + expiryLimit);
	                    } else {
	                        //if expired, remove token from map
	                        tokenIdToTokenExpiry.remove(tokenId);
	                    }
	                }
	            }
	        }
	        
	        //find the last inputed tokentime and filter data based on expiry
	        Integer lastTime = commands.get(commands.size() - 1).get(2);        
	        return (int) tokenIdToTokenExpiry.values().stream().filter(tokenTime ->  tokenTime >= lastTime).count();
	    }
```



# balanced sales array

```java
public static int balancedSum(List<Integer> sales) {
    // Write your code here     
		int sum =0;
        for(int i=0;i<list.size();i++){
            sum += list.get(i);
        }
        int curr =list.get(0);
        for(int i=1;i<list.size();i++){
            if(curr == sum - curr - list.get(i)){
                return i;
            }
            curr += list.get(i);
        }
        return -1;
    }
```



# buying show tickets



# Coloring the blocks

```java
public static int colorBlocks(int[][] color){

        for(int i = 1; i < color.length; i++){
            color[i][0] += Math.min(color[i - 1][1], color[i - 1][2]);
            color[i][1] += Math.min(color[i - 1][0], color[i - 1][2]);
            color[i][2] += Math.min(color[i - 1][0], color[i - 1][1]);
        }
        int n = color.length - 1;
        System.out.println(Math.min(Math.min(color[n][0], color[n][1]), color[n][2]));
        return Math.min(Math.min(color[n][0], color[n][1]), color[n][2]);
    }

public static void main(String[] args){
     int[][] color = {{1,2,3},{1,2,3},{3,3,1}};
     colorBlocks(color);
}
```



# Complex Number Multiplication

```java
public String complexNumberMultiply(String a, String b) {
    String result = "";
    String[] A = a.split("\\+");
    String[] B = b.split("\\+");
    int a1 = Integer.parseInt(A[0]);
    int b1 = Integer.parseInt(A[1].replace("i",""));

    int a2 = Integer.parseInt(B[0]);
    int b2 = Integer.parseInt(B[1].replace("i",""));

    int a1a2 = a1 * a2;
    int b1b2 = b1 * b2;
    int a1b2a2b1 = (a1 * b2) + (b1 * a2);

    String afinal = (a1a2 + (-1 * b1b2)) + "";
    String bfinal = a1b2a2b1 + "i";
    result = afinal+"+"+bfinal;
    return result;
}
```



# Efficient Job Processing Service

```java
public class EfficientJobProcessingService_14 {
        int[][] dp = new int[tasks.length + 1][p / 2 + 1];      // task will be processed double of weight, hence halve p
//        for (int i = 0; i < tasks.length; i++) {
//            tasks[i] *= 2;
//        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < tasks[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - tasks[i - 1]] + weights[i - 1]);
                }
            }
        }

        return dp[tasks.length][p / 2];
    }

    public static void main(String[] args) {
        int[] weights = new int[]{2, 4, 4, 5};
        int[] tasks = new int[]{2, 2, 3, 4};
        System.out.println(new EfficientJobProcessingService_14().maximumTotalWeight(weights, tasks, 15));      // 10

        weights = new int[]{2, 2, 4, 5};
        tasks = new int[]{2, 2, 3, 4};
        System.out.println(new EfficientJobProcessingService_14().maximumTotalWeight(weights, tasks, 15));      // 9

        weights = new int[]{2};
        tasks = new int[]{2};
        System.out.println(new EfficientJobProcessingService_14().maximumTotalWeight(weights, tasks, 1));      // 0

        weights = new int[]{2};
        tasks = new int[]{2};
        System.out.println(new EfficientJobProcessingService_14().maximumTotalWeight(weights, tasks, 10));      // 2
    }
}
```



# final discounted price

```java
public static void main(String[] args) {
	int[] prices = {2,3,1,2,4,2};
	getTotalCost(prices);
}

private static void getTotalCost(int[] prices) {
	int[] tmp = new int[prices.length];
	for(int i=0;i<tmp.length;i++) {
		tmp[i] = prices[i];
	}
	Stack<Integer> s = new Stack<>();
	for(int i=0;i<prices.length;i++) {
		while(!s.isEmpty() && prices[s.peek()] >= prices[i]) {
			int pre = s.pop();
			tmp[pre] = prices[pre] - prices[i];
		}
		s.push(i);
	}
	int res = 0;
	for(int t : tmp)
		res += t;
	System.out.println(res);
	System.out.println(Arrays.toString(tmp));
}
```



# Game Events

```java
class Result {
    static class Score{
        int actualTime;
        String timeString;
        String teamName;
        String playerName;
        String substituteName;
        char eventType;
        boolean isFirstHalf;
        public Score(int actualTime, String timeString, String teamName,String playerName,String substituteName,char eventType, boolean isFirstHalf){
            this.actualTime = actualTime;
            this.timeString = timeString;
            this.teamName = teamName;
            this.playerName = playerName;
            this.substituteName = substituteName;
            this.eventType = eventType;
            this.isFirstHalf = isFirstHalf;
        }
        public String toString(){
            return  actualTime  + " " + timeString + "  " + teamName + "  " + playerName +" " +  substituteName + " "+ eventType + 
             " " + isFirstHalf;
        }
        public String getOutputString(){
            return this.teamName +" " + this.playerName + " " + this.timeString + " " + this.eventType + " " + this.substituteName;
        }
    }
    static Map<Character, Integer> map = new HashMap<>();
    public static List<String> getEventsOrder(String team1, String team2, List<String> events1, List<String> events2) {
        map.put('G', 1);
        map.put('Y', 2);
        map.put('R', 3);
        map.put('S', 4);
        List<Score> scores = new ArrayList<>();
        for(String e1: events1){
            Score score = parseString(e1, team1);
            scores.add(score);
            System.out.println(score);
        }
        for(String e2: events2){
            Score score = parseString(e2, team2);
            scores.add(score);
            System.out.println(score);
        }
        Collections.sort(scores, new Comparator<Score>(){
            public int compare(Score s1, Score s2){
                if(s1.isFirstHalf== true && s2.isFirstHalf==false){
                    return -1;
                }
                if(s1.isFirstHalf== false && s2.isFirstHalf==true){
                    return 1;
                }
                if(s1.actualTime != s2.actualTime)
                    return s1.actualTime -  s2.actualTime;
                if(map.get(s1.eventType)!= map.get(s2.eventType)){
                    return map.get(s1.eventType)- map.get(s2.eventType);
                }
                if(!s1.teamName.equals(s2.teamName))
                    return s1.teamName.compareTo(s2.teamName);
                return s1.playerName.compareTo(s2.playerName);
            }
        });
        List<String> answer = new ArrayList<>();
        for(Score score: scores){
            answer.add(score.getOutputString().trim());
        }
        return answer;

    }
    public static Score parseString(String str, String team){
        String[] words = str.split(" ");
        int time = getTimeIndex(words);
        char event = words[time+1].charAt(0);
        String player = "";
       for(int i=0;i<time;i++){
           player  = player + " " + words[i];
       }
       player = player.trim();
        String sub = "";
        if(event=='S'){
            for(int i =time+2;i<words.length;i++){
                sub += words[i] + " ";
            }
            sub = sub.trim();
        }
        int actualTime =0;
        boolean isFirstHalf = false;
        if(words[time].contains("+")){
            String timeSplit[] = words[time].split("\\+");
            actualTime += Integer.parseInt(timeSplit[0]);
            if(actualTime <= 45){
                isFirstHalf = true;
            }
            actualTime += Integer.parseInt(timeSplit[1]);
        }else{
            actualTime += Integer.parseInt(words[time]);
            if(actualTime <= 45){
                isFirstHalf = true;
            }
        }
        Score score = new Score(actualTime, words[time], team, player,  sub, event, isFirstHalf);
        return score;
    }
    public static int getTimeIndex(String[] words){
        for(int i =0;i<words.length;i++){
            if(words[i].charAt(0)>='0' && words[i].charAt(0)<='9'){
                return i;
            }
        }
        return -1;
    }


}
```

# get set go

Java solution with DFS and DP:
DP may fail with TLE when the target is a big number.



```java
public static void main(String[] args) {
	int[] nums1 = { 2, 9, 5, 1, 6 };
	int target1 = 12;
	int[] nums2 = { 2, 3, 15, 1, 16 };
	int target2 = 8;
	System.out.println(isPossible(nums1, target1));
	System.out.println(isPossible(nums2, target2));
	System.out.println("");
	System.out.println("---------------------");
	System.out.println(isPossibleDfs(nums1, target1));
	System.out.println(isPossibleDfs(nums2, target2));
	
}

private static boolean isPossibleDfs(int[] nums, int target) {
	return dfs(nums, target, 0);
}	

private static boolean dfs(int[] nums, int target, int i) {
	if(target < 0 || i >= nums.length)
		return false;
	if(target == 0)
		return true;
	if(dfs(nums, target - nums[i], i+1) || dfs(nums, target, i+1))
		return true;
	return false;
}

private static boolean isPossible(int[] nums, int target) {
	Arrays.sort(nums);
	boolean[][] dp = new boolean[nums.length+1][target + 1];
	for(int i=0;i<dp.length;i++) {
		dp[i][0] = true;
	}
	for(int i=1;i<dp.length;i++) {
		for(int j=1;j<dp[0].length;j++) {
			if(j >= nums[i-1])
				dp[i][j] |= dp[i-1][j] | dp[i-1][j-nums[i-1]];
			else
				dp[i][j] |= dp[i-1][j];
		}
	}
	return dp[dp.length-1][dp[0].length-1];	
}
```



# [K-diff Pairs in an Array](https://leetcode.com/problems/k-diff-pairs-in-an-array)

```java
public class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)   return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                //count how many elements in the array that appear more than twice.
                if (entry.getValue() >= 2) {
                    count++;
                } 
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
```

# parking dilimma

```java
 public static int minRoofLength(int[] arr, int k){
    Arrays.sort(arr);
    int start = 0;
    int minRoofLength = Integer.MAX_VALUE;
    for(int end=k-1;end<arr.length;end++){
      int currentRoofLength = arr[end]-arr[start++]+1;
      minRoofLength = Math.min(minRoofLength, currentRoofLength);
    }
    return minRoofLength;
  }
```



# Partitioning array

make sure `numbers.length` is divisible by `k` and no element appears more than `numbers.length/k` times

```java
public static boolean partitionArrayUnique(int[] nums, int k){
    if(nums.length % k != 0){
        return false;
    }

    HashMap<Integer, Integer> map = new HashMap<>();
    int max = 0;
    for(int num: nums){
        map.put(num, map.getOrDefault(num, 0) + 1);
        if(map.get(num) > max){
            max = map.get(num);
        }
    }

    return max <= (nums.length / k);
}
```



# weird faculty

```java
public static int exam(List<Integer> v) {
    int totalSum = 0;
    for(int score: v) {
        if (score == 0) totalSum -= 1;
        else totalSum += 1;
    }

    int currSum = 0;
    for(int i =0; i < v.size(); i++) {
        if (currSum > totalSum) return i;
        currSum += v.get(i) == 0 ? -1 : 1;
        totalSum -= v.get(i) == 0 ? -1 : 1;
    }
    return v.size();
}
```

# university career fair

```java
import java.util.Arrays;

public class maxEvents {

    public static int num_maxEvents (int[] arr, int[]dur) {
        int drop = 0;
        int NumOfEvents = arr.length;
        int [][] intervals = new int[NumOfEvents][2];

        for (int i = 0; i < NumOfEvents; i++) {
            intervals[i] = new int[] {arr[i], arr[i] + dur[i]};
        }

        Arrays.sort(intervals, (a, b) ->(a[1] - b[1]));
        // the finish time of first event;
        int curTime = intervals[0][1];

        for (int i = 1; i < NumOfEvents; i++) {
            int [] toSchedual = intervals[i];
            if (toSchedual[0] < curTime)
                drop++;
            else {
                curTime = toSchedual[1];
            }
        }
        return NumOfEvents - drop;


    }

    public static void main(String[] args) {
        int[] arrival1 = {1,3,3,5,7};
        int[] duration1 = {2,2,1,2,1};
        System.out.println(num_maxEvents(arrival1, duration1));
        int[] arrival2 = {1,3,3,5,7, 6, 9};
        int[] duration2 = {2,2,1,2,1, 10, 2};
        System.out.println(num_maxEvents(arrival2, duration2));
        int[] arrival = {1,3,35,7};
        int[] duration = {2,2,1,2,1};
        System.out.println(num_maxEvents(arrival, duration));
    }
}
```



# Reaching Points

```java
 public static boolean reachingPoints(int sx, int sy, int tx, int ty) {

        while (sx < tx && sy < ty)
            if (tx < ty)
                ty %= tx;
            else
                tx %= ty;

      if(sx == tx && sy <= ty && (ty - sy) % sx == 0)
            return true; 
        
         return sy == ty && sx <= tx && (tx - sx) % sy == 0;
    }
```



# sub-palindrome

```java
int palindrome(string s)

{

    map<string, int> m;

    int n = s.size();


    // table for storing results (2 rows for odd-

    // and even-length palindromes

    int R[2][n+1];


    // Find all sub-string palindromes from the given input

    // string insert 'guards' to iterate easily over s

    s = "@" + s + "#";


    for (int j = 0; j <= 1; j++)

    {

        int rp = 0;   // length of 'palindrome radius'

        R[j][0] = 0;


        int i = 1;

        while (i <= n)

        {

            //  Attempt to expand palindrome centered at i

            while (s[i - rp - 1] == s[i + j + rp])

                rp++;  // Incrementing the length of palindromic

                       // radius as and when we find vaid palindrome


            // Assigning the found palindromic length to odd/even

            // length array

            R[j][i] = rp;

            int k = 1;

            while ((R[j][i - k] != rp - k) && (k < rp))

            {

                R[j][i + k] = min(R[j][i - k],rp - k);

                k++;

            }

            rp = max(rp - k,0);

            i += k;

        }

    }


    // remove 'guards'

    s = s.substr(1, n);


    // Put all obtained palindromes in a hash map to

    // find only distinct palindromess

    m[string(1, s[0])]=1;

    for (int i = 1; i <= n; i++)

    {

        for (int j = 0; j <= 1; j++)

            for (int rp = R[j][i]; rp > 0; rp--)

               m[s.substr(i - rp - 1, 2 * rp + j)]=1;

        m[string(1, s[i])]=1;

    }


    //printing all distinct palindromes from hash map

   cout << "Below are " << m.size()-1

        << " palindrome sub-strings";

   map<string, int>::iterator ii;
int a = 0;
   for (ii = m.begin(); ii!=m.end(); ++ii){
      cout << (*ii).first << endl;
       a ++;
   }
    
    return (a==0)? a:a-1;

}
```



# twitter New Office Design

```java
int tallestHashtag(int[] positions, int[] heights){
	int max = 0;
	for(int i = 1; i < positions.length; i++){
		if(Math.abs(positions[i-1] - positions[i]) > 1){ 
                        max = Math.max(max, getMaxHeight(positions[i-1], positions[i], heights[i-1], heights[i]));
          }
     }
   return max;
}
int getMaxHeight(int t1, int t2, int h1, int h2){
	int shorter = Math.min(h1, h2);
	int taller = Math.max(h1, h2);
	int gap = Math.abs(t2 - t1) - 1;
        if(taller >= shorter + gap){
	      return shorter + gap;
        } else {
	      int top = shorter + gap; 
              int down = taller + 1;
              return (top + down) / 2;  
        }	
}
```



# twitter social network

```java
static Map<Integer, Node> graph = new HashMap<>();
    static class Node {
        int rank;
        Node parent;
        Node() {
            rank = 0;
            parent = this;
        }
    }

    private static Node findParent(Node node) {
        if (node == node.parent) return node;
        node.parent = findParent(node.parent);
        return node.parent;
    }

    private static void union(Node node1, Node node2) {
        Node p1 = findParent(node1);
        Node p2 = findParent(node2);

        if (p1 == p2) return;
        if (p1.rank >= p2.rank) {
            p2.parent = p1;
            p1.rank += 1;
        } else {
            p1.parent = p2;
            p2.rank += 1;
        }
    }

    public static int countGroups(List<String> related) {
        for(int i = 0; i < related.size(); i++) {
            graph.put(i, new Node());
        }

        for(int i = 0; i < related.size(); i++) {
            for(int j = i+1; j < related.size(); j++) {
                if (related.get(i).charAt(j) == '1') {
                    union(graph.get(i), graph.get(j));
                }
            }
        }
        Set<Node> set = new HashSet<>();
        for(int i = 0; i < related.size(); i++) {
            set.add(findParent(graph.get(i)));
        }
        return set.size();
    }
```

# Unique Twitter User Id Set

```java
    public static int UniqueIDSum(int[] nums){
        Arrays.sort(nums);
        int res = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] <= nums[i-1]){
                nums[i] = nums[i-1] + 1;
            }
            res += nums[i];
        }
        return res;
    }
```

