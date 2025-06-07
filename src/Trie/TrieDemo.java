package Trie;

public class TrieDemo {
    TrieNode root;
    TrieDemo()
    {
        root=new TrieNode();
    }
    void insertWord(String word)
    {
        TrieNode node=root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i)))
                node.putKey(word.charAt(i),new TrieNode());
            node=node.getKey(word.charAt(i));//moves to the reference trienode
        }

        node.wordEndFlag=true;
    }

    boolean searchWord(String word)
    {
        TrieNode node=root;
        for(int i=0;i<word.length();i++)
        {
            if(!node.containsKey(word.charAt(i)))
                return false;
            node=node.getKey(word.charAt(i));
        }
        return node.wordEndFlag;
    }

    boolean startsWith(String prefix)
    {
        TrieNode node=root;
        for(int i=0;i<prefix.length();i++)
        {
            if(!node.containsKey(prefix.charAt(i)))
                return false;
            node=node.getKey(prefix.charAt(i));
        }

        return true;
    }


}
class TrieNode
{
    TrieNode []child;
    boolean wordEndFlag=false;
        TrieNode()
        {
            child=new TrieNode[26];
        }

    boolean containsKey(char ch)
    {
        return child[ch-'a']!=null;
    }

    void putKey(char ch,TrieNode node)
    {
        child[ch-'a']=node;
    }

    TrieNode getKey(char ch)
    {
        return child[ch-'a'];
    }

}

