package entities;

import java.io.Serializable;

/*
 * Represents a single movie review
 * @author Lakshyajeet Dwivedee
 */
public class Review implements Serializable {

	/**
	 * UID of serializable class
	 */
	static final long serialVersionUID = 4178169745013720000L;

    /*
     * The review of the movie
     */
    private String review;

    /*
     * The rating given to the movie
     * Must be between 1 and 5
     */
    private int rating;

    /*
     * The name of the movie for which this review has been given
     */
    private String movieName;

    /*
     * Creates a new entities.Review with the given review and rating
     * Both review and rating must be given
     * @param review entities.Review of the movie
     * @param rating Rating of the movie
     */
    public Review(String review, int rating, String movieName) {
        this.review = review;
        this.rating = rating;
        this.movieName = movieName;
    }

    /*
     * Return the text of this review
     * @return The review text
     */
    public String getReview() {
        return this.review;
    }

    /*
     * Return the rating given in this review
     * @return The review rating
     */
    public int getRating() {
        return this.rating;
    }

    /*
     * Return the movie for which this review was given
     * @return The movie name
     */
    public String getMovieName() {
        return this.movieName;
    }
}
