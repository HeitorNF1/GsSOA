package fiap.globalsolution.workOfFuture.dto;

import fiap.globalsolution.workOfFuture.model.Nivel;
import fiap.globalsolution.workOfFuture.model.User;

import java.time.LocalDateTime;
import java.util.UUID;

public record TrilhaResponseDTO(
        UUID id,
        String nome,
        String descricao,
        Nivel nivel,
        boolean ativa,
        User criador,
        LocalDateTime dataCriacao
) {}
