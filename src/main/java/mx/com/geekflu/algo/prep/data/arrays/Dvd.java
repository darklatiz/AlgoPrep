package mx.com.geekflu.algo.prep.data.arrays;

public class Dvd {
  private String name;
  private int releaseYear;
  private String director;

  public Dvd(String name, int releaseYear, String director) {
    this.name = name;
    this.releaseYear = releaseYear;
    this.director = director;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getReleaseYear() {
    return releaseYear;
  }

  public void setReleaseYear(int releaseYear) {
    this.releaseYear = releaseYear;
  }

  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  @Override
  public String toString() {
    return "Dvd{" +
      "name='" + name + '\'' +
      ", releaseYear=" + releaseYear +
      ", director='" + director + '\'' +
      '}';
  }
}
