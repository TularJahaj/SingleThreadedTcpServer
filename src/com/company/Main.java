package com.company;


import com.company.gui.GUI;
import com.company.gui.GuiListener;

import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by TularJahaj on 3/23/2017.
 */
public class Main {
    public static void main(String[] args) {

        GUI gui=new GUI();
        gui.createGui();
        gui.titleLabel.setText("TCP Server");

        TcpServer tcpServer = new TcpServer();

        tcpServer.setServerListener(new ServerListener() {
            @Override
            public void onNewClientJoin(int id, String name) {
                gui.display("New Client joined:"+id+": "+name);
            }

            @Override
            public void onClientLeft(int id, String name) {
                gui.display("Client left:"+id+": "+name);
            }

            @Override
            public void onNewMessage(int id, String s) {
                gui.display("Message from "+id+": " + s);
            }
        });


        gui.setGuiListener(new GuiListener() {
            @Override
            public void onClickSend( String s) {

                OutputStreamWriter outputStreamWriter = tcpServer.getOutputStreamById();

                if(outputStreamWriter==null){
                    System.out.println("Client need to send ID:id:name statement first");
                    return;
                }

                try {
                    outputStreamWriter.write(">> "+s + "\n"); //our client expect '\n' at the end
                    outputStreamWriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                    gui.display(e.toString());
                }
            }
        });


        tcpServer.startListening(5720);

    }
}
