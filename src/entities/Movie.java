package entities;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Entity class representing the Movie
 *
 * @author Gan Shyan
 */
public class Movie implements Serializable {

    /**
     * UID of serializable class
     */
    static final long serialVersionUID = 4178169745013724048L;

    /**
     * Constant value of a BLOCKBUSTER
     */
    public static final int BLOCKBUSTER = 1;
    /**
     * Constant value of a ROMANTIC
     */
    public static final int ROMANTIC = 2;
    /**
     * Constant value of a COMEDY
     */
    public static final int COMEDY = 3;
    /**
     * Constant value of a CRIME
     */
    public static final int CRIME = 4;
    /**
     * Constant value of a FANTASY
     */
    public static final int FANTASY = 5;
    /**
     * Constant value of a HISTORY
     */
    public static final int HISTORY = 6;
    /**
     * Constant value of a HORROR
     */
    public static final int HORROR = 7;
    /**
     * Constant value of a THREE_D
     */
    public static final int THREE_D = 8;

    /**
     * Constant value of a COMING_SOON movie
     */
    public static final int COMING_SOON = 1;
    /**
     * Constant value of a PREVIEW movie
     */
    public static final int PREVIEW = 2;
    /**
     * Constant value of a NOW_SHOWING movie
     */
    public static final int NOW_SHOWING = 3;
    /**
     * Constant value of a END_OF_SHOWING movie
     */
    public static final int END_OF_SHOWING = -1;

    /**
     * Constant value of a G movie
     */
    public static final int G = 1;
    /**
     * Constant value of a PG movie
     */
    public static final int PG = 2;
    /**
     * Constant value of a NC16 movie
     */
    public static final int NC16 = 3;
    /**
     * Constant value of a M18 movie
     */
    public static final int M18 = 4;
    /**
     * Constant value of a R21 movie
     */
    public static final int R21 = 5;

    /**
     * Title attribute
     */
    private String title;
    /**
     * runTime attribute
     */
    private int runTime;
    /**
     * typeOfMovie attribute
     */
    private int typeOfMovie;
    /**
     * status attribute
     */
    private int status;
    /**
     * synopsis attribute
     */
    private String synopsis;
    /**
     * director attribute
     */
    private String director;
    /**
     * casts list attribute
     */
    private ArrayList<String> casts; //At least 2
    /**
     * reviews attribute
     */
    private Reviews reviews;
    /**
     * censorClassification attribute
     */
    private int censorClassification;
    /**
     * sales attribute
     */
    private int sales; // Number of tickets sold so far for this particular movie

    /**
     * Constructor
     *
     * @param title                Title of movie
     * @param runTime              Runtime in minutes
     * @param typeOfMovie          Movie genre
     * @param status               Status of movie (showing soon, preview etc.)
     * @param synopsis             Synopsis of movie
     * @param director             Director of movie
     * @param casts                List of casts of movie
     * @param censorClassification Censorship classification
     * @param sales                Number of tickets sold for the movie
     */
    public Movie(String title, int runTime, int typeOfMovie, int status, String synopsis, String director,
                 ArrayList<String> casts, int censorClassification, int sales) {
        this.title = title;
        this.runTime = runTime;
        this.typeOfMovie = typeOfMovie;
        this.status = status;
        this.synopsis = synopsis;
        this.director = director;
        this.censorClassification = censorClassification;
        this.casts = casts;
        this.sales = sales;
        this.reviews = new Reviews();
    }

    /**
     * Constructor
     */
    public Movie() {
    }

    /**
     * Constructor
     *
     * @param title Title of movie
     */
    public Movie(String title) {
        this.title = title;
    }

    /**
     * Getter
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter
     *
     * @return run time
     */
    public int getRunTime() {
        return runTime;
    }

    /**
     * Getter
     *
     * @return type of movie
     */
    public int getTypeOfMovie() {
        return typeOfMovie;
    }

    /**
     * Getter
     *
     * @return status
     */
    public int getStatus() {
        return status;
    }

    /**
     * Getter
     *
     * @return Synopsis
     */
    public String getSynopsis() {
        return synopsis;
    }

    /**
     * Getter
     *
     * @return director
     */
    public String getDirector() {
        return director;
    }

    /**
     * Getter
     *
     * @return censor classification
     */
    public int getCensorClassification() {
        return censorClassification;
    }

    /**
     * Getter
     *
     * @return list of casts
     */
    public ArrayList<String> getCasts() {
        return casts;
    }

    /**
     * Getter
     *
     * @return number of tickets sold for this movie
     */
    public int getSales() {
        return sales;
    }

    /**
     * Getter
     *
     * @return Reviews object
     */
    public Reviews getReviews() {
        return reviews;
    }

    /**
     * Setter
     *
     * @param status status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Setter
     *
     * @param sales Number of tickets sold for this movie
     */
    public void setSales(int sales) {
        this.sales = sales;
    }

    /**
     * Add a new cast
     *
     * @param cast New cast
     */
    public void insertCast(String cast) {
        casts.add(cast);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }

    public void setTypeOfMovie(int typeOfMovie) {
        this.typeOfMovie = typeOfMovie;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setCasts(ArrayList<String> casts) {
        this.casts = casts;
    }

    public void setReviews(Reviews reviews) {
        this.reviews = reviews;
    }

    public void setCensorClassification(int censorClassification) {
        this.censorClassification = censorClassification;
    }
}
