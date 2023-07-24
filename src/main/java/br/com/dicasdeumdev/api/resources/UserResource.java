package br.com.dicasdeumdev.api.resources;

import br.com.dicasdeumdev.api.domain.User;
import br.com.dicasdeumdev.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value = "/user")
public class UserResource {

  @Autowired
  UserService service;

  @GetMapping(value = "/{id}")
  public ResponseEntity<User> findById(@PathVariable Integer id) {
    return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
  }
}
