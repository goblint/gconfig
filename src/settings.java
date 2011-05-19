
import java.io.*;

import org.json.*;
 
// Some settings which are useful for gconfig
public class settings
{
	static boolean settingsLoaded = false;
	static boolean showSettingsDialog = false;
	static String workingDir = "";
	static String goblintPath = "";
	
	static void load()
	{
		workingDir = System.getProperty("user.dir");
		goblintPath = "";
		showSettingsDialog = true;
		
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
				goblintPath = jsonObj.getString("GoblintPath");
				showSettingsDialog = jsonObj.getBoolean("ShowSettingsDialog");
			}
			
			catch (JSONException je) {
				System.out.println("[Json-Error] "+je.toString());
			}
				
			finally {
				settingsLoaded = true;
			}
		}

	}
	
	static void save()
	{
		// Create json fileStr
		String fileStr = "";
		try {
			JSONObject jsonRootObj = new JSONObject();
			jsonRootObj.put("GoblintPath", settings.goblintPath);
			jsonRootObj.put("ShowSettingsDialog", settings.showSettingsDialog);
			
			// Convert to string
			fileStr = jsonRootObj.toString(2);
		}
		catch (JSONException je) {
			System.out.println("[Json-Error] "+je.toString());
			return;
		}
		
		
		// Save the string to the file
		try {
			FileWriter fw = new FileWriter(workingDir+"\\config\\settings.json");
			fw.write(fileStr);
			fw.close();
		}
		catch (IOException e) {			
		}

	}
	
	static void print()
	{
		System.out.println("WorkingDir: "+settings.workingDir);
		System.out.println("GoblintPath: "+settings.goblintPath);
		System.out.println("ShowSettingsDialog: "+settings.showSettingsDialog);
	}
}

