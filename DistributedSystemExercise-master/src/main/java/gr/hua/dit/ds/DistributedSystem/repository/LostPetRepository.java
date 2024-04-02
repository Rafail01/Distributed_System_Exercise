package gr.hua.dit.ds.DistributedSystem.repository;

import gr.hua.dit.ds.DistributedSystem.entity.LostPet;
import gr.hua.dit.ds.DistributedSystem.entity.MunicipalEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LostPetRepository extends JpaRepository<LostPet,Integer> {
}