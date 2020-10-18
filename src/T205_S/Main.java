package T205_S;

public class Main {

	public static void main(String[] args) {
		System.out.println(Solution.isIsomorphic2("egg", "add")); //true
		System.out.println(Solution.isIsomorphic2("foo", "bar"));  //false
		System.out.println(Solution.isIsomorphic2("paper", "title")); //true
		System.out.println(Solution.isIsomorphic2("ab", "aa"));  //false
		System.out.println(Solution.isIsomorphic2("ab", "ca"));  //true
		System.out.println(Solution.isIsomorphic2("aab", "aaa"));  //false
	}

}
