# Instruções para compilar e rodar o App:

* Ter o git instalado na máquina
    * [Baixar Git](http://git-scm.com/downloads)

* Baixar o repositório
    ```
    git clone https://github.com/gabrielrtakeda/project
    cd project
    ```

### Linux/Mac OS

1. Compilar o arquivo
    ```
    find . -name '*.java' | xargs javac -d binary/
    ```

2. Rodar o app;
    ```
    java -cp binary/ project.Main
    ```

### Windows:

1. Compilar o arquivo
    ```
    dir /s /B *.java > sources.txt
    javac -d binary/ @sources.txt
    ```

2. Rodar o app;
    ```
    java -cp binary/ project.Main
    ```
