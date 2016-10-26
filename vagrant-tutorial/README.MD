# Vagrant Tutorial

## Intro


Com o enorme crescimento da virtualização e cloud computing, também tem havido um aumento correspondente no número médio de máquinas virtuais (VM) que administradores de hoje tem de gerir. Criando manualmente uma máquina virtual completa em virtualizers de hoje, como VMWare e Hyper-V, é uma dor real, porque eles têm que capturar toda a configuração da máquina e, em seguida, replicar este para outra máquina. Ou seja, as imagens de VM tomam muito espaço e tempo.
Assim, com a necessidade de melhorar o modelo e a eficiência do mesmo, surgiram duas soluções que tomam caminhos diferentes para resolver as limitações do modelo tradicional de VM: o Docker e o Vagrant.
Para entender de uma maneira geral a diferença de abordagem dos dois, temos que compreender que essa diferença vem dos métodos vastamente diferentes usado para conseguir algum tipo de separação dentro de um computador físico. Docker depende de conteinerização, enquanto Vagrant utiliza virtualização.


## Virtualization


Com a virtualização, cada máquina virtual executa seu próprio sistema operacional inteiro dentro de um ambiente de hardware simulado fornecido por um programa chamado hypervisor rodando no hardware físico. Ilustração:



## Containerisation


Conteinerização permite que vários aplicativos sejam executados em partições isoladas de um único kernel Linux rodando diretamente no hardware físico. Cgroups e namespaces Linux são as tecnologias do kernel do Linux subjacentes utilizados para isolar, proteger e gerenciar os recipientes.





Assim, o Docker não cria sua própria máquina virtual com um sistema operacional e os processadores distintos e emulação de hardware. Ele roda na imagem do kernel já existente no hardware por baixo, e apenas cria um "container" que executa as suas aplicações.
Já o Vagrant é melhor descrito como um gerenciador de VM(Máquinas Virtuais). Ele permite a criação de scripts e empacotamento para configurações de VM. Ele é projetado para rodar em cima de quase toda ferramenta VM, como VirtualBox, VMware, a AWS, etc.




## Download
	Direto no site -> https://www.vagrantup.com/downloads.html
  O vagrant possui como pré-requisito o VirtualBox, ou o VmWare (na versão paga...). Para esse ensinaremos a usar a versão free, então instale o VirtualBox, que pode ser encontrado nesse **[link](https://www.virtualbox.org/)**


## Instalação
No Windows a instalação segue o padrão “Next - Install”, já no linux pode ser feita de duas formas, a primeira consiste em baixar o arquivo .deb direto do site e a segunda via “<sudo> apt-get install vagrant”, fazendo a instalação via repositório você corre o risco de não instalar a versão mais recente.


## Quick Start
Agora que já montamos o nosso ambiente, vamos iniciar o uso da ferramenta. Existem alguns comandos básicos que precisamos saber, esses são:

```
vagrant init  [box-name] = Cria o VagrantFile. O VagrantFile é um arquivo Ruby que é responsável por
configurar e definir o comportamento do Vagrant e também do seu virtualizador (VMware/VirtualBox).
Ele é um arquivo grande contendo muitas opções comentadas. [box-name] - Para conseguir o nome dos box
basta acessar a URL -> https://www.vagrantup.com/docs/boxes.html
```
```
vagrant up = Inicia a sua VM, deve ser executado no diretório que contém o VagrantFile.
Isso fará com que o Vagrant baixe o box virtual especificado pelo [box-name] .
```

```
vagrant ssh = Conecta com a máquina iniciada através de uma sessão SSH.
Uma vez dentro do VM, podemos fazer o que quisermos: executar comandos, criar usuários, criar arquivos e diretórios, etc.
Estamos logado como usuário ‘vagrant’, que tem privilégios sudo, então temos controle total sobre a VM.
```


Para criar arquivos e modificá-los, por exemplo, não é preciso editar arquivos usando editores baseados em terminal por SSH. Felizmente com Vagrant usando pastas sincronizadas, ele irá sincronizar automaticamente os seus arquivos para e a partir da guest machine.


Vagrant também tem suporte embutido para o provisionamento automatizado. Usando esse recurso, Vagrant irá instalar automaticamente o software quando executamos vagrant up para que a guest machine possa ser repetidamente criada e esteja pronta para uso.
Como exemplo, poderíamos criar um script para configurar Apache para um projeto básico como o que segue e salvando-o como “bootstrap.sh” no mesmo diretório que o Vagrantfile:
```
#!/usr/bin/env bash

apt-get update
apt-get install -y apache2
if ! [ -L /var/www ]; then
  rm -rf /var/www
  ln -fs /vagrant /var/www
fi
```
Depois poderíamos configurar o Vagrant para executar este script shell ao configurar nossa máquina.
Fazemos isso através da edição do Vagrantfile, adicionando a linha “config.vm.provision” :
```
Vagrant.configure("2") do |config|
  config.vm.box = "hashicorp/precise64"
  config.vm.provision :shell, path: "bootstrap.sh"
end
```

(Exemplo de VagrantFile, com vm.box criada ao fazer vagrant init  [box-name] )

Essa linha diz para o Vagrant usar o shell provisioner para configurar a máquina com o arquivo bootstrap.sh. O caminho do arquivo é relativo ao local da raiz do projeto (onde o Vagrantfile está). Depois que tudo estiver configurado, basta executar vagrant up para criar sua máquina e Vagrant automaticamente chama o script através do provisionamento. Dessa maneira, outras pessoas que fossem usar o Vagrant não precisariam rodar o script para instalar o Apache já que ele automáticamente faria.

### Outros comandos importantes são:


```
vagrant suspend = Suspende a máquina virtual e vai salvar o estado de execução atual da máquina e pará-la.
Quando estiver pronto para começar a trabalhar novamente, basta executar vagrant up,
e a máquina virtual vai ser retomada a partir de onde parou.
```

```
vagrant halt = Desliga a máquina virtual que ligada novamente chamando vagrant up.
A vantagem deste método é que ele vai desligar corretamente sua máquina e a desvantagem é que ele vai levar algum tempo extra para ligar novamente.
```

```
vagrant destroy = Remove a máquina do virtualizador, irá remover todos os vestígios
da máquina convidada do seu sistema. Ele vai parar a máquina convidada e remover
todos os discos rígidos de hóspedes.
```



# Documento no GDocs
```
https://docs.google.com/document/d/1KtBzC5F9MuRmYouitEl_Vpq2L1vdaasDHDH7DHdgIEs/edit?usp=sharing

```
