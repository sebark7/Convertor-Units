package Model;

import java.util.ArrayList;
import java.util.List;

public class Presiune
{
    String pascal, kilopascal, bar, psi;

    public Presiune()
    {
        pascal = "Pa";
        kilopascal = "kPa";
        bar = "bar";
        psi = "psi";
    }

    public List<String> returnareSirDenumiri()
    {
        List<String> sir = new ArrayList<String>();
        sir.add(getPascal());
        sir.add(getKilopascal());
        sir.add(getBar());
        sir.add(getPsi());
        return sir;
    }

    public String getPascal()
    {
        return pascal;
    }

    public String getKilopascal()
    {
        return kilopascal;
    }

    public String getBar()
    {
        return bar;
    }

    public String getPsi()
    {
        return psi;
    }
}
