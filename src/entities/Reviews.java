package entities;

import java.io.Serializable;
import java.util.ArrayList;

/*
 * Represents all the reviews and the overall rating of a movie
 * @author Lakshyajeet Dwivedee
 */
public class Reviews implements Comparable, Serializable {

    /**
     * UID of serializable class
     */
    static final long serialVersionUID = 4178169745013720001L;

    /*
     * Implementation of the Comparable class method
     */
    @Override
    public int compareTo(Object o) {
        if (this.averageRating > ((Reviews) o).getAverageRating()) {
            return 1;
        } else if (this.averageRating < ((Reviews) o).getAverageRating()) {
            return -1;
        }
        return 0;
    }

    /*
     * A list of all reviews of the movie
     */
    private ArrayList<Review> reviewList;

    /*
     * The overall rating of the movie
     * Must be between 1 and 5
     * Must have precision of 1 decimal place
     */
    private float averageRating;

    /*
     * Creates a new empty entities.Reviews
     */
    public Reviews() {
        reviewList = new ArrayList<Review>();
        averageRating = 0;
    }

    /*
     * Returns the average rating of these reviews
     * @return Average rating of these reviews
     */
    public float getAverageRating() {
        float total = 0f;
        for (Review review : reviewList) {
            total += review.getRating();
        }
        return total / reviewList.size();
    }

    /*
     * Returns the list of Review objects
     * @return The list of review objects
     */
    public ArrayList<Review> getReviewList() {
        return reviewList;
    }

    /*
     * Adds a new review to the review list and updates the average rating
     * Both review and rating must be specified
     *
     * @param review entities.Review of the movie given by the user
     * @param rating Rating of the movie given by the user
     */
    public void addReview(String review, int rating, String movieName) {
        reviewList.add(new Review(review, rating, movieName));
        averageRating = ((averageRating) * (reviewList.size() - 1) + rating) / reviewList.size();
    }

}