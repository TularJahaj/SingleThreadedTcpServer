package com.company;

/**
 * Created by TularJahaj on 3/22/2017.
 */
public interface ServerListener {
    public void onNewClientJoin(int id,String name);
    public void onClientLeft(int id,String name);
    public void onNewMessage(int id, String s);

}
