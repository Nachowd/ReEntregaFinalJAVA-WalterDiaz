package WalterDiaz.coderhouse.jpa.repositories;

import WalterDiaz.coderhouse.jpa.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, String> {
}