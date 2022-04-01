class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.add(num);
            }
            else if (minHeap.peek() < num) {
                minHeap.poll();
                minHeap.add(num);
            }
        }
        return minHeap.peek();

    }
}

class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        int partition = partition(nums, left, right);
        if (partition == k) return nums[partition];
        else if (partition < k) return quickSelect(nums, partition + 1, right, k);
        else return quickSelect(nums, left, partition - 1, k);
    }

    private int partition(int[] nums, int left, int right) {
        int random = new Random().nextInt(right - left + 1) + left;
        int pivot = nums[random];
        swap(nums, random, right);
        int i = left;
        for (int j = left; j < right; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);
        return i;

    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}