import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

class Movie{
    private String movieName;
    private String movieGenre;
    private String releaseYear;
    public Movie(String name,String genre,String year){
        this.movieName=name;
        this.movieGenre=genre;
        this.releaseYear=year;
    }
    public void display(){
        System.out.println("Movie Name: "+movieName+" Genre: "+movieGenre+" Release Year: "+releaseYear);
    }
}

interface MovieIterator{
    boolean hasNext();
    Movie next();
}

class MovieCatalogue{
    private List<Movie>movies=new ArrayList<>();
    
    public void addMovie(Movie movie){
        movies.add(movie);
    }
    
    public MovieIterator iterator(){
        return new MovieIteratorConcreteClass(movies);
    }
}

class MovieIteratorConcreteClass implements MovieIterator{
    private List<Movie>movieList;
    private int pointer=0;
    public MovieIteratorConcreteClass(List movies){
        this.movieList=movies;
    }
    public boolean hasNext(){
        return pointer<movieList.size();
    }
    public Movie next(){
        if(!hasNext()) {
            throw new NoSuchElementException("No more movies in the catalogue");
        }
        return movieList.get(pointer++);
    }
}

class Main {
    public static void main(String[] args) {
        MovieCatalogue movieCollection=new MovieCatalogue();
        movieCollection.addMovie(new Movie("Movie1","Drama","2024"));
        movieCollection.addMovie(new Movie("Movie2","Comedy","2025"));
        movieCollection.addMovie(new Movie("Movie3","Horror","2026"));
        MovieIterator iterator=movieCollection.iterator();
        while(iterator.hasNext()){
            Movie movie=iterator.next();
            movie.display();
        }
    }
}
