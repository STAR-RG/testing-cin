# Teste de Software <br> [Centro de Informática](http://www.cin.ufpe.br), [UFPE](http://www.ufpe.br) 
### Professor: [Marcelo d'Amorim](http://cin.ufpe.br/~damorim/)
<hr>

<img src="img/scared-bug-clipart-1.jpg" height=200 class="img-responsive" alt="Odeio teste de software!"></div>

<!--
### Teste de Software é uma atividade de Engenharia de Software extremamente importante.
-->

Esta disciplina é oferecida na graduação e na pós-graduação, em semestres alternados. 2019.1 --> pós 

### Horário e Local das Aulas em 2019.1
* Terças (10-12h) e Quintas (10-12h), sala D222

### Repositório GitHub
- http://github.com/damorim/testing-cin (slides, demos, provas, etc.)

### Objetivos

Os objetivos desta disciplina, quando ministrada na graduação e pós-graduação, são diferentes. Na graduação, o material teórico (ver [slides](/slides.pptx)) é coberto de maneira mais detalhada, em cerca de oito semanas enquanto que na pós-graduação, o material teórico é coberto em apenas duas semanas. Na graduação, a ênfase é na compreensão dos conceitos básicos e no conhecimento de ferramentas usadas na prática industrial. Na pós-graduação, a ênfase é no treinamento do aluno para resolver problemas de pesquisa na área. 


### Ementa

A ementa da parte téorica inclui os seguintes tópicos:

* conceitos básicos sobre teste e depuração de software
* como escrever um bug report
* o caso de teste 
  * entrada, asserção, test harness (setup, teardown)
  * demosntração com JUnit
* controle de versão e testes
  * demonstração git bisect
  * demonstração integração contínua com Travis
* critérios de adequação
  * estrutural, lógico, baseado em fluxo de dados, e baseado em erros
* teste funcional
  * particionamento de domínio
  * análise de fronteira
  * seleção de amostras (teste combinatorial)


### Metodologia

Na pós-graduação, a avaliação será feita em função de um projeto de pesquisa. Cada aluno (ou par) escolherá um projeto, definido pelo professor. O escopo de cada projeto é compatível com a duração do curso---o aluno receberá créditos logo ao término do semestre. Importante destacar que o projeto, a princípio, possui potencial de publicação, mas não há obrigação de publicação (até porque não há garantia de se obter bons resultados). Caso o aluno queira publicar o trabalho, provavelmente terá que, voluntariamente e com apoio do orientador, investir um pouco mais de esforço após término do período. O professor irá ajudar ativamente cada grupo, fornecendo as ferramentas necessárias para realização do projeto (por exemplo, scripts e "datasets"). A lista de projetos (cinco a seis opções) será definida pelo professor e criticada durantes as aulas. A avaliação será feita baseada nas entregas (três a quatro) e no acompanhamento das atividades (na sala do professor).

### Bibliografia
- [Generating Software Tests: Breaking Software for Fun and Profit](https://www.fuzzingbook.org/). Andreas Zeller, Rahul Gopinath, Marcel Böhme, Gordon Fraser, and Christian Holler <b>(online)</b>
- Software Testing and Analysis. Mauro Pezze and Michal Young, Wiley, 2008  
- Why Programs Fail?. Andreas Zeller, Morgan Kaufmann 2009 (2nd edition)
- Software Testing. Glenford Myers, Wiley, 2004 (2nd edition)

<!---
### Recursos

- [Google Classroom](http://classroom.google.com) - Código:  5ub3mb5


### Ferramentas
- [Antlr (ANother Tool for Language Recognition)](https://www.antlr.org/)
- [LLVM](https://llvm.org/)

### Avaliação
* (`N1`+`N2`)/2, onde:
  * `N1` = `Prova1` (70%) + `Aulas práticas` (30%)
    * `Prova1` = Teste com [assunto dado até o momento
    * `Aulas práticas` = 3 Tarefas passadas durante primeira unidade
  * `N2` = `Prova2` (70%) + `Mini projeto` (30%)
    * `Prova2` = Teste com [assunto dado a partir de Prova1 
    * `Mini Projeto` = Projeto da cadeira
* `Final`: Teste com todo o assunto da matéria

- Observação:
  - Trabalhos **“CTRL-C + CTRL-V”** terão nota **zero** (vale tanto para cópia de colegas, como para trabalhos copiados da internet).

### Provas anteriores
- [Clique aqui](/provas)

### Notas
- [Clique aqui](alunos.md)

--->

### Cronograma de Aulas

**Atenção!** 
*Este plano de aulas está sujeito a alterações durante o semestre, visite frequentemente a página para obter a versão mais atualizada, ou acompanhe os updates no repositório.*

| # | Data | Assunto | Observação |
|:---:|:----:|:----------------------:|:----------------------|
| 01 | 12/03/2019 | Apresentação da disciplina | Apresentação da metodologia de ensino e de avaliação que será usada no curso. O material teórico não começou a ser visto. Apenas Alex na sala. |
| 02 | 14/03/2019 | Teste versus depuração.<br> Falta versus falha.<br> Como escrever um bug report.<br> Caso de teste (com JUnit).<br>[slides](/slides.pptx) |   |