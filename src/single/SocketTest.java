package single;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketTest {
    private static final int PORT=9999;
    private List<Socket> mList=new LinkedList<>();
    private ServerSocket server=null;
    private ExecutorService mExecutorService=null;
    private String receiveMsg=null;
    private String sendMsg;

    public static void main(String[] args) {
         new SocketTest();
    }
    public SocketTest(){
        try {
            server=new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mExecutorService=Executors.newCachedThreadPool();
        System.out.println("service is running...");
        Socket client=null;
        while (true){
            try {
                client=server.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mList.add(client);
            mExecutorService.execute(new Service(client));
        }

    }
    class Service implements Runnable{
        Socket socket;
        BufferedReader in=null;
        PrintWriter printWriter=null;

        public Service(Socket socket){
            this.socket=socket;
            try {
                printWriter=new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8")),true);
                in=new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
                printWriter.println("成功连接服务器"+"(服务器发送)");
                System.out.println("成功连接服务器");


            }catch (Exception e){
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                while (true) {                                   //循环接收、读取 Client 端发送过来的信息
                    if ((receiveMsg = in.readLine()) != null) {
                        System.out.println("receiveMsg:" + receiveMsg);
                        if (receiveMsg.equals("0")) {
                            System.out.println("客户端请求断开连接");
                            printWriter.println("服务端断开连接" + "（服务器发送）");
                            mList.remove(socket);
                            in.close();
                            socket.close();                         //接受 Client 端的断开连接请求，并关闭 Socket 连接
                            break;
                        } else {
                            sendMsg = "我已接收：" + receiveMsg + "（服务器发送）";
                            printWriter.println(sendMsg);           //向 Client 端反馈、发送信息
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
