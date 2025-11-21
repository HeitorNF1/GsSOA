-- ===============================
-- USUÁRIOS (TB_USER)
-- ===============================
INSERT INTO TB_USER (id, nome, telefone, email, senha, role, relationUser) VALUES
('11111111-1111-1111-1111-111111111111', 'Ana Silva', '11999990001', 'ana.silva@example.com', 'senha123', 'ADMIN', 'PROFISSIONAL'),
('22222222-2222-2222-2222-222222222222', 'Bruno Costa', '11999990002', 'bruno.costa@example.com', 'senha123', 'USER', 'ALUNO'),
('33333333-3333-3333-3333-333333333333', 'Carla Mendes', '11999990003', 'carla.mendes@example.com', 'senha123', 'USER', 'PROFISSIONAL'),
('44444444-4444-4444-4444-444444444444', 'Diego Rocha', '11999990004', 'diego.rocha@example.com', 'senha123', 'ADMIN', 'ALUNO'),
('55555555-5555-5555-5555-555555555555', 'Eduardo Lima', '11999990005', 'eduardo.lima@example.com', 'senha123', 'USER', 'ALUNO');



-- ===============================
-- TRILHAS (TB_TRILHA)
-- Criador = Ana Silva (ADMIN)
-- ID: 11111111-1111-1111-1111-111111111111
-- ===============================

INSERT INTO TB_TRILHA (id, nome, descricao, nivel, ativa, criador_id, data_criacao) VALUES
(
    'aaaa1111-1111-1111-1111-111111111111',
    'Introdução ao Futuro do Trabalho',
    'Trilha inicial com fundamentos sobre tendências, automação, IA e novas competências.',
    'BASICO',
    true,
    '11111111-1111-1111-1111-111111111111',
    NOW()
),
(
    'bbbb2222-2222-2222-2222-222222222222',
    'Desenvolvimento de Habilidades Digitais',
    'Trilha focada em competências digitais essenciais como pensamento computacional, lógica e ferramentas tecnológicas.',
    'INTERMEDIARIO',
    true,
    '11111111-1111-1111-1111-111111111111',
    NOW()
),
(
    'cccc3333-3333-3333-3333-333333333333',
    'Inteligência Artificial Aplicada',
    'Trilha avançada para desenvolvimento de IA aplicada a negócios, automatização e análise de dados.',
    'AVANCADO',
    true,
    '11111111-1111-1111-1111-111111111111',
    NOW()
);
