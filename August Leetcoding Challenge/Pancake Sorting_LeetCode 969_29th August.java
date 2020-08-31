class Solution {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> ans = new ArrayList<Integer>();
        for(int i = A.length;i>0;i--){
            int idx = findIdx(A,i);
            
            if(i-1==idx){
                continue;
            }
            
            if(idx!=0){
                flip(A,idx);
                ans.add(idx+1);
            }
            
            flip(A,i-1);
            ans.add(i);
        }
        
        return ans;
    }
    
    public void flip(int[] arr,int idx){
        int lo=0;
        int hi=idx;
        while(lo<hi){
            int temp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = temp;
            
            lo++;
            hi--;
        }
        
        return;
    }
    
    public int findIdx(int[] A,int target){
        for(int i=0;i<A.length;i++){
            if(A[i]==target){
                return i;
            }
        }
        
        return -1;
    }
}