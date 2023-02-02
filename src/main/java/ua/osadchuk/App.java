package ua.osadchuk;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.osadchuk.model.Director;
import ua.osadchuk.model.Movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Director.class).addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            // отримання режесера, і усіх його фільмів
//            Director director = session.get(Director.class, 1);
//            List<Movie> movies = director.getMovies();
//            for (Movie movie : movies) {
//                System.out.println(movie.getName());
//            }

            // отримання любого фільму, а потім його режесера
//            Movie movie = session.get(Movie.class,7);
//            System.out.println(movie.getOwner().getName());

            // додавання фільму до існуйочого режесера
//            Director director = session.get(Director.class, 3);
//            Movie movie = new Movie(director, "The Gentlemen", 2019);
//            director.getMovies().add(movie);
//            session.save(movie);

            // творення нового режесера та фільму і відразу обєднання
//            Director director = new Director("Alfonso Cuarón", 61);
//            Movie movie = new Movie(director, "Harry Potter and the Prisoner of Azkaban", 2004);
//            director.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//            session.save(director);
//            session.save(movie);

            // заміна режесера у інснуючого фільма
//            Director director = session.get(Director.class, 5);
//            Movie movie = session.get(Movie.class, 9);
//            movie.getOwner().getMovies().remove(movie);
//            director.getMovies().add(movie);
//            movie.setOwner(director);

            // видалення фільму у режесера
            Director director = session.get(Director.class, 5);
            Movie movie = session.get(Movie.class, 9);
            session.remove(movie);
            director.getMovies().remove(movie);

            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}
