package tree.models.extend;

import tree.models.abstracts.Tree;
import java.util.Optional;
import java.util.Random;

public class LeafyTree extends Tree
{
    private final int juiceClass;
    private final int juiceAmount;

    public LeafyTree()
    {
        this.leafType= LeafType.LEAF;
        this.juiceClass=4;
        this.juiceAmount=1000;
        this.brokeLimit=14;
        this.className="LeafyTree";
    }
    public void breakTree()
    {
        if(broken)
        {
            System.out.println(className + " Drzewo juz jest zlamane");
        }
        else if(rootThickness<brokeLimit)
        {
            broken = true;
            System.out.println(className + " Drzewo zostalo zlamane");
        }
        else
        {
            System.out.println(className + " Drzewo zbyt grube zeby zlamac");
        }
    }
    @Override
    protected Integer goTreesJuice(Object additionalPotential) throws Exception
    {
        int additionalPotentialInteger;
        if(additionalPotential instanceof Integer)
        {
            additionalPotentialInteger= (int) additionalPotential;
        }
        else if(additionalPotential instanceof Double)
        {
            additionalPotentialInteger=((Double)additionalPotential).intValue();
        }
        else if(additionalPotential instanceof Float)
        {
            additionalPotentialInteger=((Float)additionalPotential).intValue();
        }
        else
        {
            throw new Exception(className+" additionalPotential is not Double or Float or Integer!");
        }
        int growthPotential=(juiceAmount*juiceClass)+additionalPotentialInteger;
        System.out.println(className+" Puszczam soki z korzeni z potencjalem do rozrostu : "+growthPotential);
        return growthPotential;
    }

    @Override
    protected Integer leafGrowth(Object growthPotential)
    {
        int random=(new Random().nextInt(100)%50)+50;
        int leafAmount= (Integer)growthPotential*random;
        System.out.println(className+" Ilosc lisci na drzewie : "+leafAmount);
        return leafAmount;
    }


    @Override
    protected Optional<Apples> toBloom(Object leafAmount, Object temperature) throws Exception // coldLevel(0-1)
    {
        double temperatureDouble;
        if(temperature instanceof Double)
        {
            temperatureDouble=(Double)temperature;
        }
        else if(temperature instanceof Float)
        {
            temperatureDouble=((Float)temperature).doubleValue();
        }
        else if(temperature instanceof Integer)
        {
            temperatureDouble=((Integer)temperature).doubleValue();
        }
        else
        {
            throw new Exception("coldLevel is not Double or Float or Integer !");
        }

        if(temperatureDouble<=0)
        {
            System.out.println(className + " Wszystko wymarzlo");
            return Optional.empty();
        }
        else if(temperatureDouble>=70)
        {
            System.out.println(className + " Wszystko sie wypalilo");
            return Optional.empty();
        }
        else
        {
            int applesAmount = (int) temperatureDouble * ((Integer) leafAmount);

            Apples apples = new Apples(applesAmount);
            System.out.println(className + " Zakwitło : " + applesAmount + " owocow typu : " + apples);
            return Optional.of(apples);
        }
    }

    @Override
    protected void rootIncrease(Object apples)
    {
        rootThickness++;
        System.out.println(className+" Zwiekszenie rozmiaru pnia po wszystkich etapach. Aktualny rozmiar pnia : "+rootThickness);
    }

    public int getJuiceClass() {
        return juiceClass;
    }

    public int getJuiceAmount() {
        return juiceAmount;
    }

    public static class Apples
    {
        private int amount;
        public Apples(int amount)
        {
            this.amount=amount;
        }
        public int getAmount()
        {
            return amount;
        }
        @Override
        public String toString()
        {
            return "JABŁOŃ sztuk : "+amount;
        }
    }
}