package mx.edu.utez.RecuperaRVRH.service;

import mx.edu.utez.RecuperaRVRH.model.dto.UserDto;
import mx.edu.utez.RecuperaRVRH.model.entity.UserBean;

import java.util.List;

public interface UserI {

    UserBean save(UserDto user);
    UserBean findById(Integer id);
    List<UserBean> findAll();
    void delete(UserBean user);

    String passwordRa();
}
