package pe.isil.EFVasquez.visita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.EFVasquez.shared.BasicResponse;

import java.util.List;

@Service
public class VisitaServiceImpl implements VisitaService{

    @Autowired
    private VisitaRepository visitaRepository;

    @Override
    public void save(Visita visit) {
        visitaRepository.save(visit);
    }

    @Override
    public BasicResponse updateVisita(Visita visita, Long id) {
        try {
            Visita aplicacionToUpdate = visitaRepository.findById(id).get();

            aplicacionToUpdate.setLocal(visita.getLocal());
            aplicacionToUpdate.setAfiliado(visita.getAfiliado());
            aplicacionToUpdate.setFecha(visita.getFecha());
            aplicacionToUpdate.setHora(visita.getHora());
            visitaRepository.save(aplicacionToUpdate);

            return BasicResponse.buildWhenSucceed();
        } catch (Exception e) {
            return BasicResponse.buildWhenError("No puede repetir datos");
        }
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Visita> findAll() {
        return visitaRepository.findAll();
    }

    @Override
    public List<Visita> getAllApps() {
        return visitaRepository.findAll();
    }

    @Override
    public Visita getVisitaById(Long id) {
        return visitaRepository.findById(id).get();
    }


}
