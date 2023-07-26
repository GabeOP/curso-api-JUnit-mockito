package br.com.dicasdeumdev.api.resources;

import br.com.dicasdeumdev.api.domain.User;
import br.com.dicasdeumdev.api.domain.dto.UserDTO;
import br.com.dicasdeumdev.api.services.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserResourceTest {

  public static final Integer ID = 1;
  public static final String NAME = "Gabriel";
  public static final String EMAIL = "gabriel@hotmail.com";
  public static final String PASSWORD = "123";

  private User user;
  private UserDTO userDTO;
  @InjectMocks
  private UserResource resource;

  @Mock
  private UserServiceImpl service;

  @Mock
  private ModelMapper mapper;
  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    startUser();
  }

  @Test
  void whenFindByIdThenReturnSuccess() {
    when(service.findById(anyInt())).thenReturn(user);
    when(mapper.map(any(), any())).thenReturn(userDTO);

    ResponseEntity<UserDTO> response = resource.findById(ID);

    assertNotNull(response);
    assertNotNull(response.getBody());
    assertEquals(ResponseEntity.class, response.getClass());
    assertEquals(UserDTO.class, response.getBody().getClass());

    assertEquals(ID, response.getBody().getId());
    assertEquals(NAME, response.getBody().getName());
    assertEquals(EMAIL, response.getBody().getEmail());
    assertEquals(PASSWORD, response.getBody().getPassword());
  }

  @Test
  void whenFindAllThenReturnSuccess() {
    when(service.findAll()).thenReturn(List.of(user));
    when(mapper.map(any(), any())).thenReturn(userDTO);

    ResponseEntity<List<UserDTO>> response = resource.findAll();

    assertNotNull(response.getBody());
    assertEquals(1, response.getBody().size());
    assertEquals(ID, response.getBody().get(0).getId());
    assertEquals(NAME, response.getBody().get(0).getName());
    assertEquals(EMAIL, response.getBody().get(0).getEmail());
    assertEquals(PASSWORD, response.getBody().get(0).getPassword());
  }

  @Test
  void whenCreateThenReturnSuccess() {
    when(service.create(any())).thenReturn(user);
    when(mapper.map(any(), any())).thenReturn(userDTO);

    ResponseEntity<UserDTO> response = resource.create(userDTO);

    assertNotNull(response);
    assertEquals(HttpStatus.CREATED, response.getStatusCode());
    assertEquals(ResponseEntity.class, response.getClass());
  }

  @Test
  void update() {
  }

  @Test
  void delete() {
  }

  private void startUser() {
    user = new User(ID, NAME, EMAIL, PASSWORD);
    userDTO = new UserDTO(ID, NAME, EMAIL, PASSWORD);
  }
}