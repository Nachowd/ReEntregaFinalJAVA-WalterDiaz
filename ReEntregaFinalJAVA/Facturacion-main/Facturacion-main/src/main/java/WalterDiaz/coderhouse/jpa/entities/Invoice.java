package WalterDiaz.coderhouse.jpa.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "INVOICE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id", nullable = false, updatable = false)
    @Schema(description = "Unique ID of the invoice", accessMode = Schema.AccessMode.READ_ONLY, example = "1")
    private int invoiceId;  // Renombrado para mayor claridad

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    @JsonIgnoreProperties("invoices")
    @Schema(description = "Client related to the invoice", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "{ \"id\": \"1\" }") // Cambié el ejemplo a un valor de tipo 'int'
    private Client client;

    @Column(name = "created_at", nullable = false, updatable = false)
    @Schema(description = "Date when the invoice was created", accessMode = Schema.AccessMode.READ_ONLY, example = "2023-08-08")
    private LocalDateTime createdAt;

    @Column(name = "total", nullable = false)
    @Schema(description = "Total amount of the invoice", accessMode = Schema.AccessMode.READ_ONLY, example = "158754.10")
    private double total;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("invoice")
    @Schema(description = "List of details associated with the invoice", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<InvoiceDetail> details = new ArrayList<>();

    public Invoice(Client client, List<InvoiceDetail> details) {
        this.client = client;
        this.details = details;
    }
}
