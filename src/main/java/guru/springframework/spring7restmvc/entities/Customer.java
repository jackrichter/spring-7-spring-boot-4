package guru.springframework.spring7restmvc.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator                      // Hibernate specific (new SpringBoot 3.4 or higher)
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    @JdbcTypeCode(SqlTypes.CHAR)        // Hibernate specific (new SpringBoot 3.4 or higher)
    private UUID id;

    private String name;

    @Column(length = 255)
    private String email;

    @Version
    private Integer version;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @OneToMany(mappedBy = "customer")
    private Set<BeerOrder> beerOrders;
}
