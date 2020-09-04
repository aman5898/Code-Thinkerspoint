class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for(int len=s.length()/2;len>0;len--){
            if(s.length()%len==0){
                String pattern = s.substring(0,len);
                int i = len;
                int j=len+i-1;
                while(j<s.length()){
                    String substring = s.substring(i,j+1);
                    if(pattern.equals(substring)==false){
                        break;
                    }
                    i+=len;
                    j+=len;                    
                }
                
                if(i==s.length()){
                    return true;
                }
            }
            
        }
        return false;
    }
}
