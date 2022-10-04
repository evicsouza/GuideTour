Trabalhamos utilizando um fluxo de trabalho chamado de git flow, para organizar o nosso versionamento de código.
O Git Flow trabalha com duas branches principais, a Develop e a Master, que duram para sempre; e três branches de suporte, Feature, Release e Hotfix, que são temporários e duram até realizar o merge com as branches principais. Então, ao invés de uma única branch Master, esse fluxo de trabalho utiliza duas branches principais para registrar o histórico do projeto. A branch Master armazena o histórico do lançamento oficial, e a branch Develop serve como uma ramificação de integração para recursos.
A branch Master é a principal branch, aqui é onde temos todo o código de produção. Todas as novas funcionalidades que estão sendo desenvolvidas, em algum momento, serão mescladas ou associadas a Master.
Branch Develop é a branch onde fica o código do próximo deploy. Ela serve como uma linha do tempo com os últimos desenvolvimentos, isso significa que ela possui funcionalidades que ainda não foram publicadas e que posteriormente vão ser associadas com a branch Master.


Para contribuir:
1. Faça um fork do projeto (basta clicar no botão de fork do GitHub)
2. Clone o seu fork deste projeto ($ git clone https://github.com/evicsouza/GuideTour.git)
3. Abra uma issue (no projeto original) descrendo do que se trata a sua contribuição
4. Pegue o ID (código) da issue que você abriu e crie um branch na sua máquina com este código ($ git checkout -b ID)
5. Realize as mudanças que você deseja fazer
6. Faça os commits dessas mudanças (Nas mensagens que descreverá o commit, inicie o texto com #ID da issue)
7. Verifique se não há conflitos entre o seu branch local com o branch master upstream (o código original) ($ git fetch upstream e $ git rebase upstream/master)
8. Verifique se o código está compilando e passando nos testes ($ mvn clean package)
9. Envie o branch modificado para o seu repositório ($ git push origin ID)
10. No GitHub, vá ao site do projeto original, e abra um Pull Request (PR). No comentário do PR, faça a referência a issue aberta (Escreva "Conforme a issue #ID" (sem as aspas))


Para sincronizar as bases, siga os seguintes passos:

1. Adicione (apenas uma vez) o repositório original na lista de seus repositórios remotos ($ git remote add upstream https://github.com/evicsouza/GuideTour.git)
2. Baixe o código do repositório original ($ git fetch upstream)
3. Vá para o branch que você quer sincronizar ($ git checkout master)
4. Faça um rebase do repositório original com o seu ($ git rebase upstream/master)
5. Sincronize o seu repositório remoto com o seu local ($ git push origin master)
