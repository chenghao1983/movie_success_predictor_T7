package sg.edu.nus.iss.msp.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.IOException;

import javax.swing.*;
import sg.edu.nus.iss.msp.core.MovieService;
import sg.edu.nus.iss.msp.model.Movie;
import weka.gui.arffviewer.*;

public class MainWindow extends JFrame {

	private MovieService movieService;
	private Movie[] movies;

	private ManageMovieDataWindow manageMovieDataWindow;
	private PredictMovieInputWindow predictMovieInputWindow;

	public MainWindow(MovieService movieService) {
		this.movieService = movieService;
		try {
			initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void initialize() throws IOException {
		this.setTitle("Movie Success Predictor T7");
		this.getContentPane().setLayout(null);

		this.setResizable(false);
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setSize(767, 526);

		JPanel OptionPanel = new JPanel();
		// hide the options button
		OptionPanel.setVisible(false);
		OptionPanel.setBounds(5, 110, 749, 239);
		this.getContentPane().add(OptionPanel);
		OptionPanel.setLayout(null);

		JButton Btn_ManageMovieData = new JButton("View Movie Data");
		Btn_ManageMovieData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManageMovieData();
			}
		});
		Btn_ManageMovieData.setBounds(72, 48, 250, 150);
		OptionPanel.add(Btn_ManageMovieData);

		JButton Btn_PredictNewMovie = new JButton("Predict New Movie");
		Btn_PredictNewMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PredictNewMovie();
			}
		});
		Btn_PredictNewMovie.setBounds(409, 48, 250, 150);
		OptionPanel.add(Btn_PredictNewMovie);

		JPanel FooterPanel = new JPanel();
		// hide the close button
		FooterPanel.setVisible(false);
		FooterPanel.setBounds(5, 374, 749, 95);
		this.getContentPane().add(FooterPanel);
		FooterPanel.setLayout(null);

		JButton Btn_Close = new JButton("Close");
		Btn_Close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				if (manageMovieDataWindow != null) {
					manageMovieDataWindow.dispose();
				}
				if (predictMovieInputWindow != null) {
					if (predictMovieInputWindow.getPredictMovieResultWindow() != null) {
						predictMovieInputWindow.getPredictMovieResultWindow().dispose();
					}
					predictMovieInputWindow.dispose();
				}
			}
		});
		Btn_Close.setBounds(244, 8, 250, 80);
		FooterPanel.add(Btn_Close);

		JLabel Lbl_Welcome = new JLabel("Welcome !");
		Lbl_Welcome.setBounds(318, 35, 131, 17);
		getContentPane().add(Lbl_Welcome);
		Lbl_Welcome.setFont(new Font("Tahoma", Font.BOLD, 14));

		JPanel MenuPanel = new JPanel();
		MenuPanel.setForeground(Color.BLACK);
		MenuPanel.setBackground(Color.WHITE);
		MenuPanel.setBounds(0, 0, 50, 30);
		getContentPane().add(MenuPanel);
		MenuPanel.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 45, 26);
		MenuPanel.add(menuBar);

		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_PredictNewMovie = new JMenuItem("Predict New Movie");
		mntmNewMenuItem_PredictNewMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PredictNewMovie();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_PredictNewMovie);

		JMenuItem mntmNewMenuItem_ViewMovieData = new JMenuItem("View Movie Data");
		mntmNewMenuItem_ViewMovieData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageMovieData();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_ViewMovieData);

		JMenuItem mntmNewMenuItem_Exit = new JMenuItem("Exit");
		mntmNewMenuItem_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				if (manageMovieDataWindow != null) {
					manageMovieDataWindow.dispose();
				}
				if (predictMovieInputWindow != null) {
					if (predictMovieInputWindow.getPredictMovieResultWindow() != null) {
						predictMovieInputWindow.getPredictMovieResultWindow().dispose();
					}
					predictMovieInputWindow.dispose();
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_Exit);

		String imgFolderPath = movieService.getImageFileLocation();
		ImageIcon imgBackGround = new ImageIcon(imgFolderPath + "/dataset-card.png");

		JLabel lblBkimg = new JLabel("");
		lblBkimg.setBounds(0, 0, 761 , 491);
		lblBkimg.setIcon(imgBackGround);
		getContentPane().add(lblBkimg);
	}

	private void ManageMovieData() {
		if (manageMovieDataWindow == null) {
			manageMovieDataWindow = new ManageMovieDataWindow(this, movieService);
			manageMovieDataWindow.setVisible(true);
			manageMovieDataWindow.setLocation(getLocation());
		}
		// ArffViewer arffViewer = new ArffViewer();
		// arffViewer.getComponents();
		// arffViewer.setVisible(true);
		// arffViewer.setLocation(getLocation());

	}

	private void PredictNewMovie() {
		if (predictMovieInputWindow == null) {
			predictMovieInputWindow = new PredictMovieInputWindow(this, movieService);
			predictMovieInputWindow.setVisible(true);
			predictMovieInputWindow.setLocation(getLocation());
		}
	}

	public ManageMovieDataWindow getManageMovieDataWindow() {
		return manageMovieDataWindow;
	}

	public void setManageMovieDataWindow(ManageMovieDataWindow manageMovieDataWindow) {
		this.manageMovieDataWindow = manageMovieDataWindow;
	}

	public PredictMovieInputWindow getPredictMovieInputWindow() {
		return predictMovieInputWindow;
	}

	public void setPredictMovieInputWindow(PredictMovieInputWindow predictMovieInputWindow) {
		this.predictMovieInputWindow = predictMovieInputWindow;
	}
}
