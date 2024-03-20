package Model;

import java.util.ArrayList;
import java.util.List;

public class Volum
{
    String  centrimetricubi, decimetricubi, litru,
            inchicubi, feetcubi, yardcub, galon;


    public List<String> returnareSirDenumiri()
    {
        List<String> sir = new ArrayList<String>();
        sir.add(getCentrimetricubi());
        sir.add(getDecimetricubi());
        sir.add(getLitru());
        sir.add(getInchicubi());
        sir.add(getFeetcubi());
        sir.add(getYardcub());
        sir.add(getGalon());
        return sir;
    }


    public Volum()
    {
        centrimetricubi="cm3";
        decimetricubi="dm3";
        litru = "m3";
        inchicubi="inch3";
        feetcubi="ft3";
        yardcub="yard3";
        galon="gal";
    }


    public String getLitru()
    {
        return litru;
    }

    public String getCentrimetricubi()
    {
        return centrimetricubi;
    }

    public String getDecimetricubi()
    {
        return decimetricubi;
    }

    public String getInchicubi()
    {
        return inchicubi;
    }

    public String getFeetcubi()
    {
        return feetcubi;
    }

    public String getYardcub()
    {
        return yardcub;
    }

    public String getGalon()
    {
        return galon;
    }
}
