class Solution {
    private void getAllSubsets(int[] arr,int index,int n,List<Integer> tmp,List<List<Integer>> ans){
        //Base condition
        if(index==n){
            ans.add(new ArrayList<>(tmp));
            return;
        }

        //Don't take it
        getAllSubsets(arr,index+1,n,tmp,ans);
        //Take it
        tmp.add(arr[index]);
        getAllSubsets(arr,index+1,n,tmp,ans);
        //BackTracking
        tmp.remove(tmp.size()-1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> tmp=new ArrayList<>();
        getAllSubsets(nums,0,nums.length,tmp,ans);
        return ans;
    }
}