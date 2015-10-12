# Instruções para compilar:

* Ter o git instalado na máquina
    * [Baixar Git](http://git-scm.com/downloads)

* Baixar o repositório
    ```
    git clone https://github.com/gabrielrtakeda/project
    cd project
    ```

### Database ![Windows Logo](https://cdn0.iconfinder.com/data/icons/octicons/1024/database-16.png "Windows Logo")

* Configurar o banco de dados alterando o arquivo
    `modules/Database/Drivers/MysqlConnect.java`
    com as informações de banco de dados.

### Unix ![Apple Logo](https://cdn4.iconfinder.com/data/icons/proglyphs-free/512/Apple-16.png "Apple Logo")![Linux Logo](https://cdn4.iconfinder.com/data/icons/proglyphs-free/512/Linux_-_Tux-16.png "Linux Logo")

1. Compile
    ```sh
    find . -name '*.java' | xargs javac -d binary/
    ```
    * Ou no project root executar `./build.sh`

2. Execute
    ```sh
    java -cp lib/mysql-connector-java-5.1.36-bin.jar:binary/ project.Main
    ```
    * Ou no project root executar `./exec.sh`

3. Run
    * No project root executar `./run.sh`

### Windows ![Windows Logo](https://cdn4.iconfinder.com/data/icons/proglyphs-free/512/Windows_alt-16.png "Windows Logo")

1. Compile
    ```bat
    dir /s /B *.java > sources.txt
    javac -d binary/ @sources.txt
    ```

2. Run
    ```bat
    java -cp lib/mysql-connector-java-5.1.36-bin.jar:binary/ project.Main
    ```

### ![ST Logo](http://icons.iconarchive.com/icons/alecive/flatwoken/24/Apps-Sublime-Text-icon.png "ST Logo") Sublime Text Project:
* Importar o projeto `app-comprar-passagens-aereas.sublime-project`
* Build:
    * ![Apple Logo](https://cdn4.iconfinder.com/data/icons/proglyphs-free/512/Apple-16.png "Apple Logo")
         Mac OSX: `⌘ + Shift + B`
    * ![Windows Logo](https://cdn4.iconfinder.com/data/icons/proglyphs-free/512/Windows_alt-16.png "Windows Logo")
         Windows: `Ctrl + Shift + B`
    * ![Linux Logo](https://cdn4.iconfinder.com/data/icons/proglyphs-free/512/Linux_-_Tux-16.png "Linux Logo")
         Linux: `Ctrl + Shift + B`
* Existem 3 opções para compilar e executar o projeto:
    - Compile (apenas compila)
    - Execute (apenas executa)
    - Run (compila e executa)
