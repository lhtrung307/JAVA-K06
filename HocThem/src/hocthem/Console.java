package hocthem;

public class Console {
	private Console() {
		buf = new byte[4096]; // 4KB
	}

	private byte[] buf, bb;
	private int nl = System.lineSeparator().length(); // 2

	private String getLine() throws Exception {
		int n = System.in.read(buf);
		return (new String(buf, 0, n - nl)).trim();
	}

	private byte[] getInput() throws Exception {
		int n = System.in.read(buf);
		return (new String(buf, 0, n - nl)).trim().getBytes();
	}

	public static Console getConsole() {
		return new Console();
	}

	public void onConsole(String msg) {
		System.out.print(msg);
	}

	public void onNextLine(String msg) {
		System.out.println(msg);
	}

	/**
	 * getByte() returns the 1st byte which is not a space (0x20)
	 */
	public byte getByte() throws Exception {
		return getInput()[0];
	}

	/**
	 * getShort() returns a short
	 */
	public short getShort() throws Exception {
		bb = getInput();
		short result = 0;
		for (int i = bb.length - 1, f = 1; i >= 0; --i) {
			if (i == 0 && bb[i] == '-')
				return (short) -result;
			if (bb[i] > '9' || bb[i] < '0')
				throw new Exception(new String(bb) + " is not a number");
			result += (bb[i] & 0x0F) * f;
			f *= 10;
		}
		return result;
	}

	/**
	 * getInt() returns an integer
	 */
	public int getInt() throws Exception {
		bb = getInput();
		int result = 0;
		for (int i = bb.length - 1, f = 1; i >= 0; --i) {
			if (i == 0 && bb[i] == '-')
				return -result;
			if (bb[i] > '9' || bb[i] < '0')
				throw new Exception(new String(bb) + " is not a number");
			result += (bb[i] & 0x0F) * f;
			f *= 10;
		}
		return result;
	}

	/**
	 * getLong() returns a long
	 */
	public long getLong() throws Exception {
		bb = getInput();
		long result = 0;
		for (int i = bb.length - 1, f = 1; i >= 0; --i) {
			if (i == 0 && bb[i] == '-')
				return -result;
			if (bb[i] > '9' || bb[i] < '0')
				throw new Exception(new String(bb) + " is not a number");
			result += (bb[i] & 0x0F) * f;
			f *= 10;
		}
		return result;
	}

	/**
	 * getFloat() returns a float
	 */
	public float getFloat() throws Exception {
		return Float.parseFloat(getLine());
	}

	/**
	 * getDouble() returns a double
	 */
	public double getDouble() throws Exception {
		return Double.parseDouble(getLine());
	}

	/**
	 * getString() returns a String
	 */
	public String getString() throws Exception {
		return getLine();
	}

	/**
	 * getByteArray() returns a byte array
	 */
	public byte[] getByteArray() throws Exception {
		return getInput();
	}
	
	/**
    getCharArray() returns a Char array
    */
	public char[] getCharArray() throws Exception{
		return getLine().toCharArray();
	}

	public static void main(String[] args) throws Exception {
		Console c = Console.getConsole();
		c.onConsole("Enter a short:");
		System.out.printf(">>>%d\n", c.getShort());
		c.onConsole("Enter a int:");
		System.out.printf(">>>%d\n", c.getInt());
		c.onConsole("Enter a long:");
		long sd = c.getLong();
		System.out.println(sd);
	}
}