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
import javax.swing.JScrollPane;
import java.awt.*;
import java.awt.color.*;
import java.awt.Graphics;

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
	private JLabel jLabel_Status = null;
	private JSplitPane jSplitPane = null;
	private JPanel jPanel_Left = null;
	private JPanel jPanel_Right = null;
	private JLabel jLabel_LeftHeader = null;
	private JPanel jPanel_Start = null;
	private JButton jButton_CreateConfig = null;
	private JButton jButton_OpenConfig = null;
	private JButton jButton_Exit = null;
	private JPanel jPanel_ConfigOverview = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JButton jButton_SaveConfig = null;
	private JLabel jLabel4 = null;
	private JTextArea jTextArea = null;
	private JTabbedPane jTabbedPane = null;
	private JButton jButton_Home = null;
	private JLabel jLabel5 = null;
	private JPanel jPanel_Analysis = null;
	private JPanel jPanel_Run = null;
	private JLabel jLabel11 = null;
	private JLabel jLabel111 = null;
	private JLabel jLabel6 = null;
	private JTextArea jTextArea_Cmdline = null;
	private JButton jButton12 = null;
	private JLabel jLabel7 = null;
	private JTextArea jTextArea_ResultOutput = null;
	private JLabel jLabel1111 = null;
	private JLabel jLabel8 = null;
	private JTabbedPane jTabbedPane1 = null;
	private JPanel jPanel_Input = null;
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
	private JLabel jLabel15 = null;
	private JTextField jTextField_Arguments = null;
	private JButton jButton_Next = null;
	private JButton jButton_Prev = null;
	private JButton jButton_Run = null;
	private JButton jButton7 = null;
	private JButton jButton8 = null;
	private JButton jButton_InputFiles = null;
	private JPanel jPanel_InputFiles = null;
	private JLabel jLabel = null;
	private JLabel jLabel9 = null;
	private JList jList_InputFiles = null;
	private JButton jButton_AddFile = null;
	private JButton jButton_DeleteFile = null;
	private JButton jButton_Overview = null;
	private JTextField jTextField_Input1 = null;
	private JLabel jLabel_InputCaption1 = null;
	private JLabel jLabel_InputDescription1 = null;
	private JLabel jLabel_InputCaption2 = null;
	private JTextField jTextField_Input2 = null;
	private JLabel jLabel_InputDescription2 = null;
	private JButton jButton_InputFind1 = null;
	private JButton jButton_InputFind2 = null;
	private JLabel jLabel18 = null;
	private JButton jButton_StartSetup = null;
	private JLabel jLabel19 = null;
	private JTextField jTextField_GoblintOptions = null;
	private JButton jButton_GotoRun = null;
	private JTabbedPane jTabbedPane_Input = null;
	private JPanel jPanel_SourceFiles = null;
	private JPanel jPanel_OtherOptions = null;
	/**
	 * This is the default constructor
	 */
	public MainWindow() {
		super();
		initialize();
		
		UpdateStatusbar();
		
		// Hack to hide tabs (TabbedPane for easier
		jTabbedPane.setBounds(new Rectangle(-10, -30, 2000, 2000));
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(791, 564);
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
			jMenuItem_New.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					CreateConfigurationFile();
				}
			});
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
			jMenuItem_Open.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					OpenConfigurationFile();
				}
			});
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
			jMenuItem_Save.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					configFile.saveToFile(configFile.fileName);
				}
			});
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
			jMenuItem_SaveAs.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					SaveConfigurationFile();
				}
			});
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
			jMenuItem_Exit.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ExitGconfig();
				}
			});
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
			jLabel_Status = new JLabel();
			jLabel_Status.setText("   No gconfig file loaded!");
			jLabel_Status.setFont(new Font("Dialog", Font.PLAIN, 12));
			jLabel_Status.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
			jLabel_Status.setBackground(Color.white);
			jPanel_InfoBar = new JPanel();
			jPanel_InfoBar.setBackground(Color.white);
			jPanel_InfoBar.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
			jPanel_InfoBar.setLayout(gridLayout);
			jPanel_InfoBar.setPreferredSize(new Dimension(0, 24));
			jPanel_InfoBar.add(jLabel_Status, null);
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
			jLabel18 = new JLabel();
			jLabel18.setBounds(new Rectangle(0, 225, 151, 16));
			jLabel18.setText("Testing configuration:");
			jLabel5 = new JLabel();
			jLabel5.setBounds(new Rectangle(0, 65, 136, 16));
			jLabel5.setText("Configuration steps:");
			jLabel_LeftHeader = new JLabel();
			jLabel_LeftHeader.setText("Navigation:");
			jLabel_LeftHeader.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
			jLabel_LeftHeader.setBounds(new Rectangle(0, 0, 131, 19));
			jLabel_LeftHeader.setName("jLabel_LeftHeader");
			jPanel_Left = new JPanel();
			jPanel_Left.setLayout(null);
			jPanel_Left.add(jLabel_LeftHeader, null);
			jPanel_Left.add(getJButton_Home(), null);
			jPanel_Left.add(jLabel5, null);
			jPanel_Left.add(getJButton_Run(), null);
			jPanel_Left.add(getJButton_InputFiles(), null);
			jPanel_Left.add(getJButton_Overview(), null);
			jPanel_Left.add(jLabel18, null);
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
			jPanel_Start.add(getJButton_CreateConfig(), null);
			jPanel_Start.add(getJButton_OpenConfig(), null);
			jPanel_Start.add(getJButton_Exit(), null);
			jPanel_Start.add(jLabel11, null);
		}
		return jPanel_Start;
	}

	/**
	 * This method initializes jButton_CreateConfig	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_CreateConfig() {
		if (jButton_CreateConfig == null) {
			jButton_CreateConfig = new JButton();
			jButton_CreateConfig.setBounds(new Rectangle(30, 80, 223, 38));
			jButton_CreateConfig.setText("Create new configuration");
			jButton_CreateConfig.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					CreateConfigurationFile();
				}
			});
		}
		return jButton_CreateConfig;
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
			jButton_OpenConfig.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					OpenConfigurationFile();
				}
			});
		}
		return jButton_OpenConfig;
	}

	/**
	 * This method initializes jButton_Exit	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_Exit() {
		if (jButton_Exit == null) {
			jButton_Exit = new JButton();
			jButton_Exit.setBounds(new Rectangle(30, 180, 221, 36));
			jButton_Exit.setText("Exit gconfig");
			jButton_Exit.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ExitGconfig();
				}
			});
		}
		return jButton_Exit;
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
			jPanel_ConfigOverview.add(getJButton_SaveConfig(), null);
			jPanel_ConfigOverview.add(jLabel4, null);
			jPanel_ConfigOverview.add(getJTextArea(), null);
			jPanel_ConfigOverview.add(getJButton_StartSetup(), null);
			
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
				jButton_Nav[i].setBounds(new Rectangle(10, 130+i*25, 130, 25));
				jButton_Nav[i].setText(configFile.analysis[i].name);
				jButton_Nav[i].setVisible(true);
				jButton_Nav[i].setEnabled(false);
				jButton_Nav[i].addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						JButton jb = (JButton)e.getSource();
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
			jLabel18.setBounds(new Rectangle(0, 225, 155, 16));
			jButton_InputFiles.setBounds(new Rectangle(10, 180+configFile.analysis.length*25, 130, 25));
			jButton_Run.setBounds(new Rectangle(10, 210+configFile.analysis.length*25, 130, 25));
			jButton_Overview.setBounds(new Rectangle(10, 95, 130, 25));
			
		}
		return jPanel_ConfigOverview;
	}

	/**
	 * This method initializes jButton_SaveConfig	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_SaveConfig() {
		if (jButton_SaveConfig == null) {
			jButton_SaveConfig = new JButton();
			jButton_SaveConfig.setBounds(new Rectangle(45, 330, 136, 31));
			jButton_SaveConfig.setText("Save setup");
			jButton_SaveConfig.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					configFile.saveToFile(configFile.fileName);
				}
			});
		}
		return jButton_SaveConfig;
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
			jTabbedPane.setBounds(new Rectangle(0, 0, 616, 466));
			jTabbedPane.setVisible(true);
			jTabbedPane.addTab(null, null, getJPanel_Start(), null);
			jTabbedPane.addTab(null, null, getJPanel_ConfigOverview(), null);
			jTabbedPane.addTab(null, null, getJPanel_Analysis(), null);
			jTabbedPane.addTab(null, null, getJPanel_Run(), null);
			jTabbedPane.addTab(null, null, getJPanel_InputFiles(), null);
		}
		return jTabbedPane;
	}

	/**
	 * This method initializes jButton_Home	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_Home() {
		if (jButton_Home == null) {
			jButton_Home = new JButton();
			jButton_Home.setBounds(new Rectangle(15, 30, 121, 25));
			jButton_Home.setText("Home");
			jButton_Home.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jTabbedPane.setSelectedIndex(0);
				}
			});
		}
		return jButton_Home;
	}

	/**
	 * This method initializes jPanel_Analysis	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_Analysis() {
		if (jPanel_Analysis == null) {
			jLabel8 = new JLabel();
			jLabel8.setBounds(new Rectangle(15, 45, 512, 19));
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
			jPanel_Analysis.add(getJButton_Next(), null);
			jPanel_Analysis.add(getJButton_Prev(), null);
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
			jLabel7.setBounds(new Rectangle(30, 220, 125, 16));
			jLabel7.setText("Result output:");
			jLabel6 = new JLabel();
			jLabel6.setBounds(new Rectangle(30, 55, 195, 16));
			jLabel6.setText("Current command line:");
			jLabel111 = new JLabel();
			jLabel111.setFont(new Font("Dialog", Font.BOLD, 18));
			jLabel111.setBounds(new Rectangle(15, 15, 316, 31));
			jLabel111.setText("Run and show command line");
			jPanel_Run = new JPanel();
			jPanel_Run.setLayout(null);
			jPanel_Run.add(jLabel111, null);
			jPanel_Run.add(jLabel6, null);
			jPanel_Run.add(getJTextArea_Cmdline(), null);
			jPanel_Run.add(getJButton12(), null);
			jPanel_Run.add(jLabel7, null);
			jPanel_Run.add(getJTextArea_ResultOutput(), null);
			jPanel_Run.add(getJButton7(), null);
			jPanel_Run.add(getJButton8(), null);
		}
		return jPanel_Run;
	}

	/**
	 * This method initializes jTextArea_Cmdline	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea_Cmdline() {
		if (jTextArea_Cmdline == null) {
			jTextArea_Cmdline = new JTextArea();
			jTextArea_Cmdline.setBounds(new Rectangle(30, 75, 496, 80));
			jTextArea_Cmdline.setEditable(false);
			jTextArea_Cmdline.setWrapStyleWord(false);
			jTextArea_Cmdline.setLineWrap(true);
			jTextArea_Cmdline.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		}
		return jTextArea_Cmdline;
	}

	/**
	 * This method initializes jButton12	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton12() {
		if (jButton12 == null) {
			jButton12 = new JButton();
			jButton12.setBounds(new Rectangle(30, 165, 196, 31));
			jButton12.setText("Run");
			jButton12.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					RunGoblintCmdLine();
				}
			});
		}
		return jButton12;
	}

	/**
	 * This method initializes jTextArea_ResultOutput	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea_ResultOutput() {
		if (jTextArea_ResultOutput == null) {
			jTextArea_ResultOutput = new JTextArea();
			jTextArea_ResultOutput.setBounds(new Rectangle(30, 240, 496, 95));
			jTextArea_ResultOutput.setEditable(false);
			jTextArea_ResultOutput.setBorder(BorderFactory.createLineBorder(Color.gray,1));
		}
		return jTextArea_ResultOutput;
	}

	/**
	 * This method initializes jTabbedPane1	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getJTabbedPane1() {
		if (jTabbedPane1 == null) {
			jTabbedPane1 = new JTabbedPane();
			jTabbedPane1.setBounds(new Rectangle(15, 95, 511, 266));
			jTabbedPane1.addTab("Options", null, getJPanel_Options(), null);
			jTabbedPane1.addTab("Input", null, getJPanel_Input(), null);
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
			jLabel_InputDescription2 = new JLabel();
			jLabel_InputDescription2.setBounds(new Rectangle(30, 145, 451, 16));
			jLabel_InputDescription2.setText("JLabel");
			jLabel_InputCaption2 = new JLabel();
			jLabel_InputCaption2.setBounds(new Rectangle(30, 100, 450, 16));
			jLabel_InputCaption2.setText("JLabel");
			jLabel_InputDescription1 = new JLabel();
			jLabel_InputDescription1.setBounds(new Rectangle(30, 60, 451, 16));
			jLabel_InputDescription1.setText("JLabel");
			jLabel_InputCaption1 = new JLabel();
			jLabel_InputCaption1.setBounds(new Rectangle(30, 15, 451, 16));
			jLabel_InputCaption1.setText("JLabel");
			jPanel_Input = new JPanel();
			jPanel_Input.setLayout(null);
			jPanel_Input.add(getJTextField_Input1(), null);
			jPanel_Input.add(jLabel_InputCaption1, null);
			jPanel_Input.add(jLabel_InputDescription1, null);
			jPanel_Input.add(jLabel_InputCaption2, null);
			jPanel_Input.add(getJTextField_Input2(), null);
			jPanel_Input.add(jLabel_InputDescription2, null);
			jPanel_Input.add(getJButton_InputFind1(), null);
			jPanel_Input.add(getJButton_InputFind2(), null);
		}
		return jPanel_Input;
	}

	/**
	 * This method initializes jPanel_Options	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_Options() {
		if (jPanel_Options == null) {
			jLabel15 = new JLabel();
			jLabel15.setBounds(new Rectangle(30, 86, 114, 17));
			jLabel15.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
			jLabel15.setText("Arguments:");
			jLabel_IntervalDomain = new JLabel();
			jLabel_IntervalDomain.setBounds(new Rectangle(30, 118, 115, 16));
			jLabel_IntervalDomain.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
			jLabel_IntervalDomain.setEnabled(true);
			jLabel_IntervalDomain.setText("IntervalDomain:");
			jLabel12 = new JLabel();
			jLabel12.setBounds(new Rectangle(30, 178, 88, 16));
			jLabel12.setText("Solver:");
			jLabel10 = new JLabel();
			jLabel10.setBounds(new Rectangle(30, 60, 112, 16));
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
			jPanel_Options.add(jLabel15, null);
			jPanel_Options.add(getJTextField_Arguments(), null);
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
			jCheckBox_ContextSen.setBounds(new Rectangle(26, 14, 167, 16));
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
			jCheckBox_PathSen.setBounds(new Rectangle(26, 34, 166, 16));
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
			jCheckBox_Trier.setBounds(new Rectangle(149, 118, 91, 16));
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
			jCheckBox_Interval.setBounds(new Rectangle(149, 138, 91, 16));
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
			jTextField_Preprocessing.setBounds(new Rectangle(146, 59, 300, 20));
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
			jComboBox_Solver.setBounds(new Rectangle(149, 178, 166, 16));
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
			jLabel_MessagesFormatInfo.setBounds(new Rectangle(135, 190, 317, 16));
			jLabel_MessagesFormatInfo.setText("Message format string info");
			jLabel17 = new JLabel();
			jLabel17.setBounds(new Rectangle(47, 167, 81, 16));
			jLabel17.setText("Messages:");
			jLabel_WarningsFormatInfo = new JLabel();
			jLabel_WarningsFormatInfo.setBounds(new Rectangle(136, 131, 317, 16));
			jLabel_WarningsFormatInfo.setText("Warning format string info");
			jLabel16 = new JLabel();
			jLabel16.setBounds(new Rectangle(46, 104, 81, 16));
			jLabel16.setText("Warnings:");
			jLabel_ErrorsFormatInfo = new JLabel();
			jLabel_ErrorsFormatInfo.setBounds(new Rectangle(135, 70, 317, 16));
			jLabel_ErrorsFormatInfo.setText("Error format string info");
			jLabel14 = new JLabel();
			jLabel14.setBounds(new Rectangle(46, 44, 81, 16));
			jLabel14.setText("Errors:");
			jLabel13 = new JLabel();
			jLabel13.setText("Result format strings:");
			jLabel13.setBounds(new Rectangle(15, 15, 155, 16));
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
			jMenuItem_Settings.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ShowSettingsDialog();
				}
			});
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
	
	/**
	 * This method initializes jTextField_Arguments	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_Arguments() {
		if (jTextField_Arguments == null) {
			jTextField_Arguments = new JTextField();
			jTextField_Arguments.setBounds(new Rectangle(146, 85, 300, 20));
			jTextField_Arguments.addCaretListener(new javax.swing.event.CaretListener() {
				public void caretUpdate(javax.swing.event.CaretEvent e) {
					JTextField jtf = (JTextField)e.getSource();
					selectedAnalysis.arguments = jtf.getText();
				}
			});
		}
		return jTextField_Arguments;
	}
	
	/**
	 * This method initializes jButton_Next	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_Next() {
		if (jButton_Next == null) {
			jButton_Next = new JButton();
			jButton_Next.setBounds(new Rectangle(410, 370, 115, 25));
			jButton_Next.setText("Next");
			jButton_Next.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					// Goto next
					boolean isLast = true;
					for (int i = selectedAnalysis.id+1; i < configFile.analysis.length; i++) {
						if (configFile.analysis[i].selected) {
							updateAnalysisPage(i);
							isLast = false;
							break;
						}
					}
					if (isLast) {
						jTabbedPane.setSelectedIndex(1);
					}
				}
			});
		}
		return jButton_Next;
	}

	/**
	 * This method initializes jButton_Prev	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_Prev() {
		if (jButton_Prev == null) {
			jButton_Prev = new JButton();
			jButton_Prev.setBounds(new Rectangle(15, 370, 115, 25));
			jButton_Prev.setText("Previous");
			jButton_Prev.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					// Goto previous
					for (int i = selectedAnalysis.id-1; i >= 0; i--) {
						if (configFile.analysis[i].selected) {
							updateAnalysisPage(i);
							break;
						}
					}
				}
			});
		}
		return jButton_Prev;
	}

	/**
	 * This method initializes jButton_Run	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_Run() {
		if (jButton_Run == null) {
			jButton_Run = new JButton();
			jButton_Run.setBounds(new Rectangle(10, 336, 119, 30));
			jButton_Run.setEnabled(false);
			jButton_Run.setText("Run");
			jButton_Run.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jTextArea_Cmdline.setText(configFile.createCommandLine());
					jTabbedPane.setSelectedIndex(3);
				}
			});
		}
		return jButton_Run;
	}

	/**
	 * This method initializes jButton7	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton7() {
		if (jButton7 == null) {
			jButton7 = new JButton();
			jButton7.setBounds(new Rectangle(435, 165, 91, 31));
			jButton7.setText("Copy");
			jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					// ToDo : Copy to clipboard
				}
			});
		}
		return jButton7;
	}

	/**
	 * This method initializes jButton8	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton8() {
		if (jButton8 == null) {
			jButton8 = new JButton();
			jButton8.setBounds(new Rectangle(435, 345, 91, 31));
			jButton8.setText("Copy");
			jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					// ToDo : Copy to clipboard
				}
			});
		}
		return jButton8;
	}
	
	/**
	 * This method initializes jButton_InputFiles	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_InputFiles() {
		if (jButton_InputFiles == null) {
			jButton_InputFiles = new JButton();
			jButton_InputFiles.setBounds(new Rectangle(12, 296, 130, 28));
			jButton_InputFiles.setEnabled(false);
			jButton_InputFiles.setText("Select input");
			jButton_InputFiles.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jTabbedPane.setSelectedIndex(4);
				}
			});
		}
		return jButton_InputFiles;
	}

	/**
	 * This method initializes jPanel_InputFiles	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_InputFiles() {
		if (jPanel_InputFiles == null) {
			jLabel19 = new JLabel();
			jLabel19.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
			jLabel19.setBounds(new Rectangle(15, 15, 134, 16));
			jLabel19.setText("Goblint arguments:");
			jLabel9 = new JLabel();
			jLabel9.setText("Source files:");
			jLabel9.setBounds(new Rectangle(15, 15, 106, 16));
			jLabel = new JLabel();
			jLabel.setText("Select input for testing");
			jLabel.setFont(new Font("Dialog", Font.BOLD, 18));
			jLabel.setBounds(new Rectangle(15, 15, 361, 31));
			jPanel_InputFiles = new JPanel();
			jPanel_InputFiles.setLayout(null);
			jPanel_InputFiles.add(jLabel, null);
			jPanel_InputFiles.add(getJButton_GotoRun(), null);
			jPanel_InputFiles.add(getJTabbedPane_Input(), null);
		}
		return jPanel_InputFiles;
	}

	/**
	 * This method initializes jList_InputFiles	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJList_InputFiles() {
		if (jList_InputFiles == null) {
			jList_InputFiles = new JList();
			jList_InputFiles.setModel(new DefaultListModel());
			jList_InputFiles.setBounds(new Rectangle(15, 35, 511, 236));
			jList_InputFiles.setBorder(BorderFactory.createLineBorder(Color.black));
		}
		return jList_InputFiles;
	}

	/**
	 * This method initializes jButton_AddFile	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_AddFile() {
		if (jButton_AddFile == null) {
			jButton_AddFile = new JButton();
			jButton_AddFile.setText("Add file");
			jButton_AddFile.setBounds(new Rectangle(15, 275, 136, 25));
			jButton_AddFile.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					DefaultListModel listModel = (DefaultListModel)jList_InputFiles.getModel();
					
					// Select file to add
					JFileChooser fc = new JFileChooser();
					if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
						File selectedFile = fc.getSelectedFile();
						if (selectedFile != null) {
							listModel.addElement(selectedFile.getAbsolutePath());
						}
					}
					
					UpdateInputFileListFromJList();
				}
			});
		}
		return jButton_AddFile;
	}

	/**
	 * This method initializes jButton_DeleteFile	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_DeleteFile() {
		if (jButton_DeleteFile == null) {
			jButton_DeleteFile = new JButton();
			jButton_DeleteFile.setText("Delete selected");
			jButton_DeleteFile.setBounds(new Rectangle(390, 275, 136, 25));
		}
		return jButton_DeleteFile;
	}

	/**
	 * This method initializes jButton_Overview	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_Overview() {
		if (jButton_Overview == null) {
			jButton_Overview = new JButton();
			jButton_Overview.setBounds(new Rectangle(15, 90, 119, 25));
			jButton_Overview.setEnabled(false);
			jButton_Overview.setText("Overview");
			jButton_Overview.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jTabbedPane.setSelectedIndex(1);
				}
			});
		}
		return jButton_Overview;
	}

	/**
	 * This method initializes jTextField_Input1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_Input1() {
		if (jTextField_Input1 == null) {
			jTextField_Input1 = new JTextField();
			jTextField_Input1.setBounds(new Rectangle(30, 35, 383, 20));
			jTextField_Input1.addCaretListener(new javax.swing.event.CaretListener() {
				public void caretUpdate(javax.swing.event.CaretEvent e) {
					selectedAnalysis.input[0].value = ((JTextField)e.getSource()).getText();
				}
			});
		}
		return jTextField_Input1;
	}

	/**
	 * This method initializes jTextField_Input2	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_Input2() {
		if (jTextField_Input2 == null) {
			jTextField_Input2 = new JTextField();
			jTextField_Input2.setBounds(new Rectangle(30, 120, 383, 20));
			jTextField_Input2.addCaretListener(new javax.swing.event.CaretListener() {
				public void caretUpdate(javax.swing.event.CaretEvent e) {
					selectedAnalysis.input[1].value = ((JTextField)e.getSource()).getText();
				}
			});
		}
		return jTextField_Input2;
	}

	/**
	 * This method initializes jButton_InputFind1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_InputFind1() {
		if (jButton_InputFind1 == null) {
			jButton_InputFind1 = new JButton();
			jButton_InputFind1.setBounds(new Rectangle(420, 34, 61, 20));
			jButton_InputFind1.setText("Find");
			jButton_InputFind1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JFileChooser fc = new JFileChooser();
					if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
						File selectedFile = fc.getSelectedFile();
						if (selectedFile != null) {
							jTextField_Input1.setText(selectedFile.getAbsolutePath());
						}
					}
				}
			});
		}
		return jButton_InputFind1;
	}

	/**
	 * This method initializes jButton_InputFind2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_InputFind2() {
		if (jButton_InputFind2 == null) {
			jButton_InputFind2 = new JButton();
			jButton_InputFind2.setBounds(new Rectangle(420, 120, 61, 20));
			jButton_InputFind2.setText("Find");
			jButton_InputFind2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JFileChooser fc = new JFileChooser();
					if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
						File selectedFile = fc.getSelectedFile();
						if (selectedFile != null) {
							jTextField_Input2.setText(selectedFile.getAbsolutePath());
						}
					}
				}
			});
		}
		return jButton_InputFind2;
	}
	
	/**
	 * This method initializes jButton_StartSetup	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_StartSetup() {
		if (jButton_StartSetup == null) {
			jButton_StartSetup = new JButton();
			jButton_StartSetup.setBounds(new Rectangle(195, 330, 136, 31));
			jButton_StartSetup.setText("Start setup");
			jButton_StartSetup.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					for (int i = 0; i < configFile.analysis.length; i++) {
						if (configFile.analysis[i].selected) {
							jTabbedPane.setSelectedIndex(2);
							updateAnalysisPage(i);
							break;
						}
					}
					
				}
			});
		}
		return jButton_StartSetup;
	}

	/**
	 * This method initializes jTextField_GoblintOptions	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_GoblintOptions() {
		if (jTextField_GoblintOptions == null) {
			jTextField_GoblintOptions = new JTextField();
			jTextField_GoblintOptions.setBounds(new Rectangle(15, 35, 511, 20));
			jTextField_GoblintOptions
					.addCaretListener(new javax.swing.event.CaretListener() {
						public void caretUpdate(javax.swing.event.CaretEvent e) {
							configFile.goblintOptions = ((JTextField)(e.getSource())).getText();
						}
					});
		}
		return jTextField_GoblintOptions;
	}

	/**
	 * This method initializes jButton_GotoRun	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_GotoRun() {
		if (jButton_GotoRun == null) {
			jButton_GotoRun = new JButton();
			jButton_GotoRun.setBounds(new Rectangle(435, 405, 136, 25));
			jButton_GotoRun.setText("Show and run");
			jButton_GotoRun.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jTextArea_Cmdline.setText(configFile.createCommandLine());
					jTabbedPane.setSelectedIndex(3);
				}
			});
		}
		return jButton_GotoRun;
	}
	
	void CreateConfigurationFile()
	{
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new File(settings.workingDir));
		if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fc.getSelectedFile();
			if (selectedFile != null) {
				// Create configuration file
				if (configFile.createNew(selectedFile.getAbsolutePath())) {
					updateNavBar();
					jTabbedPane.setSelectedIndex(1);
					UpdateStatusbar();
				}
			}
		}
	}
	
	void OpenConfigurationFile()
	{
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new File(settings.workingDir));
		if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fc.getSelectedFile();
			if (selectedFile != null) {
				// Open configuration file
				if (configFile.openFromFile(selectedFile.getAbsolutePath())) {
					// Show configuration overview					
					jTabbedPane.setSelectedIndex(1);
					updateNavBar();
					UpdateStatusbar();
				}
			}
		}
	}
	
	void SaveConfigurationFile()
	{
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new File(settings.workingDir));
		if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fc.getSelectedFile();
			if (selectedFile != null) {
				// Save configuration file
				configFile.saveToFile(selectedFile.getAbsolutePath());
				UpdateStatusbar();
			}
		}
	}
	
	void ExitGconfig()
	{
		System.exit(0);
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
		
		if (configFile.fileName == "") {
			jButton_Overview.setEnabled(false);
			jButton_InputFiles.setEnabled(false);
			jButton_Run.setEnabled(false);
		}
		else {
			jButton_Overview.setEnabled(true);
			jButton_InputFiles.setEnabled(true);
			jButton_Run.setEnabled(true);
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
		
		// Arguments
		jTextField_Arguments.setText(selectedAnalysis.arguments);
		
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
		
		// Input panel (1)
		if (selectedAnalysis.input.length == 0) {
			jLabel_InputCaption1.setText("No special input is required!");
			jTextField_Input1.setVisible(false);
			jLabel_InputDescription1.setVisible(false);
			jButton_InputFind1.setVisible(false);
		}
		else {
			jLabel_InputCaption1.setText(selectedAnalysis.input[0].caption);
			jTextField_Input1.setText(selectedAnalysis.input[0].value);
			jLabel_InputDescription1.setText(selectedAnalysis.input[0].description);
			jTextField_Input1.setVisible(true);
			jLabel_InputDescription1.setVisible(true);
			jButton_InputFind1.setVisible(selectedAnalysis.input[0].type.equals("file"));
		}
		
		// Input panel (2)
		if (selectedAnalysis.input.length <= 1) {
			jLabel_InputCaption2.setVisible(false);
			jTextField_Input2.setVisible(false);
			jLabel_InputDescription2.setVisible(false);
			jButton_InputFind2.setVisible(false);
		}
		else {
			jLabel_InputCaption2.setText(selectedAnalysis.input[1].caption);
			jTextField_Input2.setText(selectedAnalysis.input[1].value);
			jLabel_InputDescription2.setText(selectedAnalysis.input[1].description);
			jLabel_InputCaption2.setVisible(true);
			jTextField_Input2.setVisible(true);
			jLabel_InputDescription2.setVisible(true);
			jButton_InputFind2.setVisible(selectedAnalysis.input[1].type.equals("file"));
		}
		
		
		// Set previous button
		boolean isFirst = true;
		for (int i = selectId-1; i >= 0; i--) {
			if (configFile.analysis[i].selected) isFirst = false;
		}
		jButton_Prev.setEnabled(!isFirst);
		
		// Set next button
		boolean isLast = true;
		for (int i = selectId+1; i < configFile.analysis.length; i++) {
			if (configFile.analysis[i].selected) isLast = false;
		}
		if (isLast) jButton_Next.setText("Finish");
		else jButton_Next.setText("Next");
	}
	
	void UpdateStatusbar()
	{
		if (configFile.fileName.equals("")) {
			jLabel_Status.setText("   No file loaded!");
		}
		else {
			jLabel_Status.setText("   File loaded: "+configFile.fileName);
		}
	}
	
	void UpdateInputFileListFromJList()
	{
		DefaultListModel listModel = (DefaultListModel)jList_InputFiles.getModel();
		configFile.inputFiles.clear();
		for (int i = 0; i < listModel.getSize(); i++) {
			configFile.inputFiles.add(listModel.get(i));
		}	
	}
	
	static void ShowSettingsDialog()
	{
		gconfig.settingsWindow.jTextField_GoblintPath.setText(settings.goblintPath);
		gconfig.settingsWindow.jCheckBox_ShowDialog.setSelected(settings.showSettingsDialog);
		
		gconfig.mainWindow.setEnabled(false);
		gconfig.settingsWindow.setVisible(true);
	}
	
	void RunGoblintCmdLine()
	{
		try {				
			Process process = Runtime.getRuntime().exec(configFile.createCommandLine());
			InputStreamReader r = new InputStreamReader(process.getInputStream());
			char buffer[] = new char[256];		

			while (true) {
				for (int i = 0; i < buffer.length; i++) buffer[i] = 0;
				if (r.read(buffer, 0, buffer.length) == -1) break;
				jTextArea_ResultOutput.setText(jTextArea_ResultOutput.getText()+(new String(buffer)));
			}
		}
		catch (java.io.IOException e) {
		}
	}

	/**
	 * This method initializes jTabbedPane_Input	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getJTabbedPane_Input() {
		if (jTabbedPane_Input == null) {
			jTabbedPane_Input = new JTabbedPane();
			jTabbedPane_Input.setBounds(new Rectangle(15, 48, 556, 343));
			jTabbedPane_Input.addTab("Source files", null, getJPanel_SourceFiles(), null);
			jTabbedPane_Input.addTab("Other", null, getJPanel_OtherOptions(), null);
		}
		return jTabbedPane_Input;
	}

	/**
	 * This method initializes jPanel_SourceFiles	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_SourceFiles() {
		if (jPanel_SourceFiles == null) {
			jPanel_SourceFiles = new JPanel();
			jPanel_SourceFiles.setLayout(null);
			jPanel_SourceFiles.add(jLabel9, null);
			jPanel_SourceFiles.add(getJList_InputFiles(), null);
			jPanel_SourceFiles.add(getJButton_AddFile(), null);
			jPanel_SourceFiles.add(getJButton_DeleteFile(), null);
		}
		return jPanel_SourceFiles;
	}

	/**
	 * This method initializes jPanel_OtherOptions	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_OtherOptions() {
		if (jPanel_OtherOptions == null) {
			jPanel_OtherOptions = new JPanel();
			jPanel_OtherOptions.setLayout(null);
			jPanel_OtherOptions.add(getJTextField_GoblintOptions(), null);
			jPanel_OtherOptions.add(jLabel19, null);
		}
		return jPanel_OtherOptions;
	}
	
}  //  @jve:decl-index=0:visual-constraint="10,10"

