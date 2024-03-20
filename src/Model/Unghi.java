package Model;

import java.util.ArrayList;
import java.util.List;

public class Unghi
{
    String degree, radian, grad, minute;

    public Unghi()
    {
        degree = "degree°";
        radian = "rad";
        grad = "grad[^]";
        minute = "minute[']";
    }

    public List<String> returnareSirDenumiri()
    {
        List<String> sir = new ArrayList<String>();
        sir.add(getDegree());
        sir.add(getRadian());
        sir.add(getGrad());
        sir.add(getMinute());
        return sir;
    }

    public String getDegree()
    {
        return degree;
    }

    public String getRadian()
    {
        return radian;
    }

    public String getGrad()
    {
        return grad;
    }

    public String getMinute()
    {
        return minute;
    }
}
