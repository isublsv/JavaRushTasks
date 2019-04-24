package com.javarush.task.task40.task4006;

import java.io.*;
import java.net.Socket;
import java.net.URL;

/* 
Отправка GET-запроса через сокет
*/

public class Solution {
	public static void main(String[] args) throws Exception {
		getSite(new URL("http://javarush.ru/social.html"));
	}

	public static void getSite(URL url) {
		try {
			Socket socket = new Socket(url.getHost(), url.getDefaultPort());
			OutputStream out = socket.getOutputStream();
			PrintWriter printWriter = new PrintWriter(out, true);
			printWriter.println("GET " + url.getFile() + " " + url.getProtocol() + "/1.1");
			printWriter.println("HOST: " + url.getHost());
			printWriter.println("");

			printWriter.flush();

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String responseLine;

			while ((responseLine = bufferedReader.readLine()) != null) {
				System.out.println(responseLine);
			}
			bufferedReader.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}