package ua.osadchuk.model;

import javax.persistence.*;

@Entity
@Table(name = "Movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int movie_id;
    @ManyToOne
    @JoinColumn(name = "director_id", referencedColumnName = "director_id")
    private Director owner;
    @Column(name = "name")
    private String name;
    @Column(name = "year_of_production")
    private int year_of_production;

    public Movie() {
    }

    public Movie(Director owner, String name, int year_of_production) {
        this.owner = owner;
        this.name = name;
        this.year_of_production = year_of_production;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public Director getOwner() {
        return owner;
    }

    public void setOwner(Director owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear_of_production() {
        return year_of_production;
    }

    public void setYear_of_production(int year_of_production) {
        this.year_of_production = year_of_production;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movie_id=" + movie_id +
                ", owner=" + owner +
                ", name='" + name + '\'' +
                ", year_of_production=" + year_of_production +
                '}';
    }
}
