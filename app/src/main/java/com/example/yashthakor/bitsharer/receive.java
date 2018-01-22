package com.example.yashthakor.bitsharer;

import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.net.*;
import java.io.*;
import android.widget.Toast;
public class receive extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_receive);
         new Mytask().execute("https://www.google.com");

    }

    private  class Mytask extends AsyncTask<String, Void, Void>
    {
        @Override
        protected Void doInBackground(String... params) {
            Socket skt;
            Toast.makeText(receive.this,"Server started and listing to port no 3336",Toast.LENGTH_SHORT).show();

            try {

                ServerSocket sskt = new ServerSocket(33356);
                Toast.makeText(receive.this,"Server started and listing to port no 3336",Toast.LENGTH_SHORT).show();
                while (true) {
                    skt = sskt.accept();
                    //System.out.println("accepted..");
                    //Toast.makeText(receive.this,"ACCEPTED",Toast.LENGTH_SHORT).show();

                    InputStream is = skt.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(isr);
                    String m1 = br.readLine();
                   // Toast.makeText(receive.this,"MESSAGE RECEIVED",Toast.LENGTH_SHORT).show();

                    //System.out.println("Message received from client: "+m1);

                    char[] c = m1.toCharArray();
                    String str = "";
                    // System.out.println("1...");
                    String a1 = new String("Are you available??");
                    //System.out.println("2...");
                    char d[] = a1.toCharArray();
                    //System.out.println("1...");
                    int p = m1.length();
                    //System.out.println("2...");
                    int y = 0;
                    for (int i = 0; i < p; i++) {
                        if (c[i] == d[i]) {
                            y++;
                        }
                    }
                    //System.out.println(p + "  " + y);
                    //System.out.println("1...");
                    if (y == p) {
                        str = "YES12\n";//System.out.println("accepted..yes");
                    } else {
                        str = "NO12";//System.out.println("accepted..no");}
                        OutputStream os = skt.getOutputStream();
                        OutputStreamWriter osw = new OutputStreamWriter(os);
                        BufferedWriter bw = new BufferedWriter(osw);
                        bw.write(str);
                        bw.flush();
                        // System.out.println("Message sent to client: "+str);
                        break;
                    }
                }

            } catch (Exception e) {
                Toast.makeText(receive.this,e.toString(),Toast.LENGTH_SHORT).show();
            }return  null;
        }

        @Override
        protected void  onPostExecute(Void aVoid) {
            Toast.makeText(receive.this,"Server started and listing to port no 3336",Toast.LENGTH_SHORT).show();

            super.onPostExecute(aVoid);
        }
    }

}
