package Trie;

public class Test3 {
	public static void main(String[] args) {
		TrieIII tr=new TrieIII();
		tr.insert("ninja");
		int n = 6;
		String []a = {"n", "ni", "nin", "ninj", "ninja", "ninga"};
		System.out.println(tr.completeString(n, a))	;
	}
}
