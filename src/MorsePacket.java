import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.io.Serializable;

public class MorsePacket implements Serializable {
    String naturallanguage="";
    String Morsesignal="";

    public String getNaturallanguage() {
        return naturallanguage;
    }

    public void setNaturallanguage(String naturallanguage) {
        this.naturallanguage = naturallanguage;
    }

    public String getMorsesignal() {
        return Morsesignal;
    }

    public void setMorsesignal(String morsesignal) {
        Morsesignal = morsesignal;
    }
}
