class Solution {
    public boolean canReach(int[] start, int[] target) {
        //If (x+y)->even then at black else at white
        //If knight at black and target box is also black then it is possible to read in even step same for white as well
        //But if knight and black and target is white then not possible in even number of step;
        String source="";
        String end="";
        if((start[0]+start[1])%2==0){
            source="black";
        }else{
            source="white";
        }
        if((target[0]+target[1])%2==0){
            end="black";
        }else{
            end="white";
        }
        if(source.equals(end)){
            return true;
        }
        return false;
    }
}