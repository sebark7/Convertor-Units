package Model;

import java.util.ArrayList;
import java.util.List;

public class Putere
{

    String watt, megawatt, kilowatt, hectowatt;

    public Putere()
    {
        watt = "W";
        megawatt = "MW";
        kilowatt = "kW";
        hectowatt = "hW";
    }

    public List<String> returnareSirDenumiri()
    {
        List<String> sir = new ArrayList<String>();
        sir.add(getWatt());
        sir.add(getMegawatt());
        sir.add(getKilowatt());
        sir.add(getHectowatt());
        return sir;
    }

    public String getWatt()
    {
        return watt;
    }

    public String getMegawatt()
    {
        return megawatt;
    }

    public String getKilowatt()
    {
        return kilowatt;
    }

    public String getHectowatt()
    {
        return hectowatt;
    }
}
