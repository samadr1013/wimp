package com.el.ally.wimp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.el.ally.wimp.models.Actor;
import com.el.ally.wimp.models.Movie;
import com.el.ally.wimp.repositories.ActorRepository;
import com.el.ally.wimp.repositories.MovieRepository;


@RestController
@RequestMapping("/api/movie")

public class MovieApiController {
@Autowired
  private MovieRepository movierepo;
@Autowired
private ActorRepository actorrepo;

  public MovieApiController(MovieRepository movierepo,ActorRepository actorrepo) {
    this.movierepo = movierepo;
    this.actorrepo = actorrepo;
  }

  @GetMapping("")
  public List<Movie> getAll() {
    return movierepo.findAll();
  }

  @GetMapping("{id}")
  public Movie getOne(@PathVariable int id) {
    return movierepo.findOne(id);
  }

  @PostMapping("")
  public Movie create(@RequestBody Movie Movie) {
    return movierepo.save(Movie);
  }

  @PutMapping("{id}")
  public Movie update(@RequestBody Movie Movie, @PathVariable int id) {
    Movie.setId(id);
    return movierepo.save(Movie);
  }

  @DeleteMapping("{id}")
  public Movie delete(@PathVariable int id) {
    Movie Movie = movierepo.findOne(id);
    movierepo.delete(id);
    return Movie;
  }
  @PostMapping("{movieId}/actors")
	public Movie create(@PathVariable int movieId, @RequestBody int actorId) {
		Movie movie = movierepo.findOne(movieId);
		Actor actor = actorrepo.findOne(actorId);
		movie.getActors().add(actor);
		movierepo.save(movie);
		return movie;
	}
}
