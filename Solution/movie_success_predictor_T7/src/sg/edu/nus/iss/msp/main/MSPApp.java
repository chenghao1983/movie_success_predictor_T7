package sg.edu.nus.iss.msp.main;

import sg.edu.nus.iss.msp.core.MovieService;
import sg.edu.nus.iss.msp.gui.MainWindow;

public class MSPApp {

	public static void main(String[] args) {

		MovieService movieService = new MovieService();
		MainWindow Main = new MainWindow(movieService);
		Main.setVisible(true);
		Main.setLocation(800, 200);
	}
}
