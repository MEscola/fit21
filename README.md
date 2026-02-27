# 🚀 FIT21

Plataforma de Gamificação e Gestão de Performance para Boxes e Personais.

---

## 📌 Sobre o Projeto

O **Fit21** é um SaaS focado em aumentar engajamento, frequência e retenção de alunos através de:

- Gamificação para boxes (modo competição)
- Gestão individual de performance para personal trainers
- Ranking diário e mensal
- Sistema de medalhas e badges permanentes

O sistema NÃO substitui softwares financeiros ou ERPs de academias.  
O foco é exclusivamente performance, motivação e evolução.

---

## 🎯 Objetivo

Criar uma plataforma escalável que:

- Aumente a motivação dos alunos
- Melhore retenção em boxes
- Organize treinos de personal trainers
- Forneça histórico estruturado de resultados
- Utilize gamificação como mecanismo de engajamento

---

# 🧩 Modos do Sistema

## 🏋️ Modo BOX (Gamificado)

Voltado para boxes de CrossFit e treinos em grupo.

### 👨‍🏫 Coach pode:

- Criar box
- Gerar código de convite
- Criar WOD
- Definir tipo (FOR_TIME / AMRAP)
- Ativar/desativar competição mensal
- Visualizar ranking diário
- Visualizar ranking mensal
- Ver histórico de campeões

### 🏋️ Aluno pode:

- Entrar no box via código
- Registrar resultado
- Visualizar ranking diário (🥇🥈🥉)
- Visualizar ranking mensal
- Receber badge permanente
- Sair do box mantendo histórico

---

## 👤 Modo PERSONAL (Sem competição)

Voltado para personal trainers individuais.

### 👨‍🏫 Personal pode:

- Criar aluno
- Criar treino individual
- Registrar PR (Personal Record)
- Acompanhar evolução

### 🏋️ Aluno pode:

- Visualizar treinos
- Registrar carga / tempo / reps
- Ver histórico
- Visualizar PR

Sem ranking.
Sem medalhas.
Sem competição.

---

# 🏆 Sistema de Gamificação

## Ranking Diário

Ordenação baseada no tipo de WOD:

- FOR_TIME → menor tempo vence
- AMRAP → maior número de repetições vence

Top 3 recebem medalhas automáticas.

## Ranking Mensal

Pontuação:

- 🥇 3 pontos
- 🥈 2 pontos
- 🥉 1 ponto

Desempate por:

1. Maior número de ouros
2. Maior número de pratas
3. Maior número de bronzes

Badge permanente no perfil:
Ex: `3x Campeão do Mês`

---

# 🏗 Arquitetura

## 📦 Backend

- Java 17 / 21
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- Spring Security
- JWT
- PostgreSQL
- Lombok
- Bean Validation

## ☁ Infraestrutura

- Deploy inicial: Render ou Railway
- Banco: PostgreSQL
- Estrutura multi-tenant isolada por `box_id`

---

# 📂 Estrutura de Pastas
fit21
├── auth
├── user
├── box
├── workout
├── result
├── ranking
├── personal
├── notification
├── config
├── exception
└── shared

---

Organização por domínio, facilitando escalabilidade e manutenção.

---

# 🗄 Modelo de Dados (Conceitual)

## User
- id
- name
- email
- password
- role (COACH, ALUNO, PERSONAL)

## Box
- id
- name
- coach_id
- invite_code
- competition_active
- competition_month
- max_results_month

## Workout
- id
- box_id ou personal_id
- name
- type (FOR_TIME / AMRAP)
- date

## WorkoutResult
- id
- workout_id
- user_id
- score
- created_at

## MonthlyScore
- user_id
- box_id
- month
- points
- gold
- silver
- bronze

---

# 🔐 Segurança

- Autenticação via JWT
- Controle por Role
- Isolamento por box_id
- Validação com Bean Validation

---

# 🚀 Roadmap Inicial

### Fase 1
- Autenticação
- CRUD de Box
- CRUD de Workout
- Registro de Resultado

### Fase 2
- Ranking diário
- Ranking mensal
- Cálculo automático de pontuação

### Fase 3
- Badge permanente
- Notificações
- Histórico de campeões

---

# 📈 Visão de Futuro

- Dashboard analítico
- Evolução gráfica
- Push notifications reais
- Planos SaaS pagos
- Painel administrativo

---

# 💡 Status

🚧 Em desenvolvimento — MVP em construção.

---

# 👩‍💻 Autora

Márcia Escolástico  
Desenvolvido como projeto SaaS escalável utilizando Spring Boot.
