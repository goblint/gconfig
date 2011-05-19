import java.awt.BorderLayout;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.File;

import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class SettingsWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JButton jButton_Save = null;
	private JButton jButton_Cancel = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	public JTextField jTextField_GoblintPath = null;	
	public JCheckBox jCheckBox_ShowDialog = null;
	private JButton jButton = null;
	
	/**
	 * This is the default constructor
	 */
	public SettingsWindow() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(482, 234);
		this.setContentPane(getJContentPane());
		this.setTitle("Gconfig settings");
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.out.println("windowClosing()"); // TODO Auto-generated Event stub windowClosing()
				gconfig.mainWindow.setEnabled(true);
				gconfig.settingsWindow.setVisible(false);
			}
		});
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(30, 60, 256, 16));
			jLabel1.setText("Path to goblint executable file:");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(120, 15, 241, 31));
			jLabel.setFont(new Font("Dialog", Font.BOLD, 18));
			jLabel.setText("Gconfig settings");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJButton_Save(), null);
			jContentPane.add(getJButton_Cancel(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(getJTextField_GoblintPath(), null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJCheckBox_ShowDialog(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jButton_Save	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_Save() {
		if (jButton_Save == null) {
			jButton_Save = new JButton();
			jButton_Save.setBounds(new Rectangle(315, 150, 136, 31));
			jButton_Save.setText("Save");
			jButton_Save.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					settings.goblintPath = jTextField_GoblintPath.getText();
					settings.showSettingsDialog = jCheckBox_ShowDialog.isSelected();
					settings.save();
					gconfig.mainWindow.setEnabled(true);
					gconfig.settingsWindow.setVisible(false);
				}
			});
		}
		return jButton_Save;
	}

	/**
	 * This method initializes jButton_Cancel	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_Cancel() {
		if (jButton_Cancel == null) {
			jButton_Cancel = new JButton();
			jButton_Cancel.setBounds(new Rectangle(165, 150, 136, 31));
			jButton_Cancel.setText("Cancel");
			jButton_Cancel.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					gconfig.mainWindow.setEnabled(true);
					gconfig.settingsWindow.setVisible(false);
				}
			});
		}
		return jButton_Cancel;
	}

	/**
	 * This method initializes jTextField_GoblintPath	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_GoblintPath() {
		if (jTextField_GoblintPath == null) {
			jTextField_GoblintPath = new JTextField();
			jTextField_GoblintPath.setBounds(new Rectangle(30, 80, 336, 20));
		}
		return jTextField_GoblintPath;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(375, 79, 76, 21));
			jButton.setText("Find");
			jButton.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					JFileChooser fc = new JFileChooser();
					fc.setCurrentDirectory(new File(settings.workingDir));
					fc.showOpenDialog(null);
					File selectedFile = fc.getSelectedFile();
					if (selectedFile != null) {
						jTextField_GoblintPath.setText(selectedFile.getAbsolutePath());
					}
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jCheckBox_ShowDialog	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBox_ShowDialog() {
		if (jCheckBox_ShowDialog == null) {
			jCheckBox_ShowDialog = new JCheckBox();
			jCheckBox_ShowDialog.setBounds(new Rectangle(27, 120, 273, 16));
			jCheckBox_ShowDialog.setText("Show settings dialog at start");
		}
		return jCheckBox_ShowDialog;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
