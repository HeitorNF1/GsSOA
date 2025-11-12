package fiap.globalsolution.workOfFuture.dto;

import fiap.globalsolution.workOfFuture.model.TypeUser;

import java.util.UUID;

public record UserResponseDTO(
        UUID id,
        String nome,
        String telefone,
        String email,
        TypeUser role
) {}
