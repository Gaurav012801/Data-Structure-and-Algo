class Solution {
    public String longestPrefix(String s) {
       int ans=longestCommonPrefixSuffix(s);
       return s.substring(0,ans);
    }
    private int longestCommonPrefixSuffix(String s){
        //create an array of size n as lps
        int[] lps=new int[s.length()];
        int prefix=0;
        int suffix=1;
        while(suffix<s.length()){
            //check if prefix and suffix char match
            if(s.charAt(prefix)==s.charAt(suffix)){
                lps[suffix]=prefix+1;
                prefix++;
                suffix++;
            }else{
                //If prefix at Zeroth index
                if(prefix==0){
                    lps[suffix]=0;
                    suffix++;
                }else{
                    prefix=lps[prefix-1];
                }
            }
        }
        return lps[s.length()-1];

    }
}