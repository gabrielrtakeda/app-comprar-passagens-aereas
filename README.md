## Instruções para compilar:

* Ter o git instalado na máquina
    * [Baixar Git](http://git-scm.com/downloads)

* Baixar o repositório
    ```
    git clone https://github.com/gabrielrtakeda/project
    cd project
    ```

### Linux/Mac OS

1. Compile
    ```
    find . -name '*.java' | xargs javac -d binary/
    ```

2. Run
    ```
    java -cp binary/ project.Main
    ```

### Windows:

1. Compile
    ```
    dir /s /B *.java > sources.txt
    javac -d binary/ @sources.txt
    ```

2. Run
    ```
    java -cp binary/ project.Main
    ```
