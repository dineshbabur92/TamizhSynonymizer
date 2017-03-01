import java.util.HashMap;

class TrieNode{
	private char ch;
	private HashMap<Character, TrieNode> hm;
	private boolean isEnd;
	
	public TrieNode(char value){
		ch = value;
		hm = new HashMap<Character, TrieNode>();
		isEnd = false;
	}
	public char getValue(){
		return ch;
	}
	public HashMap<Character, TrieNode> getChildren(){
		return hm;
	}
	public void setIsEnd(boolean value){
		isEnd = value;
	}
	public boolean isEnd(){
		return isEnd;
	}
}

class Trie{
	private TrieNode root;
	
	public Trie(){
		root = new TrieNode(new Character('0'));
		
	}
	public void insert(String str){
		TrieNode temp = root;
		for(int i = 0; i < str.length(); i ++){
			HashMap<Character, TrieNode> children = temp.getChildren();
			
			char ch = str.charAt(i);
			
			if(!children.containsKey(ch)){
				children.put(ch, new TrieNode(ch));
			}
			temp = children.get(ch);
		}
		temp.setIsEnd(true);
	}
	public int findPrefix(String str){
		int prefixLength= 0;
		TrieNode temp = root;
		for(int i =0; i< str.length(); i ++){
			
			HashMap<Character, TrieNode> children = temp.getChildren();
			
			char ch = new Character(str.charAt(i));
			if(children.containsKey(ch)){
				temp = children.get(ch);
				if(temp.isEnd()){
					prefixLength = i + 1;
				}
			}
			else
				break;
		}
		return prefixLength;
	}
	
}
public class PrefixMatch {
	public static void main(String args[]){
		
		Trie tamizhDict = new Trie();
		
		tamizhDict.insert("are");
		tamizhDict.insert("area");
		tamizhDict.insert("base");
		tamizhDict.insert("cat");
		tamizhDict.insert("cater");
		tamizhDict.insert("basement");
 
        String input = "caterer";
        System.out.print(input + ":   ");
        System.out.println(input.substring(0, tamizhDict.findPrefix(input)));              
 
        input = "basement";
        System.out.print(input + ":   ");
        System.out.println(input.substring(0, tamizhDict.findPrefix(input)));                      
 
        input = "are";
        System.out.print(input + ":   ");
        System.out.println(input.substring(0, tamizhDict.findPrefix(input)));              
 
        input = "arex";
        System.out.print(input + ":   ");
        System.out.println(input.substring(0, tamizhDict.findPrefix(input)));              
 
        input = "basemexz";
        System.out.print(input + ":   ");
        System.out.println(input.substring(0, tamizhDict.findPrefix(input)));                      
 
        input = "xyz";
        System.out.print(input + ":   ");
        System.out.println(input.substring(0, tamizhDict.findPrefix(input)));
		
	}
}
