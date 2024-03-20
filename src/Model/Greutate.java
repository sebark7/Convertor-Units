package Model;

import java.util.ArrayList;
import java.util.List;

public class Greutate
{
    String miligrame, grame, kilograme, pound, ounce, grain, tona, carat;

    public List<String> returnareSirDenumiri()
    {
        List<String> sir = new ArrayList<String>();
        sir.add(getMiligrame());
        sir.add(getGrame());
        sir.add(getKilograme());
        sir.add(getTona());
        sir.add(getPound());
        sir.add(getOunce());
        sir.add(getGrain());
        sir.add(getCarat());
        return sir;
    }

    public Greutate()
    {
        miligrame = "mg";
        grame = "g";
        kilograme = "kg";
        tona = "ton";
        pound = "pd";
        ounce = "o";
        grain = "grain";
        carat = "carat";
    }

    public String getMiligrame()
    {
        return miligrame;
    }

    public String getGrame()
    {
        return grame;
    }

    public String getKilograme()
    {
        return kilograme;
    }

    public String getPound()
    {
        return pound;
    }

    public String getOunce()
    {
        return ounce;
    }

    public String getGrain()
    {
        return grain;
    }

    public String getTona()
    {
        return tona;
    }

    public String getCarat()
    {
        return carat;
    }
}
