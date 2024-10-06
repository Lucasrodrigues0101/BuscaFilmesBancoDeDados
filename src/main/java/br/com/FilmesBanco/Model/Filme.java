package br.com.FilmesBanco.Model;

public class Filme {
    private int idFilme;           // ID_FILME no banco de dados
    private String title;          // TITLE
    private String year;           // YEAR
    private String rated;          // RATED
    private String released;       // RELEASED (armazenado como String no formato de data)
    private String runtime;        // RUNTIME
    private String genre;          // GENRE
    private String director;       // DIRECTOR
    private String writer;         // WRITER
    private String actors;         // ACTORS
    private String plot;           // PLOT
    private String language;       // LANGUAGE
    private String country;        // COUNTRY
    private String awards;         // AWARDS
    private String poster;         // POSTER (URL da imagem)
    private int metascore;         // METASCORE (número)
    private String imdbRating;     // IMDB_RATING (número como String)
    private String imdbVotes;      // IMDB_VOTES (votos como String)
    private String imdbID;         // IMDB_ID (ID do IMDb)
    private String type;           // TYPE (tipo de mídia)
    private String dvd;            // DVD (lançamento em DVD)
    private String boxOffice;      // BOXOFFICE (receita de bilheteria)
    private String production;     // PRODUCTION (produtora)
    private String website;        // WEBSITE (site oficial)
    private String response;       // RESPONSE (resposta, True ou False)

    // Construtor vazio (obrigatório para frameworks de persistência)
    public Filme() {}

    // Construtor com todos os parâmetros
    public Filme(int idFilme, String title, String year, String rated, String released, String runtime, String genre,
                 String director, String writer, String actors, String plot, String language, String country,
                 String awards, String poster, int metascore, String imdbRating, String imdbVotes, String imdbID,
                 String type, String dvd, String boxOffice, String production, String website, String response) {
        this.idFilme = idFilme;
        this.title = title;
        this.year = year;
        this.rated = rated;
        this.released = released;
        this.runtime = runtime;
        this.genre = genre;
        this.director = director;
        this.writer = writer;
        this.actors = actors;
        this.plot = plot;
        this.language = language;
        this.country = country;
        this.awards = awards;
        this.poster = poster;
        this.metascore = metascore;
        this.imdbRating = imdbRating;
        this.imdbVotes = imdbVotes;
        this.imdbID = imdbID;
        this.type = type;
        this.dvd = dvd;
        this.boxOffice = boxOffice;
        this.production = production;
        this.website = website;
        this.response = response;
    }

    // Getters e Setters para cada atributo
    public int getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public int getMetascore() {
        return metascore;
    }

    public void setMetascore(int metascore) {
        this.metascore = metascore;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDvd() {
        return dvd;
    }

    public void setDvd(String dvd) {
        this.dvd = dvd;
    }

    public String getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(String boxOffice) {
        this.boxOffice = boxOffice;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}

