import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class GUIframe {

	public JRadioButton aToZRdoBtn;
	private JFrame frmDictionary;
	private JTextField searchBox;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	JList<String> wordList;
	JScrollPane listScroller;
	@SuppressWarnings("rawtypes")
	List jsonArray;
	String result;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIframe window = new GUIframe(true);
					window.frmDictionary.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIframe(boolean firstRun) {
		initialize(firstRun);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frmDictionary = new JFrame();
		frmDictionary.setTitle("Dictionary");
		frmDictionary.setBounds(100, 100, 686, 535);
		frmDictionary.setLocationRelativeTo(null);
		frmDictionary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// add word button
		JButton addWordBtn = new JButton("Add Word");
		addWordBtn.setBounds(6, 6, 117, 29);
		addWordBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							AddWord window = new AddWord();
							window.addWordFrame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		frmDictionary.getContentPane().setLayout(null);
		addWordBtn.setFocusPainted(false);
		addWordBtn.setFont(new Font("Chalkboard", Font.PLAIN, 13));
		frmDictionary.getContentPane().add(addWordBtn);
	}

}
