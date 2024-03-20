package Model;

public class DeBaza
{
    public enum Greutate
    {
        micrograme("mig"),
        miligrame("mg"),
        grame("g"),
        kilograme("kg"),
        pound("lb"),
        ounce("oz"),
        grain("grain"),
        tona("ton"),
        hundredweight("cwt"),
        carat("carat");

        private String text;

        Greutate(String text)
        {
            this.text = text;
        }

        @Override
        public String toString()
        {
            return text;
        }
    }

    public enum Lungime
    {

        micrometri("mim"),
        milimetri("mm"),
        centrimetri("cm"),
        decimetri("dm"),
        metri("m"),
        inches("inch"),
        feet("ft"),
        yard("yd"),
        mile("mile"),
        kilometri("km"),
        milanautica("NM");

        private String text;

        private Lungime(String denumire)
        {
            this.text = denumire;
        }

        @Override
        public String toString()
        {
            return text;
        }
    }

    public enum Suprafata
    {
        milimetrupatrat("mm2"),
        centrimetrupatrat("cm2"),
        decimetrupatrat("dm2"),
        metrupatrat("m2"),
        incipatrat("in2"),
        feetpatrat("ft2"),
        yardpatrat("yd"),
        hectar("ha"),
        kilometrupatrat("km2"),
        acru("acre"),
        milapatrata("mile2");

        private String text;

        Suprafata(String text)
        {
            this.text = text;
        }

        @Override
        public String toString()
        {
            return "";
        }
    }

    public enum Volum
    {
        mililitri("ml"),
        decilitri("dl"),
        litri("L"),
        milimetricubi("mm3"),
        centrimetricubi("cm3"),
        decimetricubi("dm3"),
        metricubi("m3"),
        inchicubi("in3"),
        feetcubi("ft3"),
        yardcub("yd3"),
        galon("gal");

        private String text;

        Volum(String text)
        {
            this.text = text;
        }

        @Override
        public String toString()
        {
            return text;
        }
    }

}
