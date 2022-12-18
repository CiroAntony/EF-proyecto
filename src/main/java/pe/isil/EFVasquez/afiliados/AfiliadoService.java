package pe.isil.EFVasquez.afiliados;

import pe.isil.EFVasquez.shared.BasicResponse;

import java.util.List;

public interface AfiliadoService {
    BasicResponse login(String name, String password);

    BasicResponse register(Afiliado authUser);

    BasicResponse recoverPassword(Afiliado user, String email, String password);
    List<Afiliado> findAll();
}
