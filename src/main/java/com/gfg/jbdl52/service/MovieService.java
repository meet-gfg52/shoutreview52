package com.gfg.jbdl52.service;

import com.gfg.jbdl52.domain.Movie;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    Logger logger= LoggerFactory.getLogger(MovieService.class);

    @Autowired
    Connection connection;

    PreparedStatement addMovieStatement=null;

    PreparedStatement getAllMovieStatement=null;

    @PostConstruct
    public void createTable() throws SQLException {
        String query="create table if not exists movie (id INT auto_increment primary key, " +
                "title varchar(20) not null," +
                "genre varchar(20)," +
                "rating Double);";
        try(Statement statement=connection.createStatement()){
            statement.execute(query);
        }catch (Exception ex){
            logger.error("error creating table");
        }

        try {
            addMovieStatement=connection.prepareStatement("insert into movie(title,genre,rating) values(?,?,?);");
            getAllMovieStatement=connection.prepareStatement("select * from movie");
        }catch (Exception ex){
            logger.error("exception while preparing add movie statement {}",ex.getMessage());
        }
    }

    public Movie addMovie(Movie movie){

        logger.debug("adding movie to db");
        try{
            addMovieStatement.setString(1, movie.getTitle());
            addMovieStatement.setString(2, movie.getGenre());
            addMovieStatement.setDouble(3,movie.getRating());
            addMovieStatement.execute();
            int status=addMovieStatement.executeUpdate();
            if(status>0)
                return movie;
            return null;
        }catch (Exception e){
            logger.error("exception while adding movie{} ",e.getMessage());
        }
        return null;
    }

    public List<Movie> getAllMovies(){
        try{
            ResultSet resultSet=getAllMovieStatement.executeQuery();
            List<Movie> movies=new ArrayList<>();
            while(resultSet.next()){
                Movie movie=new Movie(resultSet.getInt(1),resultSet.getString("title"),resultSet.getString("genre"),resultSet.getDouble("rating"));
                movies.add(movie);
            }
            return movies;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }


    /***
     * Mysql JDBC connection
     *  3 types of executes
     *  1. execute() -> returns true if created
     *  2. executeUpdate() -> returns if exists 1 or 0
     *  3. executeQuery() -> returns the resultSet;
     *
     * */

}