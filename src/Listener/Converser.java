package Listener;

import Model.Tuple;
import org.apache.commons.lang3.ArrayUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.prefs.Preferences;

public class Converser
{
    private final String[] greutateList = {"mg", "g", "kg", "ton", "pd", "o", "grain", "carat"};

    private final String[] lungimeList = {"mm", "cm", "dm", "m", "km", "inch", "ft", "yard",
            "mile"};

    private final String[] suprafataList = {"cm2", "m2", "km2", "inch2", "ft2", "yd2", "ac2",
            "mile2"};

    private final String[] volumList = {"cm3", "dm3", "m3", "inch3", "ft3", "yard3", "gal"};

    private final String[] monedaList = {"RON", "EUR", "CHF", "USD", "JPY"};

    private final String[] temperaturaList = {"°C", "°F", "°K"};

    private final String[] timpList = {"sec", "min", "h", "day", "month"};

    private final String[] vitezaList = {"km/h", "km/s", "m/s", "m/h", "mph"};

    private final String[] presiuneList = {"Pa", "kPa", "bar", "psi"};

    private final String[] fortaList = {"N", "kN", "gf", "kgf"};

    private final String[] energieList = {"J", "kJ", "kWh", "Wh"};

    private final String[] putereList = {"W", "EW", "PW", "TW"};

    private final String[] unghiList = {"degree°", "rad", "grad[^]", "minute[']"};

    private final String[] dateList = {"b", "B", "kB", "MB", "GB", "TB"};

    private final String[] combustibilList = {"m/l", "m/gal", "km/gal", "mile/gal"};

    private final String[] gatitList = {"cup", "tablespoon", "g", "kg"};

    private final Preferences preferences;
    private final Boolean update;
    public WorkerCancel workerCancel;
    List<Double> sirToBigMoney;
    List<Double> sirToSmallMoney;

    public Converser()
    {
        sirToBigMoney = new ArrayList<Double>();
        for (int i = 0; i < 6; i++)
        {
            sirToBigMoney.add(1.0);
        }
        sirToSmallMoney = new ArrayList<Double>();
        for (int i = 0; i < 6; i++)
        {
            sirToSmallMoney.add(1.0);
        }
        preferences = Preferences.userRoot().node("db");
        update = false;
    }

    public List<Tuple> conversie(String valoare, String unitate, String subclasa)
    {
        List<Tuple> valori = new ArrayList<Tuple>();
        Double[] sirToBig = new Double[6];
        Double[] sirToSmall = new Double[6];

        switch (subclasa)
        {
            case "Greutate":
                sirToBig = new Double[]{1.0, 0.001, 0.001, 0.001, 2000.0, 16.0, 437.5, 0.3239945};
                sirToSmall = new Double[]{1000.0, 1000.0, 1000.0, 1000.0, 0.0004535924, 0.0625,
                        0.002285714, 1.0};
                valori = conversieUnitate(valoare, unitate, greutateList, sirToSmall, sirToBig);
                break;
            case "Lungime":
                sirToBig = new Double[]{1.0, 0.1, 0.1, 0.1, 0.001, 39370.0787, 0.08333333,
                        0.3333333, 0.0005681818};
                sirToSmall = new Double[]{10.0, 10.0, 10.0, 1000.0, 0.0000254, 12.0, 3.0, 1760.0,
                        1.0};
                valori = conversieUnitate(valoare, unitate, lungimeList, sirToSmall, sirToBig);
                break;
            case "Suprafata":
                sirToBig = new Double[]{1.0, 0.0001, 0.000001, 1550003100.0, 0.00694444,
                        0.11111111, 0.00020661, 0.0015625};
                sirToSmall = new Double[]{10000.0, 1000000.0, 0.000000000064516, 144.0, 9.0,
                        4840.0, 640.0, 1.0};
                valori = conversieUnitate(valoare, unitate, suprafataList, sirToSmall, sirToBig);
                break;
            case "Volum":
                sirToBig = new Double[]{1.0, 0.001, 0.001, 61023.7441, 0.0005787, 0.03703704,
                        201.974026};
                sirToSmall = new Double[]{1000.0, 1000.0, 0.00001639, 0.0005787037, 27.0,
                        0.00495113, 1.0};
                valori = conversieUnitate(valoare, unitate, volumList, sirToSmall, sirToBig);
                break;
            case "Moneda":
                //System.out.println(sirToSmallMoney);
                //conversieValutara(unitate, valoare);
                int index = ArrayUtils.indexOf(monedaList, unitate);
                //System.out.println("DIMENSIUNE " + sirToBigMoney.size());
                //sirToBigMoney.set(index + 1, 1.0);
                //sirToSmallMoney.set(index + 1, 1.0);
                sirToBig = sirToBigMoney.toArray(new Double[0]);
                sirToSmall = sirToSmallMoney.toArray(new Double[0]);
                valori = conversieUnitate(valoare, unitate, monedaList, sirToSmall, sirToBig);
                break;
            case "Temperatura":
                sirToBig = new Double[]{1.0, 33.8, 255.9278};
                sirToSmall = new Double[]{-17.22222, -457.87, 1.0};
                valori = conversieUnitate(valoare, unitate, temperaturaList, sirToSmall, sirToBig);
                break;
            case "Timp":
                sirToBig = new Double[]{1.0, 0.01666667, 0.01666667, 0.0006944444, 0.03285421};
                sirToSmall = new Double[]{60.0, 60.0, 24.0, 30.4375, 1.0};
                valori = conversieUnitate(valoare, unitate, timpList, sirToSmall, sirToBig);
                break;
            case "Viteza":
                sirToBig = new Double[]{1.0, 0.0002777778, 1000.0, 3600.0, 0.00062137};
                sirToSmall = new Double[]{3600.0, 0.001, 0.0002777778, 1609.344, 1.0};
                valori = conversieUnitate(valoare, unitate, vitezaList, sirToSmall, sirToBig);
                break;
            case "Presiune":
                sirToBig = new Double[]{1.0, 0.001, 0.1, 14.503773773};
                sirToSmall = new Double[]{1000.0, 100.0, 0.0689475729, 1.0};
                valori = conversieUnitate(valoare, unitate, presiuneList, sirToSmall, sirToBig);
                break;
            case "Forta":
                sirToBig = new Double[]{1.0, 0.001, 101971.6213, 0.001};
                sirToSmall = new Double[]{1000.0, 0.0000098067, 1000.0, 1.0};
                valori = conversieUnitate(valoare, unitate, fortaList, sirToSmall, sirToBig);
                break;
            case "Energie":
                sirToBig = new Double[]{1.0, 0.001, 0.0002777778, 1000.0};
                sirToSmall = new Double[]{1000.0, 3600.0, 0.001, 1.0};
                valori = conversieUnitate(valoare, unitate, fortaList, sirToSmall, sirToBig);
                break;
            case "Putere":
                sirToBig = new Double[]{1.0, 0.000001, 1000.0, 10.0};
                sirToSmall = new Double[]{1000000.0, 0.001, 0.1, 1.0};
                valori = conversieUnitate(valoare, unitate, putereList, sirToSmall, sirToBig);
                break;
            case "Unghi":
                sirToBig = new Double[]{1.0, 0.0174532925, 63.661977237, 54.0};
                sirToSmall = new Double[]{57.295779513, 0.0157079633, 0.0185185185, 1.0};
                valori = conversieUnitate(valoare, unitate, unghiList, sirToSmall, sirToBig);
                break;
            case "Date":
                sirToBig = new Double[]{1.0, 0.125, 0.0009765625, 0.0009765625, 0.0009765625,
                        0.0009765625};
                sirToSmall = new Double[]{8.0, 1024.0, 1024.0, 1024.0, 1024.0, 1.0};
                valori = conversieUnitate(valoare, unitate, dateList, sirToSmall, sirToBig);
                break;
            case "Combustibil":
                sirToBig = new Double[]{1.0, 3.7854117834, 0.0037854118, 0.0023521458};
                sirToSmall = new Double[]{ 0.2641720524,1000.0,1.609344,1.0};
                valori = conversieUnitate(valoare, unitate, combustibilList, sirToSmall, sirToBig);
                break;
            case "Gatit":
                sirToBig = new Double[]{1.0, 14.078032, 17.758164, 0.001};
                sirToSmall = new Double[]{ 0.071033, 0.056312, 1000.0,1.0};
                valori = conversieUnitate(valoare, unitate, gatitList, sirToSmall, sirToBig);
                break;
        }
        return valori;
    }

    public void conversieValutara()
    {
        String[] urls = {"https://wise.com/us/currency-converter/ron-to-eur-rate?amount=1",
                "https://wise.com/us/currency-converter/eur-to-chf-rate?amount=1",
                "https://wise" + ".com/us/currency-converter/chf-to-usd-rate?amount=1", "https" +
                "://wise" + ".com/us/currency-converter/usd-to-jpy-rate?amount=1"};

        String[] urls2 = {"https://wise.com/us/currency-converter/eur-to-ron-rate?amount=1",
                "https://wise.com/us/currency-converter/chf-to-eur-rate?amount=1",
                "https://wise" + ".com/us/currency-converter/usd-to-chf-rate?amount=1", "https" +
                "://wise" + ".com/us/currency-converter/jpy-to-usd-rate?amount=1"};

        sirToBigMoney = scrapeAndProcessData(urls, true);
         sirToSmallMoney = scrapeAndProcessData(urls2, false);
    }

    private List<Double> scrapeAndProcessData(String[] urls, boolean indexNeutur)
    {
        Double[] results = new Double[6];
        if (indexNeutur)
        {
            results[0] = 1.0;
        }
        int inceput = indexNeutur ? 1 : 0;

        // Create an array to hold the threads
        Thread[] threads = new Thread[urls.length];

        // Start the threads
        for (int i = 0; i < urls.length; i++)
        {
            final int index = i;
            threads[i] = new Thread(() -> {
                try
                {
                    Document doc = Jsoup.connect(urls[index]).get();
                    Elements divElements = doc.select("div.form-group");
                    String value = null;
                    if (!divElements.isEmpty())
                    {
                        Element secondDiv = divElements.get(1);
                        value = secondDiv.child(1).text();
                        for (int j = 0; j < value.length(); j++)
                        {
                            if ((value.charAt(j) < '0' || value.charAt(j) > '9') && value.charAt(j) != '.')
                            {
                                value = value.substring(0, j);
                                break;
                            }
                        }
                        synchronized (results)
                        {
                            results[inceput + index] = Double.valueOf(value);
                        }
                    }
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            });
            threads[i].start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads)
        {
            try
            {
                thread.join();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        // Set the default value if indexNeutur is false
        if (!indexNeutur)
        {
            results[5] = 1.0;
        }

        List<Double> list = Arrays.asList(results);
        return list;
    }

    public List<Tuple> conversieUnitate(String valoare, String unitate, String[] sirUnitate,
                                        Double[] sirToSmall, Double[] sirToBig)
    {

        List<Tuple> lista = new ArrayList<Tuple>();

        for (int i = 0; i < sirUnitate.length; i++)
        {
            lista.add(new Tuple("", ""));
        }

        int indice = 0;
        for (int i = 0; i < sirUnitate.length; i++)
        {
            if (sirUnitate[i] == unitate)
            {
                indice = i;
                break;
            }
        }
        lista.set(indice, new Tuple(valoare, unitate));

        int indiceSecundar = indice + 1;
        indice--;
        Double valoareCopieMica = Double.valueOf(valoare);
        Double valoareCopieMare = Double.valueOf(valoare);
        String valoareFormatata;


        while (indice >= 0 || indiceSecundar <= sirUnitate.length - 1)
        {
            if (indice >= 0)
            {
                valoareCopieMica *= sirToSmall[indice];
                valoareFormatata = String.format("%.10f", valoareCopieMica);
                lista.set(indice, new Tuple(valoareFormatata, sirUnitate[indice]));

            }
            if (indiceSecundar < sirUnitate.length)
            {
                valoareCopieMare *= sirToBig[indiceSecundar];
                valoareFormatata = String.format("%.10f", valoareCopieMare);
                lista.set(indiceSecundar, new Tuple(valoareFormatata, sirUnitate[indiceSecundar]));
            }
            indice--;
            indiceSecundar++;
        }
        return lista;
    }

    public void updatePreferences()
    {
        workerCancel.cancelWorker();
    }

    public void setWorkerCancel(WorkerCancel workerCancel)
    {
        this.workerCancel = workerCancel;
    }
}
