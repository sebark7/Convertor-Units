package Model;

import java.util.ArrayList;
import java.util.List;

public class Energie
{
    String joule, kilojoule, kilowattHour, wattHour;

    public Energie()
    {
        joule = "J";
        kilojoule = "kJ";
        kilowattHour = "kWh";
        wattHour = "Wh";
    }

    public List<String> returnareSirDenumiri()
    {
        List<String> sir = new ArrayList<String>();
        sir.add(getJoule());
        sir.add(getKilojoule());
        sir.add(getKilowattHour());
        sir.add(getWattHour());
        return sir;
    }

    public String getJoule()
    {
        return joule;
    }

    public String getKilojoule()
    {
        return kilojoule;
    }

    public String getKilowattHour()
    {
        return kilowattHour;
    }

    public String getWattHour()
    {
        return wattHour;
    }
}
