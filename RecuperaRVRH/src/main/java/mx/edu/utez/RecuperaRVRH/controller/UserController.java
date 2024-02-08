package mx.edu.utez.RecuperaRVRH.controller;

import lombok.AllArgsConstructor;
import mx.edu.utez.RecuperaRVRH.model.dto.UserDto;
import mx.edu.utez.RecuperaRVRH.model.entity.UserBean;
import mx.edu.utez.RecuperaRVRH.service.UserI;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
@AllArgsConstructor
public class UserController {

    private final UserI userService;

    @GetMapping("/")
    public List<UserBean> getUsers(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserBean findById(@PathVariable Integer id){
        return userService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody UserDto userDto) {
        try {
            String passwordRandom = userService.passwordRa();
            UserDto userSaveDto = UserDto.builder()
                    .username(userDto.getUsername())
                    .password(passwordRandom)
                    .estado(userDto.getEstado())
                    .build();
            UserBean userSave = userService.save(userSaveDto);

            UserDto responseDto = UserDto.builder()
                    .idUser(userSave.getIdUser())
                    .username(userSave.getUsername())
                    .password(passwordRandom)
                    .estado(userSave.getEstado())
                    .build();

            return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>("El usuario ya existe, por favor elija otro nombre", HttpStatus.BAD_REQUEST);
        }
    }



    @PutMapping("/")
    public UserDto update(@RequestBody UserDto userDto){
        UserBean userUpdate = userService.save(userDto);
        return UserDto.builder()
                .idUser(userUpdate.getIdUser())
                .username(userUpdate.getUsername())
                .password(userUpdate.getPassword())
                .estado(userUpdate.getEstado())
                .build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        UserBean user = userService.findById(id);
        userService.delete(user);
    }
}
