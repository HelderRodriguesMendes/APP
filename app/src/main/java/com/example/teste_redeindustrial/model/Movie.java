package com.example.teste_redeindustrial.model;

import java.util.List;


public class Movie {
    private String title;
    private Integer year;
    private String Rated;
    private String Released;
    private String Runtime;
    private String Genre;
    private String Director;
    private String Writer;
    private String Actors;
    private String Plot;
    private String Language;
    private String Country;
    private String Awards;
    private String Poster;
    private List<Ratings> ratings;
    private Integer Metascore;
    private Double imdbRating;
    private Double imdbVotes;
    private String imdbID;
    private String Type;
    private String DVD;
    private String BoxOffice;
    private String Production;
    private String Website;
    private boolean Response;

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getRated() {
        return Rated;
    }

    public String getReleased() {
        return Released;
    }

    public String getRuntime() {
        return Runtime;
    }

    public String getGenre() {
        return Genre;
    }

    public String getDirector() {
        return Director;
    }

    public String getWriter() {
        return Writer;
    }

    public String getActors() {
        return Actors;
    }

    public String getPlot() {
        return Plot;
    }

    public String getLanguage() {
        return Language;
    }

    public String getCountry() {
        return Country;
    }

    public String getAwards() {
        return Awards;
    }

    public String getPoster() {
        return Poster;
    }

    public List<Ratings> getRatings() {
        return ratings;
    }

    public Integer getMetascore() {
        return Metascore;
    }

    public Double getImdbRating() {
        return imdbRating;
    }

    public Double getImdbVotes() {
        return imdbVotes;
    }

    public String getImdbID() {
        return imdbID;
    }

    public String getType() {
        return Type;
    }

    public String getDVD() {
        return DVD;
    }

    public String getBoxOffice() {
        return BoxOffice;
    }

    public String getProduction() {
        return Production;
    }

    public String getWebsite() {
        return Website;
    }

    public boolean isResponse() {
        return Response;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setRated(String rated) {
        Rated = rated;
    }

    public void setReleased(String released) {
        Released = released;
    }

    public void setRuntime(String runtime) {
        Runtime = runtime;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public void setWriter(String writer) {
        Writer = writer;
    }

    public void setActors(String actors) {
        Actors = actors;
    }

    public void setPlot(String plot) {
        Plot = plot;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setAwards(String awards) {
        Awards = awards;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    public void setRatings(List<Ratings> ratings) {
        this.ratings = ratings;
    }

    public void setMetascore(Integer metascore) {
        Metascore = metascore;
    }

    public void setImdbRating(Double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public void setImdbVotes(Double imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public void setType(String type) {
        Type = type;
    }

    public void setDVD(String DVD) {
        this.DVD = DVD;
    }

    public void setBoxOffice(String boxOffice) {
        BoxOffice = boxOffice;
    }

    public void setProduction(String production) {
        Production = production;
    }

    public void setWebsite(String website) {
        Website = website;
    }

    public void setResponse(boolean response) {
        Response = response;
    }
}
