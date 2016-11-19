#Siga os passos abaixo para poder executar os testes robotium no projeto:

1. Instale o SDK do Android na sua máquina, juntamente com o "SDK Manager" e o "ADV Manager".
	"https://developer.android.com/sdk/installing/index.html?pkg=tools" 

2. Instale e configure o Gradle na sua máquina.
	"https://docs.gradle.org/current/userguide/installation.html"

3. Configure o diretório do SDK do Android no arquivo "local.properties", que fica no diretório principal do projeto.

4. Antes de dar build no projeto limpe-o, usando o comando "gradlew clean", dentro do diretório do projeto.

5. Dê build no projeto usando o comando "gradlew build", dentro do diretório do projeto."

6. Na pasta do projeto NotePad, no prompt de comando digite o comando "gradlew assembleRelease". Isso irá gerará uma release do projeto que poderá ser instalado no dispositivo virtual Android.

7. Abra a pasta do SDK do Android e execute o arquivo "AVD Manager", crie e configure um dispositivo virtual Android para poder executar os testes nele.

8. Inicie o dispositivo virtual do Android.

9. Para rodar os testes, digite o comando "gradlew cC".
