package pe.isil.EFVasquez.afiliados;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AfiliadoRepository extends JpaRepository<Afiliado, Long> {
    Optional<Afiliado> findAfiliadoByNameAndPassword(String name, String password);

    Optional<Afiliado> findAfiliadoByName(String name);
}
