package mx.edu.utez.RecuperaRVRH.model.dao;

import mx.edu.utez.RecuperaRVRH.model.entity.ClientsBean;
import org.springframework.data.repository.CrudRepository;

public interface ClientsDao extends CrudRepository<ClientsBean, Integer> {
}
