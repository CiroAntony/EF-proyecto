package pe.isil.EFVasquez.afiliados;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.EFVasquez.shared.BasicResponse;

import java.util.List;
import java.util.Optional;

@Service
public class AfiliadoServiceImpl implements AfiliadoService{
    @Autowired
    private AfiliadoRepository repository;

    @Override
    public BasicResponse login(String name, String password) {
        try {
            Optional<Afiliado> userToFind = repository.findAfiliadoByNameAndPassword(name, password);

            if (userToFind.isEmpty()) return BasicResponse.buildWhenNamePasswordIncorrect();

            return BasicResponse.buildWhenLoginOk(userToFind.get());
        } catch (Exception e) {
            return BasicResponse.buildWhenError(e.getMessage());
        }
    }

    @Override
    public BasicResponse register(Afiliado afiliado) {
        try {
            Optional<Afiliado> userToFind = repository.findAfiliadoByName(afiliado.getName());

            if (userToFind.isPresent()) return BasicResponse.buildWhenEmailIsTaken();

            repository.save(afiliado);
            return BasicResponse.buildWhenRegisterSucceed();
        } catch (Exception e) {
            return BasicResponse.buildWhenError(e.getMessage());
        }
    }

    @Override
    public BasicResponse recoverPassword(Afiliado user, String name, String password) {
        try {
            Optional<Afiliado> userToUpdate = repository.findAfiliadoByName(name);

            if (userToUpdate.isEmpty()) return BasicResponse.buildWhenNamePasswordIncorrect();

            userToUpdate.get().setPassword(password);
            repository.save(userToUpdate.get());

            return BasicResponse.buildWhenPasswordRestored();
        } catch (Exception e) {
            return BasicResponse.buildWhenError(e.getMessage());
        }
    }


    @Autowired
    private AfiliadoRepository afiliadoRepository;
    @Override
    public List<Afiliado> findAll() {
        return afiliadoRepository.findAll();
    }
}
