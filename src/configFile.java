import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.*;

// This class handles and manages a configuration file
public class configFile { 
	static String fileName = "";	
	static Analysis[] analysis = null;
	
	// Creates a new configuration file and resets all settings
	static void createNew()
	{
		// ToDo
	}
	
	// Loads the configuration from a file
	static boolean openFromFile(String fileName)
	{
		// Try to open and read the configuration file to a string
		String fileStr = "";
		try {
			File file = new File(fileName);
			FileReader fr = new FileReader(file);
			char[] buf = new char[(int)file.length()];
			fr.read(buf);
			fileStr = String.valueOf(buf);
			fr.close();
		}
		catch (IOException e) {	
			return false;
		}
		
		// Parse the configuration file (json file format)
		try { 
			JSONObject jsonAnalysisObj = null, jsonChildObj, jsonRootObj = new JSONObject(fileStr);
			JSONArray jsonArray;
			
			// Go through all available analysis and search for it in the opened configuration file
			for (int i = 0; i < configFile.analysis.length; i++) {
				// Find out, if the analysis is available in the configuration file
				configFile.analysis[i].selected = true;
				try {
					jsonAnalysisObj = jsonRootObj.getJSONObject(configFile.analysis[i].name);
				}
				catch (JSONException e) {
					configFile.analysis[i].selected = false;
				}
				
				// Load configuration for the analysis
				if (configFile.analysis[i].selected) {
					configFile.analysis[i].contextSen.value = jsonAnalysisObj.getBoolean("ContextSensitive");
					configFile.analysis[i].pathSen.value = jsonAnalysisObj.getBoolean("PathSensitive");
					configFile.analysis[i].preprocessingCmdLine = jsonAnalysisObj.getString("Preprocessing");
					configFile.analysis[i].selectedSolver = jsonAnalysisObj.getString("Solver");
					
					jsonChildObj = jsonAnalysisObj.getJSONObject("IntervalDomain");
					configFile.analysis[i].intervalDomain.trier = jsonChildObj.getBoolean("Trier");
					configFile.analysis[i].intervalDomain.interval = jsonChildObj.getBoolean("Interval");
					
					jsonChildObj = jsonAnalysisObj.getJSONObject("Result");
					configFile.analysis[i].resultErrors.format = jsonChildObj.getString("Errors");
					configFile.analysis[i].resultWarnings.format = jsonChildObj.getString("Warnings");
					configFile.analysis[i].resultMessages.format = jsonChildObj.getString("Messages");					
				}				
			}
			
			
		}
		catch (JSONException je) {
			System.out.println("[Json-Error] "+je.toString());
			return false;
		}	
		
		return true;
	}
	
	// Saves the current configuration to a file
	static boolean saveToFile(String fileName)
	{
		// Create the configuration file (json file format) and save it to a String
		String fileStr = "";
		// ToDo
		
		// Save the string to the file
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write(fileStr);
			fw.close();
		}
		catch (IOException e) {			
		}

		return false;
	}
	
	// Initializes all the things needed for configuration
	static void initialize()
	{
		// Load all analysis template files from "config\analysis\"
		File maindir = new File(settings.workingDir+"\\config\\analyses");
		File filelist[] = maindir.listFiles();
		analysis = new Analysis[filelist.length];
		for (int i = 0; i < filelist.length; i++) {
			analysis[i] = new Analysis();
			analysis[i].loadTemplate(filelist[i].getAbsolutePath());
		}
	}
	
	// Creates the command line for the current configuration to to run the goblint
	static String createCommandLine()
	{
		return "";
	}
	
}
