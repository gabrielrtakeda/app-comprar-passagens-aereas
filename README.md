# Instruções para compilar:

* Ter o git instalado na máquina
    * [Baixar Git](http://git-scm.com/downloads)

* Baixar o repositório
    ```
    git clone https://github.com/gabrielrtakeda/project
    cd project
    ```

* Configurar Banco de Dados:
    Alterar o arquivo `modules/Database/Drivers/MysqlConnect.java` com as informações de banco de dados.

### Linux/Mac OS X

1. Compile
    ```sh
    find . -name '*.java' | xargs javac -d binary/
    ```
    * Ou no project root executar `./build.sh`

2. Execute
    ```sh
    java -cp binary/ project.Main
    ```
    * Ou no project root executar `./exec.sh`

3. Run
    * No project root executar `./run.sh`

### Windows:

1. Compile
    ```bat
    dir /s /B *.java > sources.txt
    javac -d binary/ @sources.txt
    ```

2. Run
    ```bat
    java -cp binary/ project.Main
    ```

### Pra quem usa Sublime Text:
* Importar o projeto `app-comprar-passagens-aereas.sublime-project`
* Compilação:
    * ![Apple Logo](https://cdn4.iconfinder.com/data/icons/proglyphs-free/512/Apple-16.png "Apple Logo") Mac OSX: `⌘ + Shift + B`
    * ![Windows Logo](https://cdn4.iconfinder.com/data/icons/proglyphs-free/512/Windows_alt-16.png "Windows Logo") Windows: `Ctrl + Shift + B`
    * ![Linux Logo](https://cdn4.iconfinder.com/data/icons/proglyphs-free/512/Linux_-_Tux-16.png "Linux Logo") Linux: `Ctrl + Shift + B`
* Existem 3 opções para compilar e executar o projeto:
    - Compile (apenas compila)
    - Execute (apenas executa)
    - Run (compila e executa)
