import java.util.regex.Pattern;

public class Barcode implements Comparable<Barcode> {
	private String zip;
	private int check;
	private String barcode;

	public static void main(String[] args) {
		Barcode test = new Barcode("12314");
		System.out.println(test.toString());
		System.out.println(toCode(test.zip));
		System.out.println(toZip(toCode(test.zip)));

	}

	public Barcode(String z) {
		try {
			// int temp = Integer.parseInt(z);
			// if it cant be parseInted into an interger than it has a letter
			if (z.length() != 5 || Pattern.matches("[a-zA-Z]+", z)) {
				throw new IllegalArgumentException("Illegal Argument");
			}
			// if anything in the string matches any letters then throw new
			// exception
		} catch (Exception e) {
			throw new IllegalArgumentException("Illegal Argument");
		}
		zip = z;
		check = checkSum() % 10;
	}

	private static int checkSum() {
		int sum = 0;
		for (int i = 0; i < zip.length(); i++) {
			sum = sum + Integer.parseInt(zip.charAt(i) + "");
		}
		return sum;
	}

	public String toString() {
		return (zip + check + " " + toCode(zip));
	}

	private static String toCode(String z) {
		String finalCode;
		finalCode = toCode1(z) + toCode2(z);
		finalCode += "|";
		return finalCode;
	}

	private static String toCode2(String z) {
		String result = "";
		switch (check) {
		case 1:
			result = ":::||";
			break;
		case 2:
			result = "::|:|";
			break;
		case 3:
			result = "::||:";
			break;
		case 4:
			result = ":|::|";
			break;
		case 5:
			result = ":|:|:";
			break;
		case 6:
			result = ":||::";
			break;
		case 7:
			result = "|:::|";
			break;
		case 8:
			result = "|::|:";
			break;
		case 9:
			result = "|:|::";
			break;
		case 0:
			result = "||:::";
			break;
		}
		return result;
	}

	private static String toCode1(String z) {
		String result = "|";
		if (z.length() != 5) {
			throw new IllegalArgumentException("Illegal Argument");
		}
		if (z.length() != 5 || Pattern.matches("[a-zA-Z]+", z)) {
			throw new IllegalArgumentException("Illegal Argument");
		}
		for (int i = 0; i < zip.length(); i++) {
			switch (Integer.parseInt(zip.charAt(i) + "")) {
			case 1:
				result = result + ":::||";
				break;
			case 2:
				result = result + "::|:|";
				break;
			case 3:
				result = result + "::||:";
				break;
			case 4:
				result = result + ":|::|";
				break;
			case 5:
				result = result + ":|:|:";
				break;
			case 6:
				result = result + ":||::";
				break;
			case 7:
				result = result + "|:::|";
				break;
			case 8:
				result = result + "|::|:";
				break;
			case 9:
				result = result + "|:|::";
				break;
			case 0:
				result = result + "||:::";
				break;
			}
		}
		return result;
	}

	private static String toZip(String barcode) {
		String result = "";
		for (int i = 0; i < barcode.length() - 1; i++) {
			if (!barcode.substring(i, i + 1).equals("|") && !barcode.substring(i, i + 1).equals(":")) {
				throw new IllegalArgumentException("Illegal Argument 1");
			}
		}
		if (barcode.length() != 32) {
			throw new IllegalArgumentException("Illegal Argument 2");
		}
		if (!barcode.substring(0, 1).equals("|")) {
			throw new IllegalArgumentException("Illegal Argument 3");
		}
		if (!barcode.substring(31).equals("|")) {
			throw new IllegalArgumentException("Illegal Argument 4");
		}
		for (int i = 0; i < 6; i++) {
			switch (barcode.substring(i * 5 + 1, i * 5 + 6)) {
			case ":::||":
				result = result + 1;
				break;
			case "::|:|":
				result = result + 2;
				break;
			case "::||:":
				result = result + 3;
				break;
			case ":|::|":
				result = result + 4;
				break;
			case ":|:|:":
				result = result + 5;
				break;
			case ":||::":
				result = result + 6;
				break;
			case "|:::|":
				result = result + 7;
				break;
			case "|::|:":
				result = result + 8;
				break;
			case "|:|::":
				result = result + 9;
				break;
			case "||:::":
				result = result + 0;
				break;
			default:
				throw new IllegalArgumentException("Illegal Argument");
			}
		}
		int CHECK = 0;
		for (int i = 0; i < result.length() - 1; i++) {
			CHECK += Integer.parseInt(result.charAt(i) + "");
		}
		if (CHECK % 10 != Integer.parseInt(result.substring(5))) {
			throw new IllegalArgumentException("Illegal Argument");
		}
		return result.substring(0, 5);
	}

	public int compareTo(Barcode other) {
		if (Integer.parseInt(zip) > Integer.parseInt(other.zip)) {
			return 1;
		} else {
			if (Integer.parseInt(zip) < Integer.parseInt(other.zip)) {
				return -1;
			} else {
				return 0;
			}
		}

	}
}