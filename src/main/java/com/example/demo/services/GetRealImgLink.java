/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.services;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.util.ByteArrayBuffer;

/**
 *
 * @author Alex
 */
public class GetRealImgLink {

    public static String getRealLink(String id) throws IOException {

        Socket socket = null;
        BufferedWriter wr = null;
        byte[] buffer = new byte[800];
        try {
            InetSocketAddress address = new InetSocketAddress(InetAddress.getByName("drive.google.com"), 443);

//            Proxy socksProxy
//                    = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress("127.0.0.1", 1101));
//            socket = new Socket(socksProxy);
            socket = new Socket();
            socket.connect(address);
            SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(socket, address.getHostName(), address.getPort(), true);
            sslSocket.startHandshake();
            wr = new BufferedWriter(new OutputStreamWriter(sslSocket.getOutputStream(), "UTF8"));
            String str
                    = "GET /file/d/"+id+"/view?usp=drive_link HTTP/1.0\r\n"
                    + "Host: drive.google.com\r\n"
                    + "Connection: keep-alive\r\n"
                    + "Cache-Control: max-age=0\r\n"
                    + "Upgrade-Insecure-Requests: 1\r\n"
                    + "User-Agent: Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36\r\n"
                    + "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3\r\n"
                    + "Accept-Language: en-US,en;q=0.9\r\n\r\n";
            wr.write(str);
            wr.flush();
            String queryResult = "";
            BufferedInputStream bis = new BufferedInputStream(sslSocket.getInputStream());
            ByteArrayBuffer baf = new ByteArrayBuffer(50);
            int read = 0;
            while (true) {
                read = bis.read(buffer);
                if (read == -1) {
                    break;
                }
                baf.append(buffer, 0, read);
            }
            Pattern pattern = null;
            Matcher matcher = null;
            pattern = Pattern.compile("drive-viewer\\/(.*?)\\\\");
            matcher = pattern.matcher(new String(baf.toByteArray()));
            
            if (matcher.find()) {
                queryResult = matcher.group(1);
                queryResult = "https://lh3.googleusercontent.com/drive-viewer/"+queryResult+"=w8000-rw-v1";
            }
            return queryResult;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (wr != null) {
                wr.close();
            }
            if (socket != null) {
                socket.close();
            }

        }
        return "";
    }
}
