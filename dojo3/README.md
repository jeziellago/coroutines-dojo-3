# Coroutines Dojo 3

## Desafio
Afim de evitar fraudes o **Banco Porquinho** necessita de um novo sistema de Abertura de Contas para isso foram contratadas duas empresas de validação de documentos:

- Serasa - Com base no CPF fornece dados sobre a saúde financeira do usuário
- Identity Validator - Utiliza imagens  de documentos para verificar se este usuário não é um possível fraudador.

### Parte 1
Todos os novos usuários tem que ter suas identidades validadas por estas empresas seguindo as regras abaixo:

- Caso o score recebido da validador de identidade seja abaixo de 0.75 o usuário sera reprovado.
- Caso o score recebido do serasa seja abaixo de 300 o usuário sera reprovado.

O serviço precisa devolver um status informando se a conta foi aprovada ou não na validação.

### Parte 2

Precisamos escalar a o serviço de abertura de contas, focado em validação dos dados.
Esse serviço receberá lotes de 10.000 contas para processar por vez e deverá responder em no máximo 10 segundos.

