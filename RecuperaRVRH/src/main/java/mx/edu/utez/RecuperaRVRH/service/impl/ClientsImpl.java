package mx.edu.utez.RecuperaRVRH.service.impl;

import lombok.AllArgsConstructor;
import mx.edu.utez.RecuperaRVRH.model.dao.ClientsDao;
import mx.edu.utez.RecuperaRVRH.model.dto.ClientsDto;
import mx.edu.utez.RecuperaRVRH.model.entity.ClientsBean;
import mx.edu.utez.RecuperaRVRH.service.ClientsI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientsImpl implements ClientsI {

    private final ClientsDao clientsDao;
    @Override
    @Transactional
    public ClientsBean save(ClientsDto clientsDto){
        ClientsBean clients = ClientsBean.builder()
                .idClient(clientsDto.getIdClient())
                .name(clientsDto.getName())
                .lastName(clientsDto.getLastName())
                .phone(clientsDto.getPhone())
                .address(clientsDto.getAddress())
                .email(clientsDto.getEmail())
                .sex(clientsDto.getSex())
                .build();
        return clientsDao.save(clients);
    }

    @Override
    @Transactional(readOnly = true)
    public ClientsBean findById(Integer idClient){
        return clientsDao.findById(idClient).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClientsBean> findAll(){
        return (List<ClientsBean>) clientsDao.findAll();
    }

    @Override
    @Transactional
    public void delete(ClientsBean clients){
        clientsDao.delete(clients);
    }
}
