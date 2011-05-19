
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
			configFile.openFromFile(args[0]);
			int exitStatus = 0;
			try {
				exitStatus = Runtime.getRuntime().exec(configFile.createCommandLine()).exitValue();
			}
			catch (java.io.IOException e) {
			}
			System.exit(exitStatus);
		}
		
	}

}
