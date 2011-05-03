
import java.io.*;
import org.json.*;
 
// Some settings which are useful for gconfig
public class settings
{
	static boolean settingsLoaded = false;
	static String workingDir = "";
	static String goblintBin = "";
	
	static void load()
	{
		workingDir = System.getProperty("user.dir");
		goblintBin = "";
		
		// Try to open and read settings from a file
		String fileStr = "";
		try {
			File file = new File(workingDir+"\\config\\settings.json");
			FileReader fr = new FileReader(file);
			char[] buf = new char[(int)file.length()];
			fr.read(buf);
			fileStr = String.valueOf(buf);
			fr.close();
		}
		catch (IOException e) {			
		}
		
		// Parse the settings file (json file format)
		finally {
			try {
				JSONObject jsonObj = new JSONObject(fileStr);
				goblintBin = jsonObj.getString("GoblintBin");
			}
			
			catch (JSONException je) {
				System.out.println("[Json-Error] "+je.toString());
			}
				
			finally {
				settingsLoaded = true;
			}
		}

	}
	
	static void print()
	{
		System.out.println("WorkingDir: "+settings.workingDir);
		System.out.println("GoblintBin: "+settings.goblintBin);
	}
}

