package Model;

import java.util.ArrayList;
import java.util.List;

public class Moneda
{

    String ron, euro, francElvetian, dolar, yenJaponez;

    public List<String> returnareSirDenumiri()
    {
        List<String> sir = new ArrayList<String>();
        sir.add(getRon());
        sir.add(getDolar());
        sir.add(getEuro());
        sir.add(getFrancElvetian());
        sir.add(getYenJaponez());
        return sir;
    }
    public Moneda()
    {
        ron = "RON";
        euro = "EUR";
        francElvetian = "CHF";
        dolar = "USD";
        ron = "JPY";
    }

    public String getRon()
    {
        return ron;
    }

    public String getEuro()
    {
        return euro;
    }

    public String getFrancElvetian()
    {
        return francElvetian;
    }

    public String getDolar()
    {
        return dolar;
    }

    public String getYenJaponez()
    {
        return yenJaponez;
    }
}
