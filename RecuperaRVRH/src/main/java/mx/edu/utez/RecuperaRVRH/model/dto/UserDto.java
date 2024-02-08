package mx.edu.utez.RecuperaRVRH.model.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserDto {

    private Integer idUser;
    private String username;
    private String password;
    private Boolean estado;
}
