package mx.edu.utez.RecuperaRVRH.service;

import mx.edu.utez.RecuperaRVRH.model.dto.ClientsDto;
import mx.edu.utez.RecuperaRVRH.model.entity.ClientsBean;

import java.util.List;

public interface ClientsI {

    ClientsBean save(ClientsDto client);
    ClientsBean findById(Integer id);
    List<ClientsBean> findAll();
    void delete(ClientsBean client);
}
