package Model;

import java.util.ArrayList;
import java.util.List;

public class Date
{
    String bit, byyte, kilobyte, megabyte, gigabyte, terrabyte;

    public Date()
    {
        bit = "b";
        byyte = "B";
        kilobyte = "kB";
        megabyte = "MB";
        gigabyte = "GB";
        terrabyte = "TB";
    }

    public List<String> returnareSirDenumiri()
    {
        List<String> sir = new ArrayList<String>();
        sir.add(getBit());
        sir.add(getByyte());
        sir.add(getKilobyte());
        sir.add(getMegabyte());
        sir.add(getGigabyte());
        sir.add(getTerrabyte());
        return sir;
    }

    public String getBit()
    {
        return bit;
    }

    public String getByyte()
    {
        return byyte;
    }

    public String getKilobyte()
    {
        return kilobyte;
    }

    public String getMegabyte()
    {
        return megabyte;
    }

    public String getGigabyte()
    {
        return gigabyte;
    }

    public String getTerrabyte()
    {
        return terrabyte;
    }
}
