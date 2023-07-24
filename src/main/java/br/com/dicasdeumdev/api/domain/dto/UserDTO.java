package br.com.dicasdeumdev.api.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
  private Integer id;
  private String name;
  private String email;

  //Annotation para dizer que o setter vai funcionar mas o getter não, ou seja, não vai mostrar no retorno.
  //Com isso, evita a criação de um DTO para request e outro para response nesse caso.
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String password;
}
