package com.example.yashthakor.bitsharer;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class send extends AppCompatActivity {
    private static String aladd[] = new String[5];
    private static int x = 0;int endofAddr;
    private static String connected[] = new String[30];
  private static ListView list_view;
 private static int j=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        //int s = x;
        //x = 0;

           // System.out.println(aladd[i]);
        new mytsk().execute("192.168.0");
        for(int k=0;k<x;k++){Toast.makeText(send.this,aladd[k],Toast.LENGTH_SHORT).show();}
    }
 private class mytsk extends AsyncTask<String,String,String>
 {
     @Override
     protected String doInBackground(String... params) {
         for ( endofAddr = 1; endofAddr < 15; endofAddr++) {
             try {
                 String addr = params + "." + endofAddr;Toast.makeText(send.this, addr.toString(), Toast.LENGTH_SHORT).show();
                 if (InetAddress.getByName(addr).isReachable(100)) {
                     Toast.makeText(send.this, addr + " found", Toast.LENGTH_SHORT).show();
                     aladd[x] = addr;
                     x++;
                 }
             } catch (IOException e) {
                 //e.printStackTrace();
             }
         }

         for(int ya=0;ya<x;ya++)
         {
             try {
                 Socket skt;
                 String asd = "Are you available??\n";
                 InetAddress addr = InetAddress.getByName(aladd[ya]);
                 skt = new Socket(addr, 3336);
                 OutputStream os = skt.getOutputStream();
                 OutputStreamWriter osw = new OutputStreamWriter(os);
                 BufferedWriter bw = new BufferedWriter(osw);

                 bw.write(asd);
                 bw.flush();

                 InputStream is = skt.getInputStream();

                 InputStreamReader isr = new InputStreamReader(is);

                 BufferedReader br = new BufferedReader(isr);

                 String b = br.readLine();
                 String re = "YES12";
                 int p = b.length();
                 int y = 0;
                 char c[] = re.toCharArray();
                 char d[] = b.toCharArray();
                 for (int i = 0; i < p; i++) { //System.out.println(c[i]+"  "+d[i]+" ");
                     if (c[i] == d[i]) {
                         y++;
                     }
                 }
                 //  System.out.println(p+"  "+y);
                 if (y == p) {
                     connected[j] = aladd[ya];
                     j++;//System.out.println("response from  "+abc);}

                 }


             } catch (Exception e) {
                 // System.out.println(e);
                 Toast.makeText(send.this,e.toString(),Toast.LENGTH_SHORT).show();

             }

         }

         return null;
     }
 }


    }



