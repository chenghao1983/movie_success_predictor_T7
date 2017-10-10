package sg.edu.nus.iss.msp.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


/**
 * 
 * @author CH
 *
 */
public class MainWindow extends JFrame
{
	public MainWindow() {
		this.setTitle("Movie Success Predictor T7");
		this.getContentPane().setLayout(null);
		
		this.setResizable(false);
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setSize(800, 600);
		
		JPanel WelcomePanel = new JPanel();
		WelcomePanel.setBounds(5, 20, 780, 50);
		this.getContentPane().add(WelcomePanel);
		WelcomePanel.setLayout(null);
		
		JLabel Lbl_Welcome = new JLabel("Welcome !");
		Lbl_Welcome.setBounds(331, 11, 71, 17);
		Lbl_Welcome.setFont(new Font("Tahoma", Font.BOLD, 14));
		WelcomePanel.add(Lbl_Welcome);
		
		JPanel OptionPanel = new JPanel();
		OptionPanel.setBounds(5, 110, 780, 250);
		this.getContentPane().add(OptionPanel);
		OptionPanel.setLayout(null);
		
		JButton Btn_CheckData = new JButton("Check Data");
		Btn_CheckData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO
			}
		});
		Btn_CheckData.setBounds(93, 67, 250, 100);
		OptionPanel.add(Btn_CheckData);
		
		JButton Btn_PredictMovie = new JButton("Predict Movie");
		Btn_PredictMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});
		Btn_PredictMovie.setBounds(386, 67, 250, 100);
		OptionPanel.add(Btn_PredictMovie);
		
		JPanel FooterPanel = new JPanel();
		FooterPanel.setBounds(5, 409, 780, 60);
		this.getContentPane().add(FooterPanel);
		FooterPanel.setLayout(null);
		
		JButton Btn_Close = new JButton("Close");
		Btn_Close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});
		Btn_Close.setBounds(313, 11, 110, 36);
		FooterPanel.add(Btn_Close);
		
		
		
		
	}

	
	
	
	
}
