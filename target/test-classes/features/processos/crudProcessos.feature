#language: pt

  Funcionalidade: CRUD de Processos

    Contexto:
      Dado que o usuario gostaria de salvar um novo processo
      E  o usuario informar "vara" com o valor igual a "Vila Prudente"
      E  o usuario informar "numero_processo" com o valor igual a "5"
      E  o usuario informar "natureza" com o valor igual a "Civil"
      E  o usuario informar "partes" com o valor igual a "Camila X Gabriel"
      E  o usuario informar "urgente" com o valor igual a "S"
      E  o usuario informar "arbitramento" com o valor igual a "S"
      E  o usuario informar "assistente_social" com o valor igual a "Camila"
      E  o usuario informar "data_entrada" com o valor igual a "15-10-2020"
      E  o usuario informar "data_saida" com o valor igual a "20-10-2020"
      E  o usuario informar "data_agendamento" com o valor igual a "21-10-2020"
      E  o usuario informar "status" com o valor igual a "Aguardando"
      E  o usuario informar "observacao" com o valor igual a "Gostaria que desse prioridade para o horario de manha"


    Cenario: Criação de um novo processo - POST
      Quando o usuario clicar no botao salvar
      Então o usuario deveria ver a mensagem "Processo foi criado com sucesso."

    @ignore
    Cenario: Criação de um novo processo - POST IGNORE
      Quando o usuario clicar no botao salvar
      Então o usuario deveria ver a mensagem "Processo foi criado com sucesso."

    Cenario: Mostrar um processo já criado - GET
      Dado o usuario clicar no botao salvar
      Quando o usuario clicar em mostrar
      Então o usuario deveria ver a mensagem "sucesso"
      E o usuario visualiza o campo "vara" com o valor igual a "Vila Prudente"
      E o usuario visualiza o campo "numero_processo" com o valor igual a "5"
      E o usuario visualiza o campo "natureza" com o valor igual a "Civil"
      E o usuario visualiza o campo "partes" com o valor igual a "Camila X Gabriel"
      E o usuario visualiza o campo "urgente" com o valor igual a "S"
      E o usuario visualiza o campo "arbitramento" com o valor igual a "S"
      E o usuario visualiza o campo "assistente_social" com o valor igual a "Camila"
      E o usuario visualiza o campo "data_entrada" com o valor igual a "2020-10-15"
      E o usuario visualiza o campo "data_saida" com o valor igual a "2020-10-20"
      E o usuario visualiza o campo "data_agendamento" com o valor igual a "2020-10-21"
      E o usuario visualiza o campo "status" com o valor igual a "Aguardando"
      E o usuario visualiza o campo "observacao" com o valor igual a "Gostaria que desse prioridade para o horario de manha"


      Esquema do Cenario: Validação do POST com esquema de cenário
        Dado que o usuario gostaria de salvar um novo processo
        E  o usuario informar "vara" com o valor igual a "<vara>"
        E  o usuario informar "numero_processo" com o valor igual a "<numero_processo>"
        E  o usuario informar "natureza" com o valor igual a "<natureza>"
        E  o usuario informar "partes" com o valor igual a "<partes>"
        E  o usuario informar "urgente" com o valor igual a "S"
        E  o usuario informar "arbitramento" com o valor igual a "S"
        E  o usuario informar "assistente_social" com o valor igual a "Camila"
        E  o usuario informar "data_entrada" com o valor igual a "15-10-2020"
        E  o usuario informar "data_saida" com o valor igual a "20-10-2020"
        E  o usuario informar "data_agendamento" com o valor igual a "21-10-2020"
        E  o usuario informar "status" com o valor igual a "Aguardando"
        E  o usuario informar "observacao" com o valor igual a "Gostaria que desse prioridade para o horario de manha"
        Quando o usuario clicar no botao salvar
        Então o usuario deveria ver a mensagem "Processo foi criado com sucesso."

        Exemplos:
        | vara     | numero_processo | natureza | partes         |
        | Perus    |     5           | Criminal | Camila X Carol |
        | Caieiras |     10          | Civil | Camila X Willi |