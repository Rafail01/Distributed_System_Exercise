package gr.hua.dit.ds.DistributedSystem.repository;

import gr.hua.dit.ds.DistributedSystem.entity.FoundPet;
import gr.hua.dit.ds.DistributedSystem.entity.MunicipalEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoundPetRepository extends JpaRepository<FoundPet,Integer> {
}