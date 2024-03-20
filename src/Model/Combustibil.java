package Model;

import java.util.ArrayList;
import java.util.List;

public class Combustibil
{
    String metruLitru, metruGalon, kilometruLitru, mileGalon;

    public Combustibil()
    {
        metruLitru = "m/l";
        metruGalon = "m/gal";
        kilometruLitru = "km/gal";
        mileGalon = "mile/gal";
    }

    public List<String> returnareSirDenumiri()
    {
        List<String> sir = new ArrayList<String>();
        sir.add(getMetruLitru());
        sir.add(getMetruGalon());
        sir.add(getKilometruLitru());
        sir.add(getMileGalon());
        return sir;
    }

    public String getMetruLitru()
    {
        return metruLitru;
    }

    public String getMetruGalon()
    {
        return metruGalon;
    }

    public String getKilometruLitru()
    {
        return kilometruLitru;
    }

    public String getMileGalon()
    {
        return mileGalon;
    }
}
