public class Mock {
    public boolean verifyPostorder(int[] postorder) {
        return helper(postorder, 0, postorder.length - 1);
    }

    public boolean helper(int[] postorder, int l, int r) {
        if (r - l <= 0) return true;
        int val = postorder[r];
        int leftr = r - 1;
        while (leftr >= 0 && postorder[leftr] > val) {
            leftr--;
        }
        for (int i = leftr; i >= 0; i--) {
            if (postorder[i] > val) return false;
        }
        return helper(postorder, l, leftr) && helper(postorder, leftr + 1, r - 1);
    }

//    public boolean verifyPostorder(int[] postorder) {
//        return recur(postorder, 0, postorder.length - 1);
//    }
//    boolean recur(int[] postorder, int i, int j) {
//        if(i >= j) return true;
//        int p = i;
//        while(postorder[p] < postorder[j]) p++;
//        int m = p;
//        while(postorder[p] > postorder[j]) p++;
//        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
//    }
}
