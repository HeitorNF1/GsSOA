package fiap.globalsolution.workOfFuture.repository;

import fiap.globalsolution.workOfFuture.model.TrilhaAprendizado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TrilhaAprendizadoRepository extends JpaRepository<TrilhaAprendizado, UUID> {
}
