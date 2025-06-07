package Trie;

public class TrieIII {
	
	TrieNode root;
	public TrieIII() {
		root=new TrieNode();
	}
	
	
	void insert(String word)
	{
		TrieNode node=root;
		for(int i=0;i<word.length();i++)
		{
			if(!node.containsKey(word.charAt(i)))
				node.putKey(word.charAt(i),  new TrieNode());
			
			node=node.getKey(word.charAt(i));
		}
		
		node.wordEnd=true;
	}
	
	boolean checkifPrefixExists(String word)
	{
		TrieNode node=root;
		boolean flag=true;
		
		for(int i=0;i<word.length()  && flag;i++)
		{
			if(node.containsKey(word.charAt(i))) {
				node=node.getKey(word.charAt(i));
				flag=flag & node.wordEnd;
			}
			else
				return false;				
		}
		return flag;
	}
	
	
	String completeString(int n,String[] str)
	{
		
		TrieIII tr=new TrieIII();
		for(int i=0;i<str.length;i++)
			tr.insert(str[i]);
		
		
		String longest="";
		
		for(int i=0;i<n;i++)
		{
			if(tr.checkifPrefixExists(str[i]))
			{
				if(str[i].length()>longest.length())
					longest=str[i];
				else if(str[i].length()==longest.length())
					longest=str[i];
					
			}
		}
		if(longest=="")
			return "None";
		return longest;
		
	}
	
	
	
	
	
	
	
	
	
	
	private class TrieNode
	{
		TrieNode []child;
		boolean wordEnd=false;
		public TrieNode() {
			child=new TrieNode[26];
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
	}
}
