package com.tech.microservices.payment.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Haytham DAHRI
 */
@Entity
@Table(name = "CUSTOMERS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerBO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<PaymentBO> payments;

    @Column(name = "GIVEN_NAME", nullable = false)
    private String givenName;

    @Column(name = "FAMILY_NAME", nullable = false)
    private String familyName;

    @Column(name = "BIRTH_DATE", updatable = false, nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDate;

    @CreationTimestamp
    @Column(name = "CREATION_DATE", updatable = false, nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime creationDate;

}
