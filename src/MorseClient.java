import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MorseClient {

    public static void main(String arg[]) {
        try {
            /* 通信の準備をする */
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Server name(localhost or 133.27.....)? >");
            String serverName = reader.readLine();
            Socket socket = new Socket(serverName, 5002);

            /* キーボードから年齢を読み込む */
            System.out.print("変更する文章を入力してください。現在はひらがなのみ対応しています。");

            String lineStr = reader.readLine();

            /* サーバに文字列を送信する */
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            MorsePacket morse = new MorsePacket();
            morse.setNaturallanguage(lineStr);
            oos.writeObject(morse);
            oos.flush();

            /* サーバから判定結果を受信する */
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            //String result = (String)ois.readObject();//返事を文字列型でキャストする。

            MorsePacket responsePacket = (MorsePacket) ois.readObject();
            String replaynaturallanguage = responsePacket.getNaturallanguage();
            String replaymorsesignal = responsePacket.getMorsesignal();

            System.out.println("自然言語:" + replaynaturallanguage);
            System.out.println("モールス信号:" + replaymorsesignal);

            oos.close();
            ois.close();

            socket.close();

        }// エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (java.net.UnknownHostException uhe) {
            uhe.printStackTrace();
            System.err.println("送信先のサーバ名が間違っているのでプログラムを終了します");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("エラーが発生したのでプログラムを終了します");
        }
    }
}
