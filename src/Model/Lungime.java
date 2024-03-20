package Model;

import java.util.ArrayList;
import java.util.List;

public class Lungime
{

    String milimetri, centrimetri, decimetri, metri, kilometri, inches, feet, yard, mile;

    public List<String> returnareSirDenumiri()
    {
        List<String> sir = new ArrayList<String>();
        sir.add(getMilimetri());
        sir.add(getCentrimetri());
        sir.add(getDecimetri());
        sir.add(getMetri());
        sir.add(getKilometri());
        sir.add(getInches());
        sir.add(getFeet());
        sir.add(getYard());
        sir.add(getMile());

        return sir;
    }
    public Lungime()
    {
        milimetri = "mm";
        centrimetri = "cm";
        decimetri = "dm";
        metri = "m";
        kilometri = "km";
        inches = "inch";
        feet = "ft";
        yard = "yd";
        mile = "mile";
    }

    public String getMilimetri()
    {
        return milimetri;
    }

    public String getCentrimetri()
    {
        return centrimetri;
    }

    public String getDecimetri()
    {
        return decimetri;
    }

    public String getMetri()
    {
        return metri;
    }

    public String getInches()
    {
        return inches;
    }

    public String getFeet()
    {
        return feet;
    }

    public String getYard()
    {
        return yard;
    }

    public String getMile()
    {
        return mile;
    }

    public String getKilometri()
    {
        return kilometri;
    }

}
