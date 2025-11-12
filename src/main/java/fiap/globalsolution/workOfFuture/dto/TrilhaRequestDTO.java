package fiap.globalsolution.workOfFuture.dto;

import fiap.globalsolution.workOfFuture.model.Nivel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record TrilhaRequestDTO(
        @NotBlank(message = "O nome da trilha é obrigatório.")
        @Size(max = 100, message = "O nome da trilha deve ter no máximo 100 caracteres.")
        String nome,

        @NotBlank(message = "A descrição da trilha é obrigatória.")
        @Size(max = 1000, message = "A descrição da trilha deve ter no máximo 1000 caracteres.")
        String descricao,

        @NotNull(message = "O nível da trilha é obrigatório.")
        Nivel nivel,

        boolean ativa,

        @NotNull(message = "O identificador do criador (criadorId) é obrigatório.")
        UUID criadorId
) {}
