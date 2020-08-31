class Solution {
    
    private class DSU{
        
        int[] parent;
        int[] rank;
        
        public DSU(int n){
            parent = new int[n];
            rank = new int[n];
            
            for(int i=0;i<parent.length;i++){
                parent[i] = i;
                rank[i] = 0;
            }
        }
        
        public int findSet(int v){
            if(parent[v]==v){
                return v;
            }
            
            return parent[v] = findSet(parent[v]);
        }
        
        public void unionSet(int u,int v){
            
            u = findSet(u);
            v = findSet(v);
            
            if(u == v){
                return;
            }
            
            if(rank[u]<rank[v]){
                parent[u] = v;
            }else{
                parent[v] = u;
            }
            
            if(rank[u] ==rank[v]){
                rank[u]++;
            }
        }
    }
    
    public int largestComponentSize(int[] A) {
        
//      1. Find Largest Element in array and Initialise DSU with it
       
        int maxElem = Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++){
            maxElem = Math.max(maxElem,A[i]);
        }
        
        DSU dsu = new DSU(maxElem+1);
        
//      2. Create unionSet of all the elements with its factors except 1   
        for(int val:A){
            for(int i =2;i<=Math.sqrt(val);i++){
                if(val%i==0){
                    dsu.unionSet(i,val);
                    dsu.unionSet(val,val/i);
                }
            }
        }
       
        
//      3. Store in HashMap all the SetLeaders with their Time of Occurence
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int val:A){
            int parentVal = dsu.findSet(val);
            hmap.put(parentVal,hmap.getOrDefault(parentVal,0)+1);
        }
       
        
        
//      4. Find the largest number of times any leader occured 
        int max = Integer.MIN_VALUE;
        for(int val:A){
            int parentVal = dsu.findSet(val);
            max = Math.max(max,hmap.get(parentVal));
        }
        
        return max;
       
    }
}