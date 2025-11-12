package fiap.globalsolution.workOfFuture.controller;

import fiap.globalsolution.workOfFuture.dto.TrilhaRequestDTO;
import fiap.globalsolution.workOfFuture.dto.TrilhaResponseDTO;
import fiap.globalsolution.workOfFuture.service.TrilhaAprendizadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/trilhas")
@RequiredArgsConstructor
public class TrilhaAprendizadoController {

    private final TrilhaAprendizadoService trilhaService;

    @PostMapping
    public ResponseEntity<TrilhaResponseDTO> criarTrilha(@RequestBody TrilhaRequestDTO dto) {
        TrilhaResponseDTO novaTrilha = trilhaService.criarTrilha(dto);
        return ResponseEntity.ok(novaTrilha);
    }

    @GetMapping
    public ResponseEntity<List<TrilhaResponseDTO>> listarTrilhas() {
        List<TrilhaResponseDTO> trilhas = trilhaService.listarTrilhas();
        return ResponseEntity.ok(trilhas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrilhaResponseDTO> buscarPorId(@PathVariable UUID id) {
        TrilhaResponseDTO trilha = trilhaService.buscarPorId(id);
        return ResponseEntity.ok(trilha);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrilhaResponseDTO> atualizarTrilha(@PathVariable UUID id, @RequestBody TrilhaRequestDTO dto) {
        TrilhaResponseDTO atualizada = trilhaService.atualizarTrilha(id, dto);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTrilha(@PathVariable UUID id) {
        trilhaService.deletarTrilha(id);
        return ResponseEntity.noContent().build();
    }
}
