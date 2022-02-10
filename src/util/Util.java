package util;


public class Util {
	public static int readInt() {
		byte[] bytes = new byte[160];
		try {
			System.in.read(bytes);
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
		char[] caracts = new char[160];
		for (int i = 0; i < 160; i++)
			caracts[i] = (char) bytes[i];
		String str = new String(caracts);
		return (Integer.parseInt(str.trim()));
	}

	public static double readDbl() {
		byte[] bytes = new byte[160];
		try {
			System.in.read(bytes);
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
		char[] caracts = new char[160];
		for (int i = 0; i < 160; i++)
			caracts[i] = (char) bytes[i];
		String str = new String(caracts);
		return (Double.valueOf(str.trim())).doubleValue();
	}

	public static String readStr() {
		byte[] bytes = new byte[160];
		try {
			System.in.read(bytes);
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
		char[] caracts = new char[160];
		for (int i = 0; i < 160; i++)
			caracts[i] = (char) bytes[i];
		String str = (new String(caracts)).trim();
		return str;
	}

	public static void waitEnter() {
		byte[] bytes = new byte[160];
		try {
			System.in.read(bytes);
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
	}

	public Util() {
		super();
		;
	}
}