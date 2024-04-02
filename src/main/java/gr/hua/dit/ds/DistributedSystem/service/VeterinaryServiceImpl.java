package gr.hua.dit.ds.DistributedSystem.service;

import gr.hua.dit.ds.DistributedSystem.entity.Administrator;
import gr.hua.dit.ds.DistributedSystem.entity.Pet;
import gr.hua.dit.ds.DistributedSystem.entity.Veterinary;
import gr.hua.dit.ds.DistributedSystem.repository.VeterinaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class VeterinaryServiceImpl implements VeterinaryService{

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private VeterinaryRepository veterinaryRepository;

//
//    @Override
//    @Transactional
//    public void examinationStatement(@RequestBody Pet pet) {
//        //εμφανίζεται η φόρμα
//        //κάνει αποδοχή
//    }
//
//    @Override
//    @Transactional
//    public void confirmationData(@RequestBody Pet pet) {
//        // κάνει αποδοχή
//    }

}