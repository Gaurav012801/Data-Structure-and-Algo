class Solution {

    Map<Integer, Integer> map = new HashMap<>();

    // Points to the current root in postorder
    int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        // Store inorder value -> index
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        // Start from the LAST element of postorder
        postIndex = postorder.length - 1;

        return build(postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int left, int right) {

        // No elements in this inorder range
        if (left > right) {
            return null;
        }

        // Take root from the end of postorder
        int rootValue = postorder[postIndex--];

        TreeNode root = new TreeNode(rootValue);

        // Find root in inorder
        int mid = map.get(rootValue);

        /*
            IMPORTANT:

            Postorder = Left -> Right -> Root

            We are going backwards:

            Root -> Right -> Left

            Therefore build RIGHT first.
        */
        root.right = build(postorder, mid + 1, right);

        root.left = build(postorder, left, mid - 1);

        return root;
    }
}