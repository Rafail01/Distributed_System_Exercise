package gr.hua.dit.ds.DistributedSystem.service;

import gr.hua.dit.ds.DistributedSystem.repository.PetRepository;
import gr.hua.dit.ds.DistributedSystem.repository.VeterinaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class PetServiceImpl implements PetService{

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private PetRepository petRepository;

}
