package sg.edu.nus.iss.msp.gui;

import javax.swing.*;
import sg.edu.nus.iss.msp.core.MovieService;
import sg.edu.nus.iss.msp.model.Movie;


public class PredictMovieWindow extends JFrame
{
	private MovieService movieService;
	private Movie[] movies;
	
	public PredictMovieWindow(MovieService movieService) {
		
		this.movieService = movieService;
		this.movies = movieService.getMovies();
		
		initialize();
		
	}
	
	private void initialize()
	{
		//TODO
		
	}
}
