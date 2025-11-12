package fiap.globalsolution.workOfFuture.dto;

import fiap.globalsolution.workOfFuture.model.TypeUser;
import jakarta.validation.constraints.*;

public record UserRequestDTO(
        @NotBlank(message = "O nome é obrigatório.")
        @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres.")
        String nome,

        @NotBlank(message = "O telefone é obrigatório.")
        @Pattern(regexp = "\\d{10,11}", message = "O telefone deve conter apenas números e ter 10 ou 11 dígitos.")
        String telefone,

        @NotBlank(message = "O e-mail é obrigatório.")
        @Email(message = "O e-mail informado não é válido.")
        String email,

        @NotBlank(message = "A senha é obrigatória.")
        @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres.")
        String senha,

        @NotNull(message = "O tipo de usuário (role) é obrigatório.")
        TypeUser role
) {}
