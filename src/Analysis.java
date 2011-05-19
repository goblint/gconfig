import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

// This class describes one analysis containing information about the format and the values itself
public class Analysis {
	boolean selected = false;
	String name = "";
	String info = "";
	InputInfo input[];
	IntervalDomainInfo intervalDomain = new IntervalDomainInfo();
	DefaultBoolInfo contextSen = new DefaultBoolInfo();
	DefaultBoolInfo pathSen = new DefaultBoolInfo();
	String dependencies[] = null;
	String solvers[] = null;
	String selectedSolver = "";
	String goblintCmdLine = "";
	String preprocessingCmdLine = "";
	String arguments = "";
	OutputFormatInfo resultErrors = new OutputFormatInfo();
	OutputFormatInfo resultWarnings = new OutputFormatInfo();
	OutputFormatInfo resultMessages = new OutputFormatInfo();
	
	// Loads a analysis template file
	public void loadTemplate(String fileName)
	{
		// Try to open and read template file (json file format) to a string
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
		}
		
		// Parse json analysis template file
		finally {
			try {
				JSONObject jsonObj2, jsonObj3, jsonObj = new JSONObject(fileStr);
				JSONArray jsonArray;
				name = jsonObj.getString("Name");
				info = jsonObj.getString("Info");
				
				// Input info
				jsonObj2 = jsonObj.getJSONObject("Input");
				String names[] = JSONObject.getNames(jsonObj2);
				if (names != null) {
					input = new InputInfo[names.length];
					for (int i = 0; i < names.length; i++) {
						jsonObj3 = jsonObj2.getJSONObject(names[i]);
						input[i] = new InputInfo();
						input[i].name = names[i];
						input[i].type = jsonObj3.getString("Type");
						input[i].description = jsonObj3.getString("Description");
						System.out.println(names[i]);
					}
				}

				// Other info
				jsonObj2 = jsonObj.getJSONObject("ContextSensitive");
				contextSen.available = jsonObj2.getBoolean("Available");
				
				jsonObj2 = jsonObj.getJSONObject("PathSensitive");
				pathSen.available = jsonObj2.getBoolean("Available");
				
				jsonObj2 = jsonObj.getJSONObject("IntervalDomain");
				intervalDomain.available = jsonObj2.getBoolean("Available");
				
				jsonObj2 = jsonObj.getJSONObject("Result");
				jsonObj3 = jsonObj2.getJSONObject("Errors");
				resultErrors.help = jsonObj3.getString("Help");
				jsonObj3 = jsonObj2.getJSONObject("Warnings");
				resultWarnings.help = jsonObj3.getString("Help");
				jsonObj3 = jsonObj2.getJSONObject("Messages");
				resultMessages.help = jsonObj3.getString("Help");
				
				jsonArray = jsonObj.getJSONArray("Dependencies");
				dependencies = new String[jsonArray.length()];
				for (int i = 0; i < dependencies.length; i++) {
					dependencies[i] = jsonArray.getString(i);
				}
				
				jsonArray = jsonObj.getJSONArray("Solvers");
				if (jsonArray.length() == 0) {
					solvers = new String[3];
					solvers[0] = "effectWCon";
					solvers[1] = "solverConSideRR";
					solvers[2] = "solverConSideWNRR";
				}
				else {
					solvers = new String[jsonArray.length()];
					for (int i = 0; i < solvers.length; i++) {
						solvers[i] = jsonArray.getString(i);
					}
				}

				goblintCmdLine = jsonObj.getString("goblint");			
			}
			
			catch (JSONException je) {
				System.out.println("[Json-Error] "+je.toString());
			}				
		}
	}

}

class InputInfo {
	String name = "";
	String type = "";
	String description = "";
	String files[] = null;
}

class IntervalDomainInfo {
	boolean available = false;
	boolean trier = false;
	boolean interval = false;
}

class DefaultBoolInfo {
	boolean available = false;
	boolean value = false;
}

class OutputFormatInfo {
	String format = "";
	String help = "";
}
