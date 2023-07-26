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
  void findById() {
  }

  @Test
  void findAll() {
  }

  @Test
  void create() {
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