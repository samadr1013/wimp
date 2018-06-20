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
import com.el.ally.wimp.models.Award;
import com.el.ally.wimp.repositories.ActorRepository;


@RestController
@RequestMapping("/api/actor")
public class ActorApiController {
@Autowired
  private ActorRepository ActorRepo;

  public ActorApiController(ActorRepository ActorRepo) {
    this.ActorRepo = ActorRepo;
  }

  @GetMapping("")
  public List<Actor> getAll() {
    return ActorRepo.findAll();
  }

  @GetMapping("{id}")
  public Actor getOne(@PathVariable int id) {
    return ActorRepo.findOne(id);
  }

  @PostMapping("")
  public Actor create(@RequestBody Actor Actor) {
    return ActorRepo.save(Actor);
  }

  @PutMapping("{id}")
  public Actor update(@RequestBody Actor Actor, @PathVariable int id) {
    Actor.setId(id);
    return ActorRepo.save(Actor);
  }

  @DeleteMapping("{id}")
  public Actor delete(@PathVariable int id) {
    Actor Actor = ActorRepo.findOne(id);
    ActorRepo.delete(id);
    return Actor;
  }
  @PostMapping("{actorId}/awards")
   public Actor createAward(@PathVariable int actorId,@RequestBody Award award) {
	  Actor actor = ActorRepo.findOne(actorId); 
	  actor.addAward(award);
	  return ActorRepo.save(actor);
  }
}
