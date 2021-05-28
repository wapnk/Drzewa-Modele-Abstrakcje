package tree.models.extend;

import tree.models.abstracts.Tree;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;


public class ConiferTree extends Tree
{
    private List<Cone> coneList;
    private double treeHeight;

    public ConiferTree()
    {
        this.leafType= LeafType.NEEDLES;
        this.brokeLimit=31;
        this.className="ConiferTree";
        this.coneList=new ArrayList<>();
        this.treeHeight=50;
    }
    protected void treeHeightIncrease()
    {
        treeHeight+=10;
        System.out.println(className+" Drzewo uroslo w gore. Aktualna wysokosc : "+treeHeight);
    }
    protected void writeAllConeList(List<Cone> cones)
    {
        System.out.println(cones);
    }
    public Optional<Cone> getCone(String id_name)
    {
        Optional<Cone> cone;
        int id=0;
        for (Cone tmp:coneList)
        {
            if(tmp.getIdName()==id_name)
            {
                cone=Optional.of(tmp);
                coneList.remove(id);

                System.out.println("Piekna pachnaca szyszka rodzaju "+cone.get().getIdName());
                return cone;
            }
            id++;
        }
        System.out.println("Niestety nie ma takiej szyszki :(");
        return Optional.empty();
    }
    @Override
    protected Double goTreesJuice(Object additionalPotential) throws Exception
    {
        double additionalPotentialDouble;

        if(additionalPotential instanceof Double)
        {
            additionalPotentialDouble=((double)additionalPotential);
        }
        else if(additionalPotential instanceof Float)
        {
            additionalPotentialDouble=((Float)additionalPotential).doubleValue();
        }
        else if(additionalPotential instanceof Integer)
        {
            additionalPotentialDouble=((Integer)additionalPotential).doubleValue();
        }
        else
        {
            throw new Exception(className+" additionalPotential is not Double or Float or Integer !");
        }

        double random=(new Random().nextDouble())*1000;
        double growthPotential=random+additionalPotentialDouble;

        System.out.println(className+" Puszczam soki z korzeni z potencjalem do rozrostu : "+growthPotential);
        return growthPotential;
    }

    @Override
    protected Integer leafGrowth(Object growthPotential)
    {
        double growthPotentialDouble=(Double)growthPotential;
        int needlesAmount = 2500 * (int) growthPotentialDouble;
        System.out.println(className+" Ilosc igiel na drzewie : "+needlesAmount);
        return needlesAmount;
    }

    @Override
    protected List<Cone> toBloom(Object needlesAmount, Object temperature) throws Exception
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
        if(temperatureDouble<-50)
        {
            for(int i=0;i<5;i++)
            {
                coneList.add(new Cone("BadCone"));
            }
            System.out.println(className + " Bardzo zimno dlatego malo szyszek slabej jakosci");
        }
        else
        {
            int iters=((Integer) needlesAmount/1000);
            for(int i=0;i<iters;i++)
            {
                coneList.add(new Cone("DefaultCone"));
            }
            System.out.println(className + " Szyszki przecietnej jakosci");
        }
        System.out.println(className + " Wyrosło : " + coneList.size() + " szyszek");
        return coneList;
    }

    @Override
    protected void rootIncrease(Object resultConeList)
    {
        if(resultConeList instanceof ArrayList)
        {
            List<Cone> cones=(ArrayList<Cone>)resultConeList;
            writeAllConeList(cones);
        }
        rootThickness++;
        System.out.println(className+" Zwiekszenie rozmiaru pnia po wszystkich etapach. Aktualny rozmiar pnia : "+rootThickness);
        treeHeightIncrease();
    }
    public List<Cone> getConeList() {
        return coneList;
    }

    public void setConeList(List<Cone> coneList) {
        this.coneList = coneList;
    }

    public double getTreeHeight() {
        return treeHeight;
    }

    public void setTreeHeight(double treeHeight) {
        this.treeHeight = treeHeight;
    }

    public static class Cone
    {
        private String idName;
        private int id;
        public static int ID=1;
        public Cone(String idName){this.idName=idName;this.id=ID;ID++;}
        public String getIdName() {return idName;}
        public void setIdName(String idName) {this.idName = idName;}
        @Override public String toString() {return "id : "+id+" nazwa "+idName;}
    }
}
