# ProjetoCORBA
Sistema de Controle de Museu, utilizando a tecnologia CORBA.

## Getting started

Projeto construido utilizando JavaFX no Netbeans.
Necessário compilar para gerar *dist*

## Requisitos

O Sistema de Controle de Museu deve controlar o número de visitantes em um
museu. O propósito do sistema é:
- Registrar o número de visitantes presentes em um museu em um determinado
momento
- Apresentar de forma atualizada esse número para um guarda durante dia e
noite
- Tocar um sino para acordar o guarda caso o número de visitantes seja diferente
de zero durante o período da noite

### Módulos

Esse sistema deve ser composto pelos seguintes módulos:
- **Guarda**: recebe informações atualizadas dinamicamente da quantidade de
pessoas que entra e sai do museu, controlando o número de visitantes em todos
os momentos do dia. Pode modificar manualmente o modo do sistema para Dia
ou Noite
- **Portão**: registra e avisa ao guarda quando um visitante entra ou saí do museu
- **Sino**: Toca quando o modo Noite é acionado pelo guarda e o museu não está
vazio.

