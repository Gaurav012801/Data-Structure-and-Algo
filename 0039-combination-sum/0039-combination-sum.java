class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> tmp=new ArrayList<>();
        solve(candidates,0,target,tmp,ans);
        return ans;
    }

    private void solve(int[] arr,int index,int target,List<Integer> tmp,List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        if(index==arr.length){
            return;
        }
        //Do not take
        solve(arr,index+1,target,tmp,ans);
        //Take
        if(arr[index]<=target){
            tmp.add(arr[index]);
            solve(arr,index,target-arr[index],tmp,ans);
            //Backtracking
            tmp.remove(tmp.size()-1);
        }
    }
}