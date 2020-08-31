class StreamChecker {
    
    private class TrieNode{
        Character data;
        HashMap<Character,TrieNode> children = new HashMap<>();
        boolean eow;
    }
    
    TrieNode root = new TrieNode();
    StringBuilder sb = new StringBuilder();

    public StreamChecker(String[] words) {
        root.data='$';
        root.children = new HashMap<>();
        for(String str:words){
            TrieNode node = root;
            for(int i=str.length()-1;i>=0;i--){
                char ch = str.charAt(i);
                if(node.children.containsKey(ch)){
                    node = node.children.get(ch);
                }else{
                    TrieNode newNode = new TrieNode();
                    newNode.data = ch;
                    newNode.children = new HashMap<>();
                    node.children.put(ch,newNode);
                    node = node.children.get(ch);
                }
            }
            node.eow = true;            
        }
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        TrieNode node = root;
        for(int i=sb.length()-1;i>=0&&node!=null;i--){
            char ch = sb.charAt(i);
            if(node.children.containsKey(ch)==false){
                return false;
            }else{
                node = node.children.get(ch);
                if(node.eow==true){
                    return true;
                }
            }
        }
        
        return false;
    }
    
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */