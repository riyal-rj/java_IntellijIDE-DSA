package Trie;

public class Test2 {

	public static void main(String[] args) {
		TrieII tr=new TrieII();
		tr.insert("apple");
		tr.insert("apple");
		tr.insert("apps");
		tr.insert("apps");
		tr.insert("appl");
		
		
		System.out.println("No of word 'appl' present in Trie Data Structure are:  "+tr.countWordEqualsTo("appl"));
		System.out.println("No of word 'apps' present in Trie Data Structure are:  "+tr.countWordEqualsTo("apps"));
		System.out.println("No of word 'apple' present in Trie Data Structure are:  "+tr.countWordEqualsTo("apple"));
//		
//		System.out.println();
//		tr.erase("appl");
//		tr.erase("apps");
//		System.out.println();
//		System.out.println("No of word 'appl' present in Trie Data Structure are:  "+tr.countWordEqualsTo("appl"));
//		System.out.println("No of word 'apps' present in Trie Data Structure are:  "+tr.countWordEqualsTo("apps"));
//		System.out.println("No of word 'apple' present in Trie Data Structure are:  "+tr.countWordEqualsTo("apple"));
//		System.out.println();
//		tr.erase("apps");
//		System.out.println("No of word 'appl' present in Trie Data Structure are:  "+tr.countWordEqualsTo("appl"));
//		System.out.println("No of word 'apps' present in Trie Data Structure are:  "+tr.countWordEqualsTo("apps"));
//		System.out.println("No of word 'apple' present in Trie Data Structure are:  "+tr.countWordEqualsTo("apple"));
//		
		
		System.out.println("No of words starting with 'app' are "+tr.countWordStartingWith("app"));
		System.out.println("No of words starting with 'axp' are "+tr.countWordStartingWith("axp"));

	}

}
