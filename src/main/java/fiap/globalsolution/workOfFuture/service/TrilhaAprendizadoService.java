package fiap.globalsolution.workOfFuture.service;

import fiap.globalsolution.workOfFuture.dto.TrilhaRequestDTO;
import fiap.globalsolution.workOfFuture.dto.TrilhaResponseDTO;
import fiap.globalsolution.workOfFuture.model.TrilhaAprendizado;
import fiap.globalsolution.workOfFuture.model.User;
import fiap.globalsolution.workOfFuture.repository.TrilhaAprendizadoRepository;
import fiap.globalsolution.workOfFuture.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrilhaAprendizadoService {

    private final TrilhaAprendizadoRepository trilhaRepository;
    private final UserRepository userRepository;

    public TrilhaResponseDTO criarTrilha(TrilhaRequestDTO dto) {
        User criador = userRepository.findById(dto.criadorId())
                .orElseThrow(() -> new RuntimeException("Usuário criador não encontrado."));

        TrilhaAprendizado trilha = new TrilhaAprendizado();
        trilha.setNome(dto.nome());
        trilha.setDescricao(dto.descricao());
        trilha.setNivel(dto.nivel());
        trilha.setAtiva(dto.ativa());
        trilha.setCriador(criador);

        trilhaRepository.save(trilha);
        return toResponseDTO(trilha);
    }

    public List<TrilhaResponseDTO> listarTrilhas() {
        return trilhaRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public TrilhaResponseDTO buscarPorId(UUID id) {
        TrilhaAprendizado trilha = trilhaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trilha não encontrada."));
        return toResponseDTO(trilha);
    }

    public TrilhaResponseDTO atualizarTrilha(UUID id, TrilhaRequestDTO dto) {
        TrilhaAprendizado trilha = trilhaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trilha não encontrada."));

        trilha.setNome(dto.nome());
        trilha.setDescricao(dto.descricao());
        trilha.setNivel(dto.nivel());
        trilha.setAtiva(dto.ativa());

        trilhaRepository.save(trilha);
        return toResponseDTO(trilha);
    }

    public void deletarTrilha(UUID id) {
        if (!trilhaRepository.existsById(id)) {
            throw new RuntimeException("Trilha não encontrada.");
        }
        trilhaRepository.deleteById(id);
    }

    private TrilhaResponseDTO toResponseDTO(TrilhaAprendizado trilha) {
        return new TrilhaResponseDTO(
                trilha.getId(),
                trilha.getNome(),
                trilha.getDescricao(),
                trilha.getNivel(),
                trilha.isAtiva(),
                trilha.getCriador(),
                trilha.getDataCriacao()
        );
    }
}
