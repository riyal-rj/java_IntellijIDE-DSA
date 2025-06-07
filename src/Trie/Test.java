package Trie;

public class Test
{
    public static void main(String[] args) {
        TrieDemo trd=new TrieDemo();
        System.out.println("Insert the words:   \n 1) apple \n 2) apps \n 3) apxl \n 4) bac \n 5) bat \n");
        trd.insertWord("apple");
        trd.insertWord("apps");
        trd.insertWord("apxl");
        trd.insertWord("bac");
        trd.insertWord("bat");

        System.out.println("Searching the word 'apps' in the Trie Data Structure ..... "+trd.searchWord("apps"));
        System.out.println("Searching the word 'appl' in the Trie Data Structure ..... "+trd.searchWord("appl"));
        System.out.println();
        System.out.println("Searching any  word  starts with 'ba' in the Trie Data Structure ..... "+trd.startsWith("ba"));
        System.out.println("Searching any word starts with 'apd' in the Trie Data Structure ..... "+trd.startsWith("apd"));

    }
}