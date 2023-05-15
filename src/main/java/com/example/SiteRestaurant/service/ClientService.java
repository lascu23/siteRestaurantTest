package com.example.SiteRestaurant.service;


import com.example.SiteRestaurant.constants.Constants;
import com.example.SiteRestaurant.entities.Client;
import com.example.SiteRestaurant.entities.Roles;
import com.example.SiteRestaurant.repository.ClientRepository;
import com.example.SiteRestaurant.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RolesRepository rolesRepository;

    public boolean createNewPerson(Client person){
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(Constants.STUDENT_ROLE);
        person.setRoles(role);
        person.setPwd(passwordEncoder.encode(person.getPwd()));
        person = clientRepository.save(person);
        if (null != person && person.getPersonId() > 0)
        {
            isSaved = true;
        }
        return isSaved;
    }
}