/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //Use HashMap to store value and index of inorder
    Map<Integer,Integer> map=new HashMap<>();
    //keep variable to track current index of pre-order
    int preorderIndex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //Put values of inorder into map
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root=build(preorder,0,inorder.length);
        return root;
    }
    private TreeNode build(int[] preorder,int left,int right){
        if(left>right){
            //No element in the preorder array
            return null;
        }
        // Safety check for preorder index
        if (preorderIndex >= preorder.length) {
            return null;
        }
        //Get the current root value as preorder store N-L-R
        int rootValue=preorder[preorderIndex++];
        TreeNode root=new TreeNode(rootValue);
        //get the index of rootValue in inorder
        int mid=map.get(rootValue);
        //Build left subtree
        root.left=build(preorder,left,mid-1);
        //build right subtree
        root.right=build(preorder,mid+1,right);
        //return root element
        return root;

    }
}