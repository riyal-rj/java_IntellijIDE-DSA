package Trie;

public class TrieII {

	
	private TrieNode root;
	public TrieII() {
		root=new TrieNode(); 
	}
	
	void insert(String word)
	{
		TrieNode node=root;
		for(int i=0;i<word.length();i++)
		{
			if(!node.containsKey(word.charAt(i)))
				node.putKey(word.charAt(i), new TrieNode());
			node=node.getKey(word.charAt(i));
			node.increasePrefix();
		}
		node.increaseEnd();
	}
	
	
	int countWordEqualsTo(String word)
	{
		TrieNode node=root;
		for(int i=0;i<word.length();i++)
		{
			if(node.containsKey(word.charAt(i)))
				node=node.getKey(word.charAt(i));
			else 
				return 0;
		}
		return node.countEndsWith;
	}
	
	
	int countWordStartingWith(String prefix)
	{
		TrieNode node=root;
		for(int i=0;i<prefix.length();i++)
		{
			if(node.containsKey(prefix.charAt(i)))
				node=node.getKey(prefix.charAt(i));
			else
				return 0;
		}
		return node.countPrefix;
	}
	
	
	
	void erase(String word)
	{
		TrieNode node=root;
		for(int i=0;i<word.length();i++)
		{
			if(node.containsKey(word.charAt(i)))
			{
				node=node.getKey(word.charAt(i));
				node.decreasePrefix();
			}
			else
				return; 
		}
		node.decreaseEnd();
	}
	
	class TrieNode
	{
		TrieNode []child;
		int countEndsWith;
		int countPrefix;
		public TrieNode() {
			child=new TrieNode[26];
			countEndsWith=0;
			countPrefix=0;
		}
		
		
		boolean containsKey(char ch)
		{
			return child[ch-'a']!=null;
		}
		
		
		TrieNode getKey(char ch)
		{
			return child[ch-'a'];
		}
		
		
		void putKey(char ch,TrieNode node)
		{
			child[ch-'a']=node;
		}
		
		
		void increaseEnd()
		{
			countEndsWith++;
		}
		
		void increasePrefix()
		{
			countPrefix++;
		}
		
		
		void decreaseEnd()
		{
			countEndsWith--;
		}
		
		
		void decreasePrefix()
		{
			countPrefix--;
		}
		
		
		
	}
	
}
