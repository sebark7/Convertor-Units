package Model;

import java.util.ArrayList;
import java.util.List;

public class Forta
{
    String newton, kilonewton, gramForce, kilogramForce;

    public Forta()
    {
        newton = "N";
        kilonewton = "kN";
        gramForce = "gf";
        kilogramForce = "kgf";
    }

    public List<String> returnareSirDenumiri()
    {
        List<String> sir = new ArrayList<String>();
        sir.add(getNewton());
        sir.add(getKilonewton());
        sir.add(getGramForce());
        sir.add(getKilogramForce());
        return sir;
    }

    public String getNewton()
    {
        return newton;
    }

    public String getKilonewton()
    {
        return kilonewton;
    }

    public String getGramForce()
    {
        return gramForce;
    }

    public String getKilogramForce()
    {
        return kilogramForce;
    }
}
