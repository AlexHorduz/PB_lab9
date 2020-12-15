package lab9_PB_Horduz;

public class Task4 {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++)
			try {
				String hex = generateRandomHexNum(i+2);
				System.out.print(hex + "   ");
				System.out.println(convertNumFrom16to10(hex));
			} catch (Exception e) {
				System.out.println(e.getMessage() + '\n');
			}
		
		try {
			System.out.println(convertNumFrom16to10("DW4F5f"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println(convertNumFrom16to10(null));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static long convertNumFrom16to10(String s) {
		if (s == null)
			throw new NullPointerException("NULL passed as a parameter");
		long dec_num = 0;
		for (int i=0; i < s.length(); i++)
			dec_num += convertCharFrom16to10(s.charAt(i))*(int)Math.pow(16, s.length() - i - 1);
		return dec_num;
	}
	
	private static int convertCharFrom16to10(char c) {
		int ascii_code = (int)c;
		if (ascii_code >= 48 && ascii_code <= 57)
			return (ascii_code - 48);
		if (ascii_code >= 65 && ascii_code <= 70)
			return ascii_code - 55;
		throw new IllegalArgumentException("It isn't a hex number");
	}
	
	private static String generateRandomHexNum(int size) {
		final char alphabet[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		String s = "" + alphabet[(int)(Math.random()*15) + 1];
		while((size--) > 0) {
			s += alphabet[(int)(Math.random()*16)];
		}
		return s;
	}
}
