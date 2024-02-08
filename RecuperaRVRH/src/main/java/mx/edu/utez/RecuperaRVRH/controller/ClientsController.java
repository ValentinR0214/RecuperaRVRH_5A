package mx.edu.utez.RecuperaRVRH.controller;

import lombok.AllArgsConstructor;
import mx.edu.utez.RecuperaRVRH.model.dto.ClientsDto;
import mx.edu.utez.RecuperaRVRH.model.entity.ClientsBean;
import mx.edu.utez.RecuperaRVRH.service.ClientsI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clients")
@AllArgsConstructor
public class ClientsController {

    private final ClientsI clientsService;

    @GetMapping("/")
    public List<ClientsBean> getClients(){
        return clientsService.findAll();
    }

    @GetMapping("/{id}")
    public ClientsBean findById(@PathVariable Integer id){
        return clientsService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody ClientsDto clientsDto){
        ClientsBean clientsSave = clientsService.save(clientsDto);
        ClientsDto responseDto = ClientsDto.builder()
                .idClient(clientsSave.getIdClient())
                .name(clientsSave.getName())
                .lastName(clientsSave.getLastName())
                .phone(clientsSave.getPhone())
                .address(clientsSave.getAddress())
                .email(clientsSave.getEmail())
                .sex(clientsSave.getSex())
                .build();
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);

    }

    @PutMapping("/")
    public ClientsDto update(@RequestBody ClientsDto clientsDto) {
        ClientsBean clientsUpdate = clientsService.save(clientsDto);
        return ClientsDto.builder()
                .idClient(clientsUpdate.getIdClient())
                .name(clientsUpdate.getName())
                .lastName(clientsUpdate.getLastName())
                .phone(clientsUpdate.getPhone())
                .address(clientsUpdate.getAddress())
                .email(clientsUpdate.getEmail())
                .sex(clientsUpdate.getSex())
                .build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        ClientsBean clients = clientsService.findById(id);
        clientsService.delete(clients);
    }
}
