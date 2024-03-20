package Model;

import java.util.ArrayList;
import java.util.List;

public class Gatit
{
    String cup, tablespoon, gram, kilogram;

    public Gatit()
    {
        cup = "cup";
        tablespoon = "tablespoon";
        gram = "g";
        kilogram = "kg";
    }

    public List<String> returnareSirDenumiri()
    {
        List<String> sir = new ArrayList<String>();
        sir.add(getCup());
        sir.add(getTablespoon());
        sir.add(getGram());
        sir.add(getKilogram());
        return sir;
    }

    public String getCup()
    {
        return cup;
    }

    public String getTablespoon()
    {
        return tablespoon;
    }

    public String getGram()
    {
        return gram;
    }

    public String getKilogram()
    {
        return kilogram;
    }
}
