
import org.json.*;

// The main class
public class gconfig
{
	static MainWindow mainWindow = null;
	static SettingsWindow settingsWindow = null;

	public static void main(String[] args)
	{
		// Load settings for the configuration tool
		settings.load();
		
		// Initialize and load analysis templates, ...
		configFile.initialize();
		
		// Create and show configuration window
		if (args.length == 0) {
			mainWindow = new MainWindow();
			mainWindow.setVisible(true);
			
			settingsWindow = new SettingsWindow();
			if (settings.showSettingsDialog) {
				MainWindow.ShowSettingsDialog();
			}
		}
		
		// Run goblint command line
		else {
			// Some variables
			boolean showCommandLine = false;
			
			// Parse arguments, load configuration file and add input files
			boolean startedWithFiles = false;
			boolean hasConfigFile = false;
			for (int i = 0; i < args.length; i++) {
				if (startedWithFiles == false) {
					if (args[i].charAt(0) == '-') {
						if (args[i].equals("-h")) {
							System.out.println("gconfig [<gconfig options>] <configfile> <files>* [<goblint options>]");
							System.out.println("  Gconfig options:");
							System.out.println("    -h	: Display this help info");
							System.out.println("    -c	: Display executed command line");
						}
						else if (args[i].equals("-c")) {
							showCommandLine = true;
						}
						continue;
					}
					else startedWithFiles = true;
				}
				if (hasConfigFile == false) {
					// Load setup/configuration file
					if (configFile.openFromFile(args[i]) == false) {
						System.out.println("[Gconfig-Error] Could not open configuration file \""+args[i]+"\"");
						System.exit(0);
					}
					hasConfigFile = true;
					continue;
				}
				configFile.inputFiles.add(args[i]);
			}
			if (hasConfigFile == false) System.exit(0);
			
			// Create commandline
			String cmdLine = configFile.createCommandLine();
			if (showCommandLine) {
				System.out.println(cmdLine);
			}
			
			// Run command line
			int exitStatus = 0;
			try {				
				exitStatus = Runtime.getRuntime().exec(cmdLine).exitValue();
			}
			catch (java.io.IOException e) {
			}
			System.exit(exitStatus);
		}
		
	}

}
