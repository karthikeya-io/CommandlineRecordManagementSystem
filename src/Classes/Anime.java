package Classes;

public class Anime {
    private int id;
    private String name;
    private String language;
    private String genre;
    private int year;
    private String type;
    private double rating;
    private String productionCompany;

    public Anime() {
    }

    public Anime(int id, String name, String language, String genre, int year, String type, double rating,
            String productionCompany) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.genre = genre;
        this.year = year;
        this.type = type;
        this.rating = rating;
        this.productionCompany = productionCompany;
    }

    public Anime(String Line) {
        String values[] = Line.split(",");
        this.id = Integer.valueOf(values[0]);
        this.name = values[1];
        this.language = values[2];
        this.genre = values[3];
        this.year = Integer.valueOf(values[4]);
        this.type = values[5];
        this.rating = Double.valueOf(values[6]);
        this.productionCompany = values[7];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getProductionCompany() {
        return productionCompany;
    }

    public void setProductionCompany(String productionCompany) {
        this.productionCompany = productionCompany;
    }

    @Override
    public String toString() {
        return String.format("%5s%35s%10s%10s%10s%10s%10s%20s", id, name, genre, language, rating, type, year,
                productionCompany);
    }

}
