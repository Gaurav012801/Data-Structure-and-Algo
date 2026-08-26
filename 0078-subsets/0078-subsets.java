class Solution {

    public void allsubset(
        int[] arr,
        int index,
        int n,
        List<Integer> tmp,
        List<List<Integer>> ans
    ) {

        if (index == n) {
            ans.add(new ArrayList<>(tmp));
            return;
        }

        // Don't take arr[index]
        allsubset(arr, index + 1, n, tmp, ans);

        // Take arr[index]
        tmp.add(arr[index]);

        allsubset(arr, index + 1, n, tmp, ans);

        // Backtrack
        tmp.remove(tmp.size() - 1);
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();

        allsubset(nums, 0, nums.length, tmp, ans);

        return ans;
    }
}