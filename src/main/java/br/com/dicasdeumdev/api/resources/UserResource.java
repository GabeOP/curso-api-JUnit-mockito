package br.com.dicasdeumdev.api.resources;

import br.com.dicasdeumdev.api.domain.dto.UserDTO;
import br.com.dicasdeumdev.api.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/user")
public class UserResource {
  @Autowired
  private ModelMapper mapper;
  @Autowired
  UserService service;

  @GetMapping(value = "/{id}")
  public ResponseEntity<UserDTO> findById(@PathVariable Integer id) {
    return ResponseEntity.status(HttpStatus.OK).body(mapper.map(service.findById(id), UserDTO.class));
  }

  @GetMapping
  public ResponseEntity<List<UserDTO>> findAll() {
    List<UserDTO> listDto = service.findAll()
            .stream().map(x -> mapper.map(x, UserDTO.class)).collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(listDto);
  }
}
