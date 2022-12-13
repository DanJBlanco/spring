package com.bolsadeideas.springboot.app.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_clients")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRST_NAME", length = 80, nullable = false)
    @NotEmpty
    private String firstName;

    @Column(name = "LAST_NAME", length = 80, nullable = false)
    @NotEmpty
    private String lastName;

    @Column(length = 80, nullable = false)
    @NotEmpty
    @Size(min=1, max = 8)
    @Email
    private String email;

    @NotNull
    @Column(name = "CREATE_AT")
    @Temporal(TemporalType.DATE) // this property indicate which type field is in database
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createAt;

    @PrePersist
    public void prePersist(){
        if(createAt==null){
            createAt = LocalDate.now();
        }
    }

}
