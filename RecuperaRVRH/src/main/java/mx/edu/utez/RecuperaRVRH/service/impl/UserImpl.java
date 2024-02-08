package mx.edu.utez.RecuperaRVRH.service.impl;

import lombok.AllArgsConstructor;
import mx.edu.utez.RecuperaRVRH.model.dao.UserDao;
import mx.edu.utez.RecuperaRVRH.model.dto.UserDto;
import mx.edu.utez.RecuperaRVRH.model.entity.UserBean;
import mx.edu.utez.RecuperaRVRH.service.UserI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class UserImpl implements UserI {

    private final UserDao userDao;

    @Override
    @Transactional
    public UserBean save(UserDto userDto){
        UserBean user = UserBean.builder()
                .idUser(userDto.getIdUser())
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .estado(userDto.getEstado())
                .build();
        return userDao.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public UserBean findById(Integer idUser){
        return userDao.findById(idUser).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserBean> findAll(){
        return (List<UserBean>) userDao.findAll();
    }

    @Override
    @Transactional
    public void delete(UserBean user){
        userDao.delete(user);
    }

    @Override
    public String passwordRa() {
        String letrasMayus = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String letrasMinus = "abcdefghijklmnopqrstuvwxyz";
        String numeros = "0123456789";
        String especiales = "!@#$%^&*()-_=+[{]};:'\",<.>/?";

        String todo = letrasMayus + letrasMinus + numeros + especiales;

        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int parte = (int) (Math.random() * todo.length());
            password.append(todo.charAt(parte));
        }

        return password.toString();
    }
}
