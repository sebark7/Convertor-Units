package Model;

import java.util.ArrayList;
import java.util.List;

public class Viteza
{
    String kilometriOra, kilometriSecunda, metriSecunda, metriOra, mileOra;

    public List<String> returnareSirDenumiri()
    {
        List<String> sir = new ArrayList<String>();
        sir.add(getKilometriOra());
        sir.add(getKilometriSecunda());
        sir.add(getMetriSecunda());
        sir.add(getMetriOra());
        sir.add(getMileOra());
        return sir;
    }

    public Viteza()
    {
        kilometriOra = "km/h";
        kilometriSecunda = "km/s";
        metriSecunda = "m/s";
        metriOra = "m/h";
        mileOra = "mph";
    }

    public String getKilometriOra()
    {
        return kilometriOra;
    }

    public String getKilometriSecunda()
    {
        return kilometriSecunda;
    }

    public String getMetriSecunda()
    {
        return metriSecunda;
    }

    public String getMetriOra()
    {
        return metriOra;
    }

    public String getMileOra()
    {
        return mileOra;
    }

}
