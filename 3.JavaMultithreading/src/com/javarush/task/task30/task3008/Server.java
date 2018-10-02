package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt())) {
            ConsoleHelper.writeMessage("Server started");
            while (true) {
                Handler h = new Handler(serverSocket.accept());
                h.start();
            }
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Error");
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            if (socket != null && socket.getRemoteSocketAddress() != null) {
                ConsoleHelper.writeMessage("User connected " + socket.getRemoteSocketAddress());
            }
            String userName = null;
            try (Connection connection = new Connection(socket)){
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Server error");
            } finally {
                if (userName != null) {
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                }
                ConsoleHelper.writeMessage("Connection closed");
            }

        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message m = connection.receive();
                if (m.getType().equals(MessageType.USER_NAME)) {
                    if (!m.getData().isEmpty())
                        if (!connectionMap.containsKey(m.getData())) {
                            connectionMap.put(m.getData(), connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            return m.getData();
                        }
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (String s : connectionMap.keySet()) {
                if (!s.equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, s));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message m = connection.receive();
                if (m.getType() == MessageType.TEXT)
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + m.getData()));
                else ConsoleHelper.writeMessage("Received message is not a text");
            }
        }

    }

    public static void sendBroadcastMessage(Message message) {
        for (Connection connection : connectionMap.values())
            try {
                connection.send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Cant send the message");
            }
    }
}
