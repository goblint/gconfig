import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Rectangle;
import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.swing.BorderFactory;
import javax.swing.JSplitPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import javax.swing.DefaultListModel;
import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import java.io.*;

// This class manages the configuration window and its updates
public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JMenuBar jJMenuBar = null;
	private JMenu jMenu_File = null;
	private JMenuItem jMenuItem_New = null;
	private JMenuItem jMenuItem_Open = null;
	private JMenuItem jMenuItem_Save = null;
	private JMenuItem jMenuItem_SaveAs = null;
	private JMenuItem jMenuItem_Exit = null;
	private JPanel jPanel_InfoBar = null;
	private JLabel jLabel = null;
	private JSplitPane jSplitPane = null;
	private JPanel jPanel_Left = null;
	private JPanel jPanel_Right = null;
	private JLabel jLabel_LeftHeader = null;
	private JPanel jPanel_Start = null;
	private JButton jButton = null;
	private JButton jButton_OpenConfig = null;
	private JButton jButton2 = null;
	private JPanel jPanel_ConfigOverview = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JButton jButton3 = null;
	private JButton jButton4 = null;
	private JLabel jLabel4 = null;
	private JTextArea jTextArea = null;
	private JTabbedPane jTabbedPane = null;
	private JButton jButton5 = null;
	private JLabel jLabel5 = null;
	private JButton jButton11 = null;
	private JPanel jPanel_Analysis = null;
	private JPanel jPanel_Run = null;
	private JLabel jLabel11 = null;
	private JLabel jLabel111 = null;
	private JLabel jLabel6 = null;
	private JTextArea jTextArea1 = null;
	private JButton jButton12 = null;
	private JLabel jLabel7 = null;
	private JTextArea jTextArea2 = null;
	private JLabel jLabel1111 = null;
	private JLabel jLabel8 = null;
	private JTabbedPane jTabbedPane1 = null;
	private JPanel jPanel_Input = null;
	private JLabel jLabel9 = null;
	private JLabel jLabel91 = null;
	private JList jList = null;
	private JTextField jTextField = null;
	private JPanel jPanel_Options = null;
	private JCheckBox jCheckBox_ContextSen = null;
	private JCheckBox jCheckBox_PathSen = null;
	private JLabel jLabel10 = null;
	private JTextField jTextField_Preprocessing = null;
	private JLabel jLabel12 = null;
	private JComboBox jComboBox_Solver = null;
	private JPanel jPanel_Output = null;
	private JLabel jLabel13 = null; 
	private JLabel jLabel14 = null;
	private JLabel jLabel_ErrorsFormatInfo = null;
	private JTextField jTextField_ErrorsFormat = null;
	private JLabel jLabel16 = null;
	private JTextField jTextField_WarningsFormat = null;
	private JLabel jLabel_WarningsFormatInfo = null;
	private JLabel jLabel17 = null;
	private JTextField jTextField_MessagesFormat = null;
	private JLabel jLabel_MessagesFormatInfo = null;
	private JMenu jMenu_Gconfig = null;
	private JMenu jMenu_Help = null;
	private JMenuItem jMenuItem_Settings = null;
	private JMenuItem jMenuItem_Help = null;
	private JMenuItem jMenuItem_Info = null;
	
	private JCheckBox jCheckBox_Analysis[];
	private JButton jButton_Nav[];
	
	private Analysis selectedAnalysis = null;  //  @jve:decl-index=0:
	private JLabel jLabel_IntervalDomain = null;
	private JCheckBox jCheckBox_Trier = null;
	private JCheckBox jCheckBox_Interval = null;
	
	// Help variables to avoid update events in some situations
	boolean cbAnalysisUpdate = true;
	boolean cbSolverUpdate = true;
	
	
	
	/**
	 * This is the default constructor
	 */
	public MainWindow() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(782, 526);
		this.setJMenuBar(getJJMenuBar());
		this.setContentPane(getJContentPane());
		this.setTitle("gconfig");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJPanel_InfoBar(), BorderLayout.NORTH);
			jContentPane.add(getJSplitPane(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jJMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getJMenu_File());
			jJMenuBar.add(getJMenu_Gconfig());
			jJMenuBar.add(getJMenu_Help());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes jMenu_File	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu_File() {
		if (jMenu_File == null) {
			jMenu_File = new JMenu();
			jMenu_File.setText("File");
			jMenu_File.add(getJMenuItem_New());
			jMenu_File.add(getJMenuItem_Open());
			jMenu_File.add(getJMenuItem_Save());
			jMenu_File.add(getJMenuItem_SaveAs());
			jMenu_File.add(getJMenuItem_Exit());
		}
		return jMenu_File;
	}

	/**
	 * This method initializes jMenuItem_New	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem_New() {
		if (jMenuItem_New == null) {
			jMenuItem_New = new JMenuItem();
			jMenuItem_New.setText("New");
		}
		return jMenuItem_New;
	}

	/**
	 * This method initializes jMenuItem_Open	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem_Open() {
		if (jMenuItem_Open == null) {
			jMenuItem_Open = new JMenuItem();
			jMenuItem_Open.setText("Open");
		}
		return jMenuItem_Open;
	}

	/**
	 * This method initializes jMenuItem_Save	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem_Save() {
		if (jMenuItem_Save == null) {
			jMenuItem_Save = new JMenuItem();
			jMenuItem_Save.setText("Save");
		}
		return jMenuItem_Save;
	}

	/**
	 * This method initializes jMenuItem_SaveAs	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem_SaveAs() {
		if (jMenuItem_SaveAs == null) {
			jMenuItem_SaveAs = new JMenuItem();
			jMenuItem_SaveAs.setText("Save As ...");
		}
		return jMenuItem_SaveAs;
	}

	/**
	 * This method initializes jMenuItem_Exit	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem_Exit() {
		if (jMenuItem_Exit == null) {
			jMenuItem_Exit = new JMenuItem();
			jMenuItem_Exit.setText("Exit");
		}
		return jMenuItem_Exit;
	}

	/**
	 * This method initializes jPanel_InfoBar	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_InfoBar() {
		if (jPanel_InfoBar == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(1);
			jLabel = new JLabel();
			jLabel.setText("   No gconfig file loaded!");
			jLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
			jLabel.setBackground(Color.white);
			jPanel_InfoBar = new JPanel();
			jPanel_InfoBar.setBackground(Color.white);
			jPanel_InfoBar.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
			jPanel_InfoBar.setLayout(gridLayout);
			jPanel_InfoBar.setPreferredSize(new Dimension(0, 24));
			jPanel_InfoBar.add(jLabel, null);
		}
		return jPanel_InfoBar;
	}

	/**
	 * This method initializes jSplitPane	
	 * 	
	 * @return javax.swing.JSplitPane	
	 */
	private JSplitPane getJSplitPane() {
		if (jSplitPane == null) {
			jSplitPane = new JSplitPane();
			jSplitPane.setDividerLocation(150);
			jSplitPane.setDividerSize(5);
			jSplitPane.setEnabled(false);
			jSplitPane.setLeftComponent(getJPanel_Left());
			jSplitPane.setRightComponent(getJPanel_Right());
		}
		return jSplitPane;
	}

	/**
	 * This method initializes jPanel_Left	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_Left() {
		if (jPanel_Left == null) {
			jLabel5 = new JLabel();
			jLabel5.setBounds(new Rectangle(0, 75, 136, 16));
			jLabel5.setText("Configuration steps:");
			jLabel_LeftHeader = new JLabel();
			jLabel_LeftHeader.setText("Navigation:");
			jLabel_LeftHeader.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
			jLabel_LeftHeader.setBounds(new Rectangle(0, 0, 131, 19));
			jLabel_LeftHeader.setName("jLabel_LeftHeader");
			jPanel_Left = new JPanel();
			jPanel_Left.setLayout(null);
			jPanel_Left.add(jLabel_LeftHeader, null);
			jPanel_Left.add(getJButton5(), null);
			jPanel_Left.add(jLabel5, null);
			jPanel_Left.add(getJButton11(), null);
		}
		return jPanel_Left;
	}

	/**
	 * This method initializes jPanel_Right	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_Right() {
		if (jPanel_Right == null) {
			jPanel_Right = new JPanel();
			jPanel_Right.setLayout(null);
			jPanel_Right.setVisible(true);
			jPanel_Right.add(getJTabbedPane(), null);
		}
		return jPanel_Right;
	}

	/**
	 * This method initializes jPanel_Start	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_Start() {
		if (jPanel_Start == null) {
			jLabel11 = new JLabel();
			jLabel11.setBounds(new Rectangle(15, 15, 226, 31));
			jLabel11.setText("Welcome");
			jLabel11.setFont(new Font("Dialog", Font.BOLD, 18));
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = -1;
			gridBagConstraints1.gridy = -1;
			jPanel_Start = new JPanel();
			jPanel_Start.setLayout(null);
			jPanel_Start.setVisible(true);
			jPanel_Start.add(getJButton(), null);
			jPanel_Start.add(getJButton_OpenConfig(), null);
			jPanel_Start.add(getJButton2(), null);
			jPanel_Start.add(jLabel11, null);
		}
		return jPanel_Start;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(30, 80, 223, 38));
			jButton.setText("Create new configuration");
			jButton.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					// Create new configuration file					
					configFile.createNew();
					
					// Show configuration overview					
					jTabbedPane.setSelectedIndex(1);
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jButton_OpenConfig	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_OpenConfig() {
		if (jButton_OpenConfig == null) {
			jButton_OpenConfig = new JButton();
			jButton_OpenConfig.setBounds(new Rectangle(30, 130, 221, 38));
			jButton_OpenConfig.setText("Open configuration from file");
			jButton_OpenConfig.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					JFileChooser fc = new JFileChooser();
					fc.setCurrentDirectory(new File(settings.workingDir));
					fc.showOpenDialog(null);
					File selectedFile = fc.getSelectedFile();
					if (selectedFile != null) {
						// Open configuration file
						if (configFile.openFromFile(selectedFile.getAbsolutePath())) {
							// Show configuration overview					
							jTabbedPane.setSelectedIndex(1);
							updateNavBar();
						}
					}
				}
			});
		}
		return jButton_OpenConfig;
	}

	/**
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setBounds(new Rectangle(30, 180, 221, 36));
			jButton2.setText("Exit gconfig");
			jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					System.exit(0);
				}
			});
		}
		return jButton2;
	}

	/**
	 * This method initializes jPanel_ConfigOverview	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_ConfigOverview() {
		if (jPanel_ConfigOverview == null) {
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(30, 65, 76, 16));
			jLabel4.setText("Notes:");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(30, 180, 121, 16));
			jLabel3.setText("Select analysis:");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(30, 45, 190, 16));
			jLabel2.setText("Filename:  Unnamed");
			jLabel1 = new JLabel();
			jLabel1.setText("Configuration Overview");
			jLabel1.setFont(new Font("Dialog", Font.BOLD, 18));
			jLabel1.setBounds(new Rectangle(15, 15, 226, 31));
			jPanel_ConfigOverview = new JPanel();
			jPanel_ConfigOverview.setLayout(null);
			jPanel_ConfigOverview.add(jLabel1, null);
			jPanel_ConfigOverview.add(jLabel2, null);
			jPanel_ConfigOverview.add(jLabel3, null);
			jPanel_ConfigOverview.add(getJButton3(), null);
			jPanel_ConfigOverview.add(getJButton4(), null);
			jPanel_ConfigOverview.add(jLabel4, null);
			jPanel_ConfigOverview.add(getJTextArea(), null);
			
			// Create checkboxes and navigation button for each analysis
			jCheckBox_Analysis = new JCheckBox[configFile.analysis.length];
			jButton_Nav = new JButton[configFile.analysis.length];
			for (int i = 0; i < configFile.analysis.length; i++) {
				// Create a checkbox on the overview page
				jCheckBox_Analysis[i] = new JCheckBox();
				jCheckBox_Analysis[i].setBounds(new Rectangle(45+150*(i/5), 205+((i%5)*21), 150, 21));
				jCheckBox_Analysis[i].setText(configFile.analysis[i].name);				
				jCheckBox_Analysis[i].addItemListener(new java.awt.event.ItemListener() {
					public void itemStateChanged(java.awt.event.ItemEvent e) {
						JCheckBox jb = (JCheckBox)e.getItem();
						if (cbAnalysisUpdate) {
							for (int i = 0; i < configFile.analysis.length; i++) {
								if (jb.getText().equals(configFile.analysis[i].name)) {
									configFile.analysis[i].selected = !configFile.analysis[i].selected;
									updateNavBar();
									break;
								}
							}
						}
					}
				});				
				jPanel_ConfigOverview.add(jCheckBox_Analysis[i], null);
				
				// Create a button on the left navigation page
				jButton_Nav[i] = new JButton();
				jButton_Nav[i].setBounds(new Rectangle(10, 105+i*25, 130, 25));
				jButton_Nav[i].setText(configFile.analysis[i].name);
				jButton_Nav[i].setVisible(true);
				jButton_Nav[i].setEnabled(false);
				jButton_Nav[i].addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent e) {
						JButton jb = (JButton)e.getComponent();
						for (int i = 0; i < configFile.analysis.length; i++) {
							if (jb.getText().equals(configFile.analysis[i].name)) {
								updateAnalysisPage(i);
								break;
							}
						}
						jTabbedPane.setSelectedIndex(2);
					}
				});
				jPanel_Left.add(jButton_Nav[i], null);
			}
		}
		return jPanel_ConfigOverview;
	}

	/**
	 * This method initializes jButton3	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setBounds(new Rectangle(45, 330, 136, 31));
			jButton3.setText("Save");
		}
		return jButton3;
	}

	/**
	 * This method initializes jButton4	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton4() {
		if (jButton4 == null) {
			jButton4 = new JButton();
			jButton4.setBounds(new Rectangle(195, 330, 121, 31));
			jButton4.setActionCommand("");
			jButton4.setText("Show and run");
		}
		return jButton4;
	}

	/**
	 * This method initializes jTextArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea() {
		if (jTextArea == null) {
			jTextArea = new JTextArea();
			jTextArea.setBounds(new Rectangle(45, 90, 451, 76));
			jTextArea.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		}
		return jTextArea;
	}

	/**
	 * This method initializes jTabbedPane	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getJTabbedPane() {
		if (jTabbedPane == null) {
			jTabbedPane = new JTabbedPane();
			jTabbedPane.setBounds(new Rectangle(9, 8, 562, 426));
			jTabbedPane.setVisible(true);
			jTabbedPane.addTab(null, null, getJPanel_Start(), null);
			jTabbedPane.addTab(null, null, getJPanel_ConfigOverview(), null);
			jTabbedPane.addTab(null, null, getJPanel_Analysis(), null);
			jTabbedPane.addTab(null, null, getJPanel_Run(), null);
		}
		return jTabbedPane;
	}

	/**
	 * This method initializes jButton5	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton5() {
		if (jButton5 == null) {
			jButton5 = new JButton();
			jButton5.setBounds(new Rectangle(15, 30, 121, 31));
			jButton5.setText("Home");
			jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					//System.out.println("mouseClicked()"); // TODO Auto-generated Event stub mouseClicked()
					jTabbedPane.setSelectedIndex(0);
				}
			});
		}
		return jButton5;
	}

	/**
	 * This method initializes jButton11	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton11() {
		if (jButton11 == null) {
			jButton11 = new JButton();
			jButton11.setBounds(new Rectangle(15, 285, 121, 31));
			jButton11.setText("Run and show");
			jButton11.setVisible(false);
			jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					//System.out.println("mouseClicked()"); // TODO Auto-generated Event stub mouseClicked()
					jTabbedPane.setSelectedIndex(3);
				}
			});
		}
		return jButton11;
	}

	/**
	 * This method initializes jPanel_Analysis	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_Analysis() {
		if (jPanel_Analysis == null) {
			jLabel8 = new JLabel();
			jLabel8.setBounds(new Rectangle(15, 45, 512, 18));
			jLabel8.setText("Info text");
			jLabel1111 = new JLabel();
			jLabel1111.setBounds(new Rectangle(15, 15, 271, 31));
			jLabel1111.setText("Base");
			jLabel1111.setFont(new Font("Dialog", Font.BOLD, 18));
			jPanel_Analysis = new JPanel();
			jPanel_Analysis.setLayout(null);
			jPanel_Analysis.add(jLabel1111, null);
			jPanel_Analysis.add(jLabel8, null);
			jPanel_Analysis.add(getJTabbedPane1(), null);
		}
		return jPanel_Analysis;
	}

	/**
	 * This method initializes jPanel_Run	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_Run() {
		if (jPanel_Run == null) {
			jLabel7 = new JLabel();
			jLabel7.setBounds(new Rectangle(30, 207, 91, 16));
			jLabel7.setText("Result output:");
			jLabel6 = new JLabel();
			jLabel6.setBounds(new Rectangle(30, 55, 195, 16));
			jLabel6.setText("Current command line:");
			jLabel111 = new JLabel();
			jLabel111.setFont(new Font("Dialog", Font.BOLD, 18));
			jLabel111.setBounds(new Rectangle(15, 15, 286, 31));
			jLabel111.setText("Run and show command line");
			jPanel_Run = new JPanel();
			jPanel_Run.setLayout(null);
			jPanel_Run.add(jLabel111, null);
			jPanel_Run.add(jLabel6, null);
			jPanel_Run.add(getJTextArea1(), null);
			jPanel_Run.add(getJButton12(), null);
			jPanel_Run.add(jLabel7, null);
			jPanel_Run.add(getJTextArea2(), null);
		}
		return jPanel_Run;
	}

	/**
	 * This method initializes jTextArea1	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea1() {
		if (jTextArea1 == null) {
			jTextArea1 = new JTextArea();
			jTextArea1.setBounds(new Rectangle(30, 75, 481, 71));
			jTextArea1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		}
		return jTextArea1;
	}

	/**
	 * This method initializes jButton12	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton12() {
		if (jButton12 == null) {
			jButton12 = new JButton();
			jButton12.setBounds(new Rectangle(30, 160, 166, 31));
			jButton12.setText("Run");
		}
		return jButton12;
	}

	/**
	 * This method initializes jTextArea2	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea2() {
		if (jTextArea2 == null) {
			jTextArea2 = new JTextArea();
			jTextArea2.setBounds(new Rectangle(30, 225, 481, 71));
			jTextArea2.setBorder(BorderFactory.createLineBorder(Color.gray,1));
		}
		return jTextArea2;
	}

	/**
	 * This method initializes jTabbedPane1	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getJTabbedPane1() {
		if (jTabbedPane1 == null) {
			jTabbedPane1 = new JTabbedPane();
			jTabbedPane1.setBounds(new Rectangle(15, 105, 511, 256));
			jTabbedPane1.addTab("Input", null, getJPanel_Input(), null);
			jTabbedPane1.addTab("Options", null, getJPanel_Options(), null);
			jTabbedPane1.addTab("Output", null, getJPanel_Output(), null);
		}
		return jTabbedPane1;
	}

	/**
	 * This method initializes jPanel_Input	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_Input() {
		if (jPanel_Input == null) {
			jLabel91 = new JLabel();
			jLabel91.setBounds(new Rectangle(15, 16, 76, 16));
			jLabel91.setText("Class name:");
			jLabel9 = new JLabel();
			jLabel9.setText("Input files:");
			jLabel9.setBounds(new Rectangle(15, 45, 61, 16));
			jPanel_Input = new JPanel();
			jPanel_Input.setLayout(null);
			jPanel_Input.add(jLabel9, null);
			jPanel_Input.add(jLabel91, null);
			jPanel_Input.add(getJList(), null);
			jPanel_Input.add(getJTextField(), null);
		}
		return jPanel_Input;
	}

	/**
	 * This method initializes jList	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJList() {
		if (jList == null) {
			jList = new JList();
			jList.setBounds(new Rectangle(15, 70, 331, 96));
			jList.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
		}
		return jList;
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(105, 15, 241, 20));
		}
		return jTextField;
	}

	/**
	 * This method initializes jPanel_Options	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_Options() {
		if (jPanel_Options == null) {
			jLabel_IntervalDomain = new JLabel();
			jLabel_IntervalDomain.setBounds(new Rectangle(30, 90, 106, 16));
			jLabel_IntervalDomain.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
			jLabel_IntervalDomain.setEnabled(true);
			jLabel_IntervalDomain.setText("IntervalDomain:");
			jLabel12 = new JLabel();
			jLabel12.setBounds(new Rectangle(30, 150, 73, 16));
			jLabel12.setText("Solver:");
			jLabel10 = new JLabel();
			jLabel10.setBounds(new Rectangle(30, 60, 102, 16));
			jLabel10.setText("Preprocessing:");
			jPanel_Options = new JPanel();
			jPanel_Options.setLayout(null);
			jPanel_Options.add(getJCheckBox_ContextSen(), null);
			jPanel_Options.add(getJCheckBox_PathSen(), null);
			jPanel_Options.add(jLabel10, null);
			jPanel_Options.add(getJTextField_Preprocessing(), null);
			jPanel_Options.add(jLabel12, null);
			jPanel_Options.add(getJComboBox_Solver(), null);
			jPanel_Options.add(jLabel_IntervalDomain, null);
			jPanel_Options.add(getJCheckBox_Trier(), null);
			jPanel_Options.add(getJCheckBox_Interval(), null);
		}
		return jPanel_Options;
	}

	/**
	 * This method initializes jCheckBox_ContextSen	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBox_ContextSen() {
		if (jCheckBox_ContextSen == null) {
			jCheckBox_ContextSen = new JCheckBox();
			jCheckBox_ContextSen.setBounds(new Rectangle(26, 14, 149, 16));
			jCheckBox_ContextSen.setText("Context Sensitive");
			jCheckBox_ContextSen.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					JCheckBox jb = (JCheckBox)e.getItem();
					selectedAnalysis.contextSen.value = jb.isSelected();
				}
			});
		}
		return jCheckBox_ContextSen;
	}

	/**
	 * This method initializes jCheckBox_PathSen	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBox_PathSen() {
		if (jCheckBox_PathSen == null) {
			jCheckBox_PathSen = new JCheckBox();
			jCheckBox_PathSen.setBounds(new Rectangle(26, 34, 151, 16));
			jCheckBox_PathSen.setText("Path Sensitive");
			jCheckBox_PathSen.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					JCheckBox jb = (JCheckBox)e.getItem();
					selectedAnalysis.pathSen.value = jb.isSelected();
				}
			});
		}
		return jCheckBox_PathSen;
	}
	
	/**
	 * This method initializes jCheckBox_Trier	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBox_Trier() {
		if (jCheckBox_Trier == null) {
			jCheckBox_Trier = new JCheckBox();
			jCheckBox_Trier.setBounds(new Rectangle(150, 90, 91, 16));
			jCheckBox_Trier.setText("Trier");
			jCheckBox_Trier.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					JCheckBox jb = (JCheckBox)e.getItem();
					selectedAnalysis.intervalDomain.trier = jb.isSelected();
					
					// Update page, because of solver selection
					if (selectedAnalysis.intervalDomain.trier) {
						selectedAnalysis.selectedSolver = "solverConSideWNRR";
					}
					updateAnalysisPage(-1);
				}
			});
		}
		return jCheckBox_Trier;
	}

	/**
	 * This method initializes jCheckBox_Interval	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBox_Interval() {
		if (jCheckBox_Interval == null) {
			jCheckBox_Interval = new JCheckBox();
			jCheckBox_Interval.setBounds(new Rectangle(150, 110, 91, 16));
			jCheckBox_Interval.setText("Interval");
			jCheckBox_Interval.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					JCheckBox jb = (JCheckBox)e.getItem();
					selectedAnalysis.intervalDomain.interval = jb.isSelected();
					
					// Update page, because of solver selection
					if (selectedAnalysis.intervalDomain.interval) {
						selectedAnalysis.selectedSolver = "solverConSideWNRR";
					}
					updateAnalysisPage(-1);
				}
			});
		}
		return jCheckBox_Interval;
	}

	/**
	 * This method initializes jTextField_Preprocessing	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_Preprocessing() {
		if (jTextField_Preprocessing == null) {
			jTextField_Preprocessing = new JTextField();
			jTextField_Preprocessing.setBounds(new Rectangle(146, 59, 271, 20));
			jTextField_Preprocessing.addCaretListener(new javax.swing.event.CaretListener() {
				public void caretUpdate(javax.swing.event.CaretEvent e) {
					JTextField jtf = (JTextField)e.getSource();
					selectedAnalysis.preprocessingCmdLine = jtf.getText();
				}
			});
		}
		return jTextField_Preprocessing;
	}

	/**
	 * This method initializes jComboBox_Solver	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox_Solver() {
		if (jComboBox_Solver == null) {
			jComboBox_Solver = new JComboBox();
			jComboBox_Solver.setBounds(new Rectangle(150, 150, 166, 16));
			jComboBox_Solver.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					if (cbSolverUpdate) {
						selectedAnalysis.selectedSolver = (String)e.getItem();
					}
				}
			});
		}
		return jComboBox_Solver;
	}

	/**
	 * This method initializes jPanel_Output	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_Output() {
		if (jPanel_Output == null) {
			jLabel_MessagesFormatInfo = new JLabel();
			jLabel_MessagesFormatInfo.setBounds(new Rectangle(135, 190, 166, 16));
			jLabel_MessagesFormatInfo.setText("Message format string info");
			jLabel17 = new JLabel();
			jLabel17.setBounds(new Rectangle(47, 167, 74, 16));
			jLabel17.setText("Messages:");
			jLabel_WarningsFormatInfo = new JLabel();
			jLabel_WarningsFormatInfo.setBounds(new Rectangle(136, 131, 165, 16));
			jLabel_WarningsFormatInfo.setText("Warning format string info");
			jLabel16 = new JLabel();
			jLabel16.setBounds(new Rectangle(46, 104, 75, 16));
			jLabel16.setText("Warnings:");
			jLabel_ErrorsFormatInfo = new JLabel();
			jLabel_ErrorsFormatInfo.setBounds(new Rectangle(135, 70, 271, 16));
			jLabel_ErrorsFormatInfo.setText("Error format string info");
			jLabel14 = new JLabel();
			jLabel14.setBounds(new Rectangle(46, 44, 51, 16));
			jLabel14.setText("Errors:");
			jLabel13 = new JLabel();
			jLabel13.setText("Result format strings:");
			jLabel13.setBounds(new Rectangle(15, 15, 136, 16));
			jPanel_Output = new JPanel();
			jPanel_Output.setLayout(null);
			jPanel_Output.add(jLabel13, null);
			jPanel_Output.add(jLabel14, null);
			jPanel_Output.add(jLabel_ErrorsFormatInfo, null);
			jPanel_Output.add(getJTextField_ErrorsFormat(), null);
			jPanel_Output.add(jLabel16, null);
			jPanel_Output.add(getJTextField_WarningsFormat(), null);
			jPanel_Output.add(jLabel_WarningsFormatInfo, null);
			jPanel_Output.add(jLabel17, null);
			jPanel_Output.add(getJTextField_MessagesFormat(), null);
			jPanel_Output.add(jLabel_MessagesFormatInfo, null);
		}
		return jPanel_Output;
	}

	/**
	 * This method initializes jTextField_ErrorsFormat	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_ErrorsFormat() {
		if (jTextField_ErrorsFormat == null) {
			jTextField_ErrorsFormat = new JTextField();
			jTextField_ErrorsFormat.setBounds(new Rectangle(135, 45, 316, 20));
			jTextField_ErrorsFormat.addCaretListener(new javax.swing.event.CaretListener() {
				public void caretUpdate(javax.swing.event.CaretEvent e) {
					JTextField jtf = (JTextField)e.getSource();
					selectedAnalysis.resultErrors.format = jtf.getText();
				}
			});
		}
		return jTextField_ErrorsFormat;
	}

	/**
	 * This method initializes jTextField_WarningsFormat	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_WarningsFormat() {
		if (jTextField_WarningsFormat == null) {
			jTextField_WarningsFormat = new JTextField();
			jTextField_WarningsFormat.setBounds(new Rectangle(134, 105, 317, 20));
			jTextField_WarningsFormat
					.addCaretListener(new javax.swing.event.CaretListener() {
						public void caretUpdate(javax.swing.event.CaretEvent e) {
							JTextField jtf = (JTextField)e.getSource();
							selectedAnalysis.resultWarnings.format = jtf.getText();
						}
					});
		}
		return jTextField_WarningsFormat;
	}

	/**
	 * This method initializes jTextField_MessagesFormat	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_MessagesFormat() {
		if (jTextField_MessagesFormat == null) {
			jTextField_MessagesFormat = new JTextField();
			jTextField_MessagesFormat.setBounds(new Rectangle(135, 165, 316, 20));
			jTextField_MessagesFormat
					.addCaretListener(new javax.swing.event.CaretListener() {
						public void caretUpdate(javax.swing.event.CaretEvent e) {
							JTextField jtf = (JTextField)e.getSource();
							selectedAnalysis.resultMessages.format = jtf.getText();
						}
					});
		}
		return jTextField_MessagesFormat;
	}

	/**
	 * This method initializes jMenu_Gconfig	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu_Gconfig() {
		if (jMenu_Gconfig == null) {
			jMenu_Gconfig = new JMenu();
			jMenu_Gconfig.setText("Gconfig");
			jMenu_Gconfig.add(getJMenuItem_Settings());
		}
		return jMenu_Gconfig;
	}

	/**
	 * This method initializes jMenu_Help	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu_Help() {
		if (jMenu_Help == null) {
			jMenu_Help = new JMenu();
			jMenu_Help.setText("Help");
			jMenu_Help.add(getJMenuItem_Help());
			jMenu_Help.add(getJMenuItem_Info());
		}
		return jMenu_Help;
	}

	/**
	 * This method initializes jMenuItem_Settings	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem_Settings() {
		if (jMenuItem_Settings == null) {
			jMenuItem_Settings = new JMenuItem();
			jMenuItem_Settings.setText("Settings");
		}
		return jMenuItem_Settings;
	}

	/**
	 * This method initializes jMenuItem_Help	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem_Help() {
		if (jMenuItem_Help == null) {
			jMenuItem_Help = new JMenuItem();
			jMenuItem_Help.setText("Help");
		}
		return jMenuItem_Help;
	}

	/**
	 * This method initializes jMenuItem_Info	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem_Info() {
		if (jMenuItem_Info == null) {
			jMenuItem_Info = new JMenuItem();
			jMenuItem_Info.setText("About");
		}
		return jMenuItem_Info;
	}
	
	// Updates the navigation bar; decides which buttons are enabled
	void updateNavBar()
	{		
		for (int i = 0; i < configFile.analysis.length; i++) {
			cbAnalysisUpdate = false;
			jCheckBox_Analysis[i].setSelected(configFile.analysis[i].selected);
			cbAnalysisUpdate = true;
			jButton_Nav[i].setEnabled(configFile.analysis[i].selected);
		}
	}
	
	// Updates the analysis page with the information of the selected analysis
	void updateAnalysisPage(int selectId)
	{
		// Refresh the page itself, if selectId == -1
		if (selectId != -1) {
			selectedAnalysis = configFile.analysis[selectId];
		}
		
		// General information
		jLabel1111.setText(selectedAnalysis.name);
		jLabel8.setText(selectedAnalysis.info);
		
		// Options
		jCheckBox_ContextSen.setEnabled(selectedAnalysis.contextSen.available);
		jCheckBox_ContextSen.setSelected(selectedAnalysis.contextSen.value);
		jCheckBox_PathSen.setEnabled(selectedAnalysis.pathSen.available);
		jCheckBox_PathSen.setSelected(selectedAnalysis.pathSen.value);
		jLabel_IntervalDomain.setEnabled(selectedAnalysis.intervalDomain.available);
		jCheckBox_Trier.setEnabled(selectedAnalysis.intervalDomain.available);
		jCheckBox_Interval.setEnabled(selectedAnalysis.intervalDomain.available);
		jCheckBox_Trier.setSelected(selectedAnalysis.intervalDomain.trier);
		jCheckBox_Interval.setSelected(selectedAnalysis.intervalDomain.interval);
		
		// Preprocessor command line
		jTextField_Preprocessing.setText(selectedAnalysis.preprocessingCmdLine);
		
		// Result format strings
		jTextField_ErrorsFormat.setText(selectedAnalysis.resultErrors.format);
		jLabel_ErrorsFormatInfo.setText(selectedAnalysis.resultErrors.help);
		jTextField_WarningsFormat.setText(selectedAnalysis.resultWarnings.format);
		jLabel_WarningsFormatInfo.setText(selectedAnalysis.resultErrors.help);
		jTextField_MessagesFormat.setText(selectedAnalysis.resultMessages.format);
		jLabel_MessagesFormatInfo.setText(selectedAnalysis.resultErrors.help);
		
		// Solver
		cbSolverUpdate = false;
		jComboBox_Solver.removeAllItems();
		if ((selectedAnalysis.intervalDomain.available) && (selectedAnalysis.intervalDomain.trier || selectedAnalysis.intervalDomain.interval)) {
			jComboBox_Solver.addItem("solverConSideWNRR");
		}
		else {
			for (int i = 0; i < selectedAnalysis.solvers.length; i++) {
				jComboBox_Solver.addItem(selectedAnalysis.solvers[i]);
			}
			jComboBox_Solver.setSelectedItem(selectedAnalysis.selectedSolver);
		}
		cbSolverUpdate = true;

	}


}  //  @jve:decl-index=0:visual-constraint="10,10"

