package gr.hua.dit.ds.DistributedSystem.repository;

import gr.hua.dit.ds.DistributedSystem.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen,Integer>{

}
