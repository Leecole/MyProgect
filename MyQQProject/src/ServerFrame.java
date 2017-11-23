import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;

public class ServerFrame extends JFrame {
	public ServerFrame() {
		getContentPane().setBackground(Color.PINK);
		
		JButton btnNewButton = new JButton("New button");
		getContentPane().add(btnNewButton, BorderLayout.SOUTH);
	}
}
