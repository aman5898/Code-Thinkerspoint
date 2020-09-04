class Solution {
    public List<Integer> partitionLabels(String S) {
        Integer[] end = new Integer[26];
        
        for(int i=0;i<S.length();i++){
            char ch = S.charAt(i);
            int arrPos = ch-'a';
            end[arrPos] = i;
        }
        
        List<Integer> ans = new ArrayList<Integer>();
        int currParLen = 0;
        int currMaxEnd = Integer.MIN_VALUE;
        
        for(int i=0;i<S.length();i++){
            
            if(i>currMaxEnd){
                
                if(i!=0){
                    ans.add(currParLen);
                    currParLen = 0;
                }
            }
            
            char ch = S.charAt(i);
            int arrPos = ch-'a';
            if(end[arrPos]>currMaxEnd){
                currMaxEnd = end[arrPos];
            }
            
            currParLen++;
        }
        ans.add(currParLen);
        
        return ans;
    }
}