import java.io.ObjectInputStream;    //　入出力関連パッケージを利用する
import java.io.ObjectOutputStream;
import java.net.ServerSocket;    //ネットワーク関連のパッケージを利用する
import java.net.Socket;
import java.util.HashMap;

public class MorseServer {
    /*メイン・メソッド
     * 接続要求のあったクライアントに対して接続を行い
     * クライアントから送られる年齢を受信し、その年齢を元に
     * 飲酒の可否を判定した結果をクライアントに対して送信する
     */
    public static void main(String arg[]) {
        try {
            /* 通信の準備をする */
            ServerSocket server =
                    new ServerSocket(5002);        //ポート番号を指定し、クライアントとの接続の準備を行う
            System.out.println("server is waiting present at 5002");

            Socket socket = server.accept();    //クライアントからの接続要求を待ち、
            // 要求があればソケットを取得し接続を行う
            System.out.println("connected");

            /* 年齢を受信する */
            ObjectInputStream ois =
                    new ObjectInputStream(socket.getInputStream());


            MorsePacket receivepacket = (MorsePacket) ois.readObject();

            String naturallanguage = receivepacket.getNaturallanguage();
            String morsesignal = receivepacket.getMorsesignal();
            String outputnatural = "";
            String outputmorse = "";
            System.out.println("受信した自然言語は" + naturallanguage);
            System.out.println("受信したモールス信号" + morsesignal);

            /*
            入力された言語、又はモールス信号を変換する。
             */
            HashMap<String, String> languageToMorse = new HashMap<String, String>();
            HashMap<String, String> morseToLanguage = new HashMap<String, String>();

            /*自然言語からモールス信号へ*/
            languageToMorse.put("あ", "－－・－－");
            languageToMorse.put("い", "・－");
            languageToMorse.put("う", "・・－");
            languageToMorse.put("え", "－・－－－");
            languageToMorse.put("お", "・－・・・");

            languageToMorse.put("か", "・－・・");
            languageToMorse.put("き", "－・－・・");
            languageToMorse.put("く", "・・・－");
            languageToMorse.put("け", "－・－－");
            languageToMorse.put("こ", "－－－－");

            languageToMorse.put("さ", "－・－・－");
            languageToMorse.put("し", "－－・－・");
            languageToMorse.put("す", "－－－・－");
            languageToMorse.put("せ", "・－－－・");
            languageToMorse.put("そ", "－－－・");

            languageToMorse.put("た", "－・");
            languageToMorse.put("ち", "・・－・");
            languageToMorse.put("つ", "・－－・");
            languageToMorse.put("て", "・－・－－");
            languageToMorse.put("と", "・・－・・");

            languageToMorse.put("な", "・－・");
            languageToMorse.put("に", "－・－・");
            languageToMorse.put("ぬ", "・・・・");
            languageToMorse.put("ね", "－－・－");
            languageToMorse.put("の", "・・－－");

            languageToMorse.put("は", "－・・・");
            languageToMorse.put("ひ", "－－・・－");
            languageToMorse.put("ふ", "－－・・");
            languageToMorse.put("へ", "・");
            languageToMorse.put("ほ", "－・・");

            languageToMorse.put("ま", "－・・－");
            languageToMorse.put("み", "・・－・－");
            languageToMorse.put("む", "－");
            languageToMorse.put("め", "－・・・－");
            languageToMorse.put("も", "－・・－・");

            languageToMorse.put("や", "・－－");
            languageToMorse.put("ゆ", "－・・－－");
            languageToMorse.put("よ", "－－");

            languageToMorse.put("ら", "・・・");
            languageToMorse.put("り", "－－・");
            languageToMorse.put("る", "－・－－・");
            languageToMorse.put("れ", "－－－");
            languageToMorse.put("ろ", "・－・－");

            languageToMorse.put("わ", "－・－");
            languageToMorse.put("を", "・－－－");
            languageToMorse.put("ん", "・－・－・");


            /*モールス信号から自然言語へ*/
            morseToLanguage.put("－－・－－", "あ");
            morseToLanguage.put("・－", "い");
            morseToLanguage.put("・・－", "う");
            morseToLanguage.put("－・－－－", "え");
            morseToLanguage.put("・－・・・", "お");

            morseToLanguage.put("・－・・", "か");
            morseToLanguage.put("－・－・・", "き");
            morseToLanguage.put("・・・－", "く");
            morseToLanguage.put("－・－－", "け");
            morseToLanguage.put("－－－－", "こ");

            morseToLanguage.put("－・－・－", "さ");
            morseToLanguage.put("－－・－・", "し");
            morseToLanguage.put("－－－・－", "す");
            morseToLanguage.put("・－－－・", "せ");
            morseToLanguage.put("－－－・", "そ");

            morseToLanguage.put("－・", "た");
            morseToLanguage.put("・・－・", "ち");
            morseToLanguage.put("・－－・", "つ");
            morseToLanguage.put("・－・－－", "て");
            morseToLanguage.put("・・－・・", "と");

            morseToLanguage.put("・－・", "な");
            morseToLanguage.put("－・－・", "に");
            morseToLanguage.put("・・・・", "ぬ");
            morseToLanguage.put("－－・－", "ね");
            morseToLanguage.put("・・－－", "の");

            morseToLanguage.put("－・・・", "は");
            morseToLanguage.put("－－・・－", "ひ");
            morseToLanguage.put("－－・・", "ふ");
            morseToLanguage.put("・", "へ");
            morseToLanguage.put("－・・", "ほ");

            morseToLanguage.put("－・・－", "ま");
            morseToLanguage.put("・・－・－", "み");
            morseToLanguage.put("－", "む");
            morseToLanguage.put("－・・・－", "め");
            morseToLanguage.put("－・・－・", "も");

            morseToLanguage.put("・－－", "や");
            morseToLanguage.put("－・・－－", "ゆ");
            morseToLanguage.put("－－", "よ");

            morseToLanguage.put("・・・", "ら");
            morseToLanguage.put("－－・", "り");
            morseToLanguage.put("－・－－・", "る");
            morseToLanguage.put("－－－", "れ");
            morseToLanguage.put("・－・－", "ろ");

            morseToLanguage.put("－・－", "わ");
            morseToLanguage.put("・－－－", "を");
            morseToLanguage.put("・－・－・", "ん");
            //自然言語からモールス信号への変換
            String[] naturalArray = naturallanguage.split("");
            StringBuilder sb = new StringBuilder();
            for (String s : naturalArray) {
                sb.append(languageToMorse.get(s));
            }
            outputmorse = new String(sb);

            //モールス信号から自然言語への変換
            String[] morseArray = naturallanguage.split("");
            StringBuilder sbm = new StringBuilder();
            for (String s : naturalArray) {
                sbm.append(languageToMorse.get(s));
            }
            outputmorse = new String(sbm);

            /* 判定結果をクライアントに送信する */
            ObjectOutputStream oos =
                    new ObjectOutputStream(socket.getOutputStream());


            MorsePacket sendpacket = new MorsePacket();
            sendpacket.setNaturallanguage(outputnatural);
            sendpacket.setMorsesignal(outputmorse);

            oos.writeObject(sendpacket);
            oos.flush();


            //close処理

            oos.close();
            ois.close();
            //socketの終了。
            socket.close();
            server.close();

        }// エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("エラーが発生したのでプログラムを終了します");
        }
    }
}
