public class Hashing {
	public static String[] stringinput;
	public static int collisionfrequency = 0;
	static double load_fac = 0.5;
	public static int tableindex;
	public int extent = 31;

	public Hashing() {
		stringinput = new String[extent];
	}
	
	public static void main(String[] args) {
		Hashing ht = new Hashing();
		String[] input = { "cufh45", "c44", "cd d5", "cddef6", "cdfu7", "cfcu", "ucf", "bhargav","abcde", "abc", "abce", 
				"abce2", "buet", "cd3", "fien678", "teaa5", "yyz45","abcdefg", "abcdefg", "abcdef",  "abcdefgoi" };
		for (int i = 0; i < input.length; i++) {
			ht.addval(input[i]);
		}
		for (int j = 0; j < stringinput.length; j++) {
			if (stringinput[j] != null)
				System.out.println("Located at index" + " " + j + "-" + stringinput[j] + " ");
		}
		System.out.println("number of collisions that occur: " + collisionfrequency);
	}

	public int hash_func(String input, int val) {
		int hashval = 0;
		for (int j = 0; j < input.length(); j++)
			hashval += input.charAt(j);
		return (hashval + (val * val)) % extent;
	}
	
	public void tablerehash() {
		int oldextent = extent;
		extent = tableindexPrimeval(oldextent * 2);
		String[] reference = stringinput;
		stringinput = new String[extent];
		tableindex = 0;
		for (int i = 0; i < oldextent; i++) {
			String hash = reference[i];
			if (hash != null) {
				addval(hash);
			}
		}
	}
	public static boolean isnumberPrime(int val) {
		if (val == 2 || val == 3)
			return true;

		if (val == 1 || val % 2 == 0)
			return false;

		for (int n = 3; n * n <= val; n += 2)
			if (val % n == 0)
				return false;

		return true;
	}
	
	public void addval(String s1) {
		boolean empty = false;
		if (tableindex > load_fac * extent)
			tablerehash();

		for (int m = 0; m < stringinput.length; m++) {
			if (stringinput[m] != null) {
				if (stringinput[m].equalsIgnoreCase(s1)) {
					empty = true;
					break;
				}
			}
		}
		if (!empty) {
			int v = 0;
			while (true) {
				int i = hash_func(s1, v);
				if (stringinput[i] == null) {
					stringinput[i] = s1;
					tableindex++;
					return;
				} else {
					collisionfrequency += 1;
					v += 1;
				}
			}
		}
	}


	public static int tableindexPrimeval(int num) {
		if (num <= 0)
			num = 3;
		if (num % 2 == 0)
			num++;
		for (; !isnumberPrime(num); num += 2)
			;
		return num;
	}

}


