class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] arr= str.split(" ");
        HashSet<String> hset = new HashSet<>();
        HashMap<Character, String> map = new HashMap<Character, String>();
        if(arr.length!= pattern.length())
            return false;
        for(int i=0; i<arr.length; i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                if(!map.get(c).equals(arr[i]))
                    return false;
            }else{
                if(hset.contains(arr[i]))
                    return false;
                map.put(c, arr[i]);
                hset.add(arr[i]);
            }    
        }
        return true;
    }
}