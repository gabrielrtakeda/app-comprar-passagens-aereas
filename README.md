Instruções para compilar e rodar o App:

Windows:
 * Ter o git instalado na máquina
```
git clone https://github.com/gabrielrtakeda/project
cd project
```

 * Compilar o arquivo
```
dir /s /B *.java > sources.txt
javac -d binary/ @sources.txt
```

 * Rodar o app;
```
java -cp binary/ project.Main
```
