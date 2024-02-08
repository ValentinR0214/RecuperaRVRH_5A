package mx.edu.utez.RecuperaRVRH.model.dao;

import mx.edu.utez.RecuperaRVRH.model.entity.UserBean;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<UserBean, Integer>{
}
