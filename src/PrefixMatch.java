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
			System.out.println("inserted char: " + ch);
			temp = children.get(ch);
		}
		temp.setIsEnd(true);
	}
	public int findPrefix(String str){
		int prefixLength= 0;
		int matchLength = 0;
		TrieNode temp = root;
		for(int i =0; i< str.length(); i ++){
			
			HashMap<Character, TrieNode> children = temp.getChildren();
			
			char ch = new Character(str.charAt(i));
			if(children.containsKey(ch)){
				System.out.println("Found char: " + ch);
				temp = children.get(ch);
				
				if(temp.isEnd()){
					prefixLength = i + 1;
				}
				
				matchLength =  i + 1;
			}
			else
				break;
		}
		return matchLength > (0.5 * str.length()) ? matchLength : 0;
	}
	
}
public class PrefixMatch {
	public static void main(String args[]){
		
		Trie tamizhDict = new Trie();
		
		tamizhDict.insert("இயக்கர்வேந்தன்");
 
        String input = "இயக்கன்";
        System.out.print(input + ":   ");
        System.out.println("Match Length: " + tamizhDict.findPrefix(input));
        System.out.println(input.substring(0, tamizhDict.findPrefix(input)));    
		
	}
}
