import java.util.*;
import java.io.*;

class Solution {
    static class Node{
        HashMap<Character, Node> child = new HashMap<>();
        int count = 0;
    }
    
    static class Trie{
        Node root = new Node();
        
        public void insert(String s){
            Node before = this.root;
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                before.child.putIfAbsent(c, new Node());
                before = before.child.get(c);
                before.count++;
            }
        }
        
        public int find(String s){
            Node now = this.root;
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                now = now.child.get(c);
                if(now.count == 1){
                    return i + 1;
                }
            }
            
            return s.length();
        }
        
    }
    static HashMap<String, Integer> map = new HashMap<>();
    
    public int solution(String[] words) {
        Trie trie = new Trie();
        for(String s : words){
            trie.insert(s);
        }
        
        int ans = 0;
        for(String s : words){
            ans += trie.find(s);
        }
        
        return ans;
    }
    
}