class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        getAllPermutation(nums, 0, ans);
        return ans;
    }

    private void getAllPermutation(
        int[] arr,
        int index,
        List<List<Integer>> ans
    ) {
        if (index == arr.length) {
            List<Integer> tmp = new ArrayList<>();

            for (int i : arr) {
                tmp.add(i);
            }

            ans.add(tmp);
            return;
        }

        Set<Integer> used = new HashSet<>();

        for (int i = index; i < arr.length; i++) {

            // Skip duplicate choices at this level
            if (used.contains(arr[i])) {
                continue;
            }

            used.add(arr[i]);

            swap(index, i, arr);

            getAllPermutation(arr, index + 1, ans);

            // Backtracking
            swap(index, i, arr);
        }
    }

    private void swap(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}