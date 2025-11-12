package fiap.globalsolution.workOfFuture.dto;

import fiap.globalsolution.workOfFuture.model.TypeUser;

public record UserRequestDTO(
        String nome,
        String telefone,
        String email,
        String senha,
        TypeUser role
) {}
