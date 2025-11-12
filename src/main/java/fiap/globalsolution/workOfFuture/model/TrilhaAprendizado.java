package fiap.globalsolution.workOfFuture.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="TB_TRILHA")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class TrilhaAprendizado {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(nullable = false)
    private Nivel nivel;

    @Column(nullable = false)
    private boolean ativa = true;

    @ManyToOne
    @JoinColumn(name = "criador_id")
    private User criador; // usuário que criou a trilha

    @Column(name = "data_criacao", updatable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now(); //útil para logs
}
