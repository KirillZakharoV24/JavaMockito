package org.example;

public class MovieManager {

    private int limit = 10;

    private MovieRep[] movies = new MovieRep[0];

    public MovieManager() {

    }

    public MovieManager(int limit) {
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }

    public MovieRep[] findAll() {
        return movies;
    }

    public void save(MovieRep movie) {
        MovieRep[] tmp = new MovieRep[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];

        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    public MovieRep[] findLast() {
        // Вычисляем размер массива
        int resultLength = Math.min(movies.length, limit);
        MovieRep[] result = new MovieRep[resultLength];

        //Заполняем массив
        for (int i = 0; i < resultLength; i++) {
            result[i] = movies[movies.length - 1 - i];
        }
        return result;
    }

}
