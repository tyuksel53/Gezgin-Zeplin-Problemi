import Ekran.EkraniOlustur;
import Kütüphane.Portal;
import Model.Node;

import java.util.ArrayList;

public class Main {

    public static ArrayList<Node> grafDugumler = null;

    public static void main(String argms[])
    {
        /*new EkraniOlustur();*/

        Portal myPortal = Portal.getInstance();

        grafDugumler = myPortal.dogumleriTanimla();
        String zundi = "";
    }
}
