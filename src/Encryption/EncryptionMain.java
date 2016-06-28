package Encryption;

public class EncryptionMain {

	public static String firstString(String password) {
		// String password = "Jonpaul";
		String passwordL = password.toLowerCase();
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String pP = passwordL + alphabet; // password plus

		for (int i = 0; i < password.length() + 1; i++) {
			char a = pP.charAt(i);
			// System.out.println(pP);
			int first = pP.indexOf(a); // first time a letter appears
			int second = pP.lastIndexOf(a); // second time if it appears
			if (!(first == second)) {
				pP = pP.substring(0, second) + pP.substring(second + 1);
			} // remove the second instance
		}
		return pP;
	}

	public static String createInputCode(String pP) {
		String firstHalf = pP.substring(0, 13);
		String secondHalf = pP.substring(13, 26);
		// initially splitting up the string in halves

		// System.out.println(firstHalf);
		// System.out.println(secondHalf);

		String inputCode = firstHalf + secondHalf + " .,!?'"; // added symbols
		return inputCode; // creating the first string each input letter is
							// compared with
	}

	public static String createOutputCode(String pP) {
		String firstHalf = pP.substring(0, 13);
		String secondHalf = pP.substring(13, 26);
		String outputCode = " .,!?'" + secondHalf + firstHalf;
		return outputCode; // this is the list of letters that will come out by
							// index
	}

	public static String createInputCodeD(String pP) {
		String firstHalf = pP.substring(0, 13);
		String secondHalf = pP.substring(13, 26);
		String inputCode = " .,!?'" + secondHalf + firstHalf;
		return inputCode; // this is the same for Decrypting
	}

	public static String createOutputCodeD(String pP) {
		String firstHalf = pP.substring(0, 13);
		String secondHalf = pP.substring(13, 26);
		String outputCode = firstHalf + secondHalf + " .,!?'";
		return outputCode; // this is the same for Decrypting
	}
	// This is the "main" method so to speak

	// public static String clean (String tobeEncryFirst){
	// for (int i = 0; i < password.length() + 1; i++) {
	// char a = tobeEncryFirst.charAt(i);
	// if (a == "\r" ){
	// This was an attempt to remove carrage returns from incoming text
	// }
	// return clean;
	// }
	public static String encrypt(String tobeEncry, String inputCode, String outputCode) {
		String tobeEncry2 = tobeEncry.toLowerCase();

		String encrypted = "";

		for (int i = 0; i < tobeEncry.length(); i++) {
			char letter = tobeEncry2.charAt(i); // look at each letter
			int index = inputCode.indexOf(letter); // and record the index
			char out = outputCode.charAt(index); // and put out the
													// corresponding code
			encrypted = encrypted + out; // add each letter after the first
		}
		return encrypted;
	}

	public static void main(String[] args) { // everything below was for testing
												// before Swing
		// TODO Auto-generated method stub
		String password = "Jonpaul";
		String pP = firstString(password); // use password plus alphabet

		String inputCode = createInputCode(pP);
		String outputCode = createOutputCode(pP);

		System.out.println(inputCode + "\r" + outputCode);

		String tobeEncry = "I wonder if this will work jack? Dude, I don't know.";

		String encrypted = encrypt(tobeEncry, inputCode, outputCode);

		System.out.println(tobeEncry);
		System.out.println(encrypted);

		// String decrypted = decrypt(tobeEncry, inputCode, outputCode);
	}

}
