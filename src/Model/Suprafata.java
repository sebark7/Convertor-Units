package Model;

import java.util.ArrayList;
import java.util.List;

public class Suprafata
{
    String  centrimetrupatrat, metrupatrat, kilometrupatrat, incipatrat,
            feetpatrat, yardpatrat, acru, milapatrata;

    public List<String> returnareSirDenumiri()
    {
        List<String> sir = new ArrayList<String>();
        sir.add(getCentrimetrupatrat());
        sir.add(getMetrupatrat());
        sir.add(getKilometrupatrat());
        sir.add(getIncipatrat());
        sir.add(getFeetpatrat());
        sir.add(getYardpatrat());
        sir.add(getAcru());
        return sir;
    }

    public Suprafata()
    {
        centrimetrupatrat = "cm2";
        metrupatrat = "m2";
        kilometrupatrat = "km2";
        incipatrat = "inch2";
        feetpatrat = "ft2";
        yardpatrat = "yd2";
        acru = "ac2";
        milapatrata = "mile2";
    }

    public String getCentrimetrupatrat()
    {
        return centrimetrupatrat;
    }

    public String getMetrupatrat()
    {
        return metrupatrat;
    }

    public String getIncipatrat()
    {
        return incipatrat;
    }

    public String getFeetpatrat()
    {
        return feetpatrat;
    }

    public String getYardpatrat()
    {
        return yardpatrat;
    }

    public String getKilometrupatrat()
    {
        return kilometrupatrat;
    }

    public String getAcru()
    {
        return acru;
    }

    public String getMilapatrata()
    {
        return milapatrata;
    }
}
