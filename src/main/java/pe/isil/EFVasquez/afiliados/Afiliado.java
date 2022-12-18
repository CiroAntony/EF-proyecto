package pe.isil.EFVasquez.afiliados;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
@Table(name = "tbl_afiliado", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name", name = "unique_username"),
        @UniqueConstraint(columnNames = "DNI", name = "unique_DNI"),
        @UniqueConstraint(columnNames = "email", name = "unique_email")
})

@Entity
public class Afiliado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String DNI;
    private String email;
    private String password;

    private Date createdAt;

    @PostPersist
    public void postPersist() {
        createdAt = new Date();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
