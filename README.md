# MR-Chat

## Chat usando sockets

### Implementação de um chat usando sockets

* Trabalho em dupla
* Linguagem de programação livre (em alguns casos, pedirei que me explique)
* O chat poderá ser simples, onde os dois comunicantes enviam e recebem mensagens

### Como Rodar o Projeto

#### Com Make (Linux)

1. Entre na pasta do projeto.
2. Crie uma pasta como o nome "bin", execute: **# make create_folder_build**
3. Compile as classe executando: **# make compile_socket_chat**
4. Entre na pasta "bin": **# cd bin**
5. Execute o servidor: **# java br.com.mrchat.AppServer**
6. Execute o(s) clientes(s): **# java br.com.mrchat.AppClient**. **obs: execute vários em diferentes terminais**

#### Manual

1. Entre na pasta do projeto.
2. Crie uma pasta como o nome "bin": **# mkdir bin**
3. Compile executando no terminal: **# javac -d bin -sourcepath src src/br/com/mrchat/AppServer.java src/br/com/mrchat/AppClient.java**
4.  Entre na pasta "bin": **# cd bin**
5.  Execute o servidor: **# java br.com.mrchat.AppServer**
6.  Execute o(s) clientes(s): **# java br.com.mrchat.AppClient**. **obs: execute vários em diferentes terminais**

</br>
</br>

-----

## Chat usando gRPC

#### Implementação de um chat usando gRPC

* Trabalho em dupla
* Linguagem de programação livre (em alguns casos, pedirei que me explique)
* O chat poderá ser simples, onde os dois comunicantes enviam e recebem mensagens

</br>
</br>

## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
