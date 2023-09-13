// tc = O(L)
//sc = O(N)

class Trie {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        private TrieNode(){
           // this.isEnd = true;
            this.children = new TrieNode[26];
        }

    }
    
    public TrieNode root;

    public Trie() {
        this.root = new TrieNode();        
    }
    
    public void insert(String word) {
        TrieNode curr = root ;
        for (int i = 0 ; i < word.length() ; i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();      
            }
            curr =  curr.children[c-'a'];
          
        }
        curr.isEnd = true;
        
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0 ; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null) return false;
             curr =  curr.children[c-'a'];
        }
        return curr.isEnd;
        
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0 ; i < prefix.length() ; i++){
            char c = prefix.charAt(i);
            if(curr.children[c-'a'] == null) return false;
             curr =  curr.children[c-'a'];
        }
       return true;
        
    }
}
   