# Instruções para compilar e rodar o App:

### Windows:

1. Ter o git instalado na máquina
    * [Baixar Git](http://git-scm.com/downloads)

2. Baixar o repositório
    ```
    cd C:\diretorio-onde-deseja-baixar-o-repositorio\
    git clone https://github.com/gabrielrtakeda/project
    cd project
    ```

3. Compilar o arquivo
    ```
    dir /s /B *.java > sources.txt
    javac -d binary/ @sources.txt
    ```

4. Rodar o app;
    ```
    java -cp binary/ project.Main
    ```
