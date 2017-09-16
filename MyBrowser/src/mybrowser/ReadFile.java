package mybrowser;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;


public class ReadFile extends JFrame{
	private static String home = "https://google.com";
	private JTextField addressBar;
	private JEditorPane display;
	
	private JProgressBar loadingBar;
	
	public ReadFile() {
		super("Trung Browser");
		addressBar = new JTextField(home);
		addressBar.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					loadCrap(e.getActionCommand());
				}
			}
		);
		add(addressBar, BorderLayout.NORTH);
		
		display = new JEditorPane();
		display.setEditable(false);
		display.addHyperlinkListener(
			new HyperlinkListener() {
				public void hyperlinkUpdate(HyperlinkEvent e) {
					if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED){
						loadCrap(e.getURL().toString());
					}
				}
			}
		);
//		loadingBar = new JProgressBar();
//		add(loadingBar, BorderLayout.SOUTH);
		add(new JScrollPane(display), BorderLayout.CENTER);
		
		setSize(500, 300);
		setVisible(true);
	}
	
	//load crap to display on the screen
	private void loadCrap(String userText) {
		try {
//			WebView wView = new WebView();
//		    WebEngine wNgine = wView.getEngine();
			display.setPage(userText);
			addressBar.setText(userText);
		} catch (Exception e) {
			System.out.println("crap!!!");
		}
	}
	
	
}
