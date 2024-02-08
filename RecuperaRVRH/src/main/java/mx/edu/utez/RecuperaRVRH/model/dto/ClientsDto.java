package mx.edu.utez.RecuperaRVRH.model.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ClientsDto {

    private Integer idClient;
    private String name;
    private String lastName;
    private String phone;
    private String address;
    private String email;
    private String sex;
}
