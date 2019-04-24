package com.javarush.task.task40.task4005;


import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/* 
Create ObjectOutputStream Before ObjectInputStream
If you are writing code that transmits data bidirectionally using ObjectInputStream and ObjectOutputStream, be careful to construct the ObjectOutputStream first.
If you instead construct the ObjectInputStream first, both ends will block and eventually fail in the constructor. This is because the input stream constructor waits for an initial string of bytes to arrive from the ObjectOutputStream open(). In the unidirectional case, where one side is writing and the other is reading, everything goes smoothly. However in the bidirectional case, if both sides attempt to construct the input stream first, both are waiting for the other to construct the output stream, and neither can proceed.

If your exception handling allows communications to proceed after constructing the input stream fails, then the symptoms of this problem are that both sides block for a period of time, one gets the exception and proceeds to construct the ObjectOutputStream. The other end then is able to construct its ObjectInputStream, since the initialization sequence just arrived.

Fortunately the fix is straightforward. Move the creation of the ObjectOutputStream before that of the ObjectInputStream. Then each end will transmit the initialization sequence before trying to open its input stream. The initialization sequence is ready and waiting, so the construction of the input stream goes normally, and object transfers can then commence without any delay.
*/

public class Connection implements Closeable {
    private final Socket socket;
    private final ObjectInputStream in;
    private final ObjectOutputStream out;

    public Connection(Socket socket) throws Exception {
        this.socket = socket;
	    this.out = new ObjectOutputStream(socket.getOutputStream());
        this.in = new ObjectInputStream(socket.getInputStream());
    }

    public void send(String message) throws Exception {
        out.writeObject(message);
        //out.flush();
    }

    public String receive() throws Exception {
        return (String) in.readObject();
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
        socket.close();
    }
}
