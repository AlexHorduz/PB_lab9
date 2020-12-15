package lab9_PB_Horduz;

public class Task10 {
	public static void main(String[] args) {
		try {
			System.out.println(changeWordsToUpperCase("The user with the nickname koala757677 this "
								+ "month wrote 3 times more comments than the user with the nickname "
								+ "croco181dile920 4 months ago"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println(changeWordsToUpperCase(""));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println(changeWordsToUpperCase(null));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println(changeWordsToUpperCase("Works better, h0h"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static String changeWordsToUpperCase(String s) {
		if (s == null)
			throw new NullPointerException("NULL passed as a parameter");
		String modified_string = "";
		
		int whitespace_ind = -1;
		boolean isWord = true;
		
		for (int i = 0; i < s.length(); i++) {
			int ascii_code = (int)s.charAt(i);
			if (ascii_code >= 48 && ascii_code <= 57)
				isWord = false;
			else if (ascii_code == 32) {
				if (isWord)
					modified_string += s.substring(whitespace_ind + 1, i + 1).toUpperCase();
				else
					modified_string += s.substring(whitespace_ind + 1, i + 1);
				whitespace_ind = i;
				isWord = true;
			}
			else if (!(ascii_code >= 65 && ascii_code <= 90 || ascii_code >= 97 && ascii_code <= 122)) {
				throw new IllegalArgumentException("Text should only contain letters and numbers");
			}
		}
		if (isWord)
			modified_string += s.substring(whitespace_ind + 1, s.length()).toUpperCase();
		else
			modified_string += s.substring(whitespace_ind + 1, s.length());
		return modified_string;
	}
}
