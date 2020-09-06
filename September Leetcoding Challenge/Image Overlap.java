class Solution {
    
    public int largestOverlap(int[][] A, int[][] B) {
        int Xshift = 0 - A.length;
        int Yshift = 0-A.length;
        Xshift+=1;
        Yshift+=1;
        int max = Integer.MIN_VALUE;
        for(int i=Xshift;i<A.length;i++){
            for(int j=Yshift;j<B.length;j++){
                max = Math.max(max,calculateOverLap(A,B,i,j));
            }
        }
        
        return max;
    }
    
    
    
    public int calculateOverLap(int[][] A,int[][] B,int X,int Y){
        int count =0;
            for(int i=0;i<A.length;i++){
                for(int j=0;j<A.length;j++){
                    int idash = i-X;
                    int jdash = j-Y;
                    if(idash<0||idash>=A.length||jdash<0||jdash>=B.length){
                        continue;
                    }
                    if(A[i][j]==B[idash][jdash]&&A[i][j]==1){
                        count++;
                    }
                }
            }
        
        return count;
    }
}