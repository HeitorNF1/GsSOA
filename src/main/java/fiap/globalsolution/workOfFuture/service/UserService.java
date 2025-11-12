package fiap.globalsolution.workOfFuture.service;

import fiap.globalsolution.workOfFuture.dto.UserRequestDTO;
import fiap.globalsolution.workOfFuture.dto.UserResponseDTO;
import fiap.globalsolution.workOfFuture.model.User;
import fiap.globalsolution.workOfFuture.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public UserResponseDTO findById(UUID id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return toResponse(user);
    }

    public UserResponseDTO create(UserRequestDTO dto) {
        if (repository.existsByEmail(dto.email())) {
            throw new RuntimeException("Email já cadastrado");
        }
        User user = new User();
        user.setNome(dto.nome());
        user.setTelefone(dto.telefone());
        user.setEmail(dto.email());
        user.setSenha(dto.senha());
        user.setRole(dto.role());
        repository.save(user);
        return toResponse(user);
    }

    public UserResponseDTO update(UUID id, UserRequestDTO dto) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        user.setNome(dto.nome());
        user.setTelefone(dto.telefone());
        user.setEmail(dto.email());
        user.setSenha(dto.senha());
        user.setRole(dto.role());
        repository.save(user);
        return toResponse(user);
    }

    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado");
        }
        repository.deleteById(id);
    }

    private UserResponseDTO toResponse(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getNome(),
                user.getTelefone(),
                user.getEmail(),
                user.getRole()
        );
    }
}
