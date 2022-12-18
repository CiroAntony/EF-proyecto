package pe.isil.EFVasquez.visita;

import pe.isil.EFVasquez.shared.BasicResponse;

import java.util.List;

public interface VisitaService {
    void save(Visita visita);
    BasicResponse updateVisita(Visita visita, Long id);
    void delete(Long id);
    List<Visita> findAll();
    List<Visita> getAllApps();

    Visita getVisitaById(Long id);

}
