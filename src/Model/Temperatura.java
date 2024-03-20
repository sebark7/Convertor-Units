package Model;

import java.util.ArrayList;
import java.util.List;

public class Temperatura
{
    String celsius, kelvin, farenheit;

    public List<String> returnareSirDenumiri()
    {
        List<String> sir = new ArrayList<String>();
        sir.add(getCelsius());
        sir.add(getFarenheit());
        sir.add(getKelvin());
        return sir;
    }
    public Temperatura()
    {
        celsius = "°C";
        farenheit = "°F";
        kelvin = "°K";
    }

    public String getCelsius()
    {
        return celsius;
    }

    public String getKelvin()
    {
        return kelvin;
    }

    public String getFarenheit()
    {
        return farenheit;
    }
}
