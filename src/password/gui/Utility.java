package password.gui;
import java.io.File;

public class Utility {

	public static String getProjectDir() {
		File dir = new File(".");
		StringBuffer s = new StringBuffer(dir.getAbsolutePath());
		s.deleteCharAt(s.length() - 1);
		return s.toString();
	}

	public static String getDir(String child) {
		File dir = new File(getProjectDir() + child);
		dir.mkdir();
		return dir.getAbsolutePath();
	}

}
