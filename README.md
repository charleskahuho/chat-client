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


# Internet Chat System

## Overview

This project implements a simple Internet Chat System using Java. The system consists of a central server and multiple clients. Clients can join and leave the chat at any time, and messages sent by any client are broadcast to all connected clients. Each client is identified by a nickname.

## Functional Requirements

1. **Multiple Client Connections:** Supports multiple remote clients connecting to a single central server.
2. **Message Delivery:** Delivers messages entered by a client to all connected clients, including the sender.
3. **Join and Leave Anytime:** Allows users to join and leave the chat at any time.
4. **User Nicknames:** Users choose nicknames when joining, which appear with their messages. The server address must be specified when running the client.

## Non-Functional Requirements

1. **Platform:** Preferably implemented under Linux.
2. **Interface:** The client runs in a single text-mode window for simplicity.
3. **Buffered Messages:** Buffers incoming messages while the user is typing to avoid overlap and displays them once the user has sent their message.
4. **Robustness:** The system must be robust concerning client crashes or blocked connections. Issues with a single client should not affect other users.

## Implementation

The project includes a TCP-based Java implementation for both the client and server. The implementation ensures robustness, well-written code, and proper comments.

### Server

The server listens for client connections and handles each connection in a separate thread. Messages from any client are broadcast to all connected clients.

#### Key Points from `ChatServer.java`

1. **Port Configuration:** The server runs on port 12345.
2. **Client Management:** Uses a set to manage connected clients.
3. **Connection Handling:** Accepts client connections and starts a new thread for each client.
4. **Message Broadcasting:** Sends incoming messages to all connected clients.

### Client

The client connects to the server, allows the user to input their nickname, and sends messages to the server. A separate thread reads messages from the server and displays them.

#### Key Points from `ChatClient.java`

1. **Server Address and Port:** Connects to the server running on localhost at port 12345.
2. **User Nickname:** Prompts the user to enter a nickname on startup.
3. **Message Sending:** Reads user input and sends messages to the server prefixed with the user's nickname.
4. **Message Reading:** Runs a separate thread to read and display messages from the server.

## How to Run

### Server

1. Compile the server code:
   ```sh
   javac ChatServer.java
2. Run the server:
    ```sh
    java ChatServer
### Client

1. Compile client code:
    ```sh
    javac ChatClient.java
2. Run the Client code:
    ```json
    java ChatClient
## Note

1. Ensure server is running before starting any clients
2. Clients can join and leave the chat anytime
3. Message from one client are transmitted to all other clients


## Authors

1. **Charles Kahuho**
2. 
