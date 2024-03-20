package Model;

import java.util.ArrayList;
import java.util.List;

public class Timp
{
    String secunda, minut, ora, zi ,luna;

    public List<String> returnareSirDenumiri()
    {
        List<String> sir = new ArrayList<String>();
        sir.add(getSecunda());
        sir.add(getMinut());
        sir.add(getOra());
        sir.add(getZi());
        sir.add(getLuna());
        return sir;
    }

    public Timp()
    {
        secunda = "sec";
        minut = "min";
        ora = "h";
        zi = "day";
        luna = "month";
    }

    public String getSecunda()
    {
        return secunda;
    }

    public String getMinut()
    {
        return minut;
    }

    public String getOra()
    {
        return ora;
    }

    public String getZi()
    {
        return zi;
    }

    public String getLuna()
    {
        return luna;
    }
}
