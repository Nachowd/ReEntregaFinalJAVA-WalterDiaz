package WalterDiaz.coderhouse.jpa.repositories;

import WalterDiaz.coderhouse.jpa.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
    Optional<Client> findByDocNumber(String docNumber);
}