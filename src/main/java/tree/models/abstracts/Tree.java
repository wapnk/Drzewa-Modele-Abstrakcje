package tree.models.abstracts;

public abstract class Tree
{
    // attributes
    protected int rootThickness;
    protected int brokeLimit;
    protected Branch branch;
    protected LeafType leafType;
    protected boolean broken;
    protected String className;

    // default basic constructor
    public Tree()
    {
        rootThickness=50;
        brokeLimit=20;
        branch=new Branch();
        broken=false;
        leafType=LeafType.UNKNOWN;
        className="{Abstract} Tree";
    }

    // protected methods
    protected abstract Object goTreesJuice(Object arg) throws Exception;
    protected abstract Object leafGrowth(Object arg);
    protected abstract Object toBloom(Object arg1, Object arg2) throws Exception;
    protected abstract void rootIncrease(Object arg);

    // single method to use
    public final void growUp(Object additionalPotential,Object temperature) throws Exception
    {
        if(broken==false)
        {
            Object var1 = goTreesJuice(additionalPotential);
            Object var2 = leafGrowth(var1);
            Object var3 = toBloom(var2, temperature);
            rootIncrease(var3);
        }
        else
        {
            System.out.println(className+ " Drzewo zlamane lub sciete ! Nic nie mozna juz zrobic");
        }
    }
    // getters
    public int getRootThickness()
    {
        return rootThickness;
    }

    public int getBrokeLimit()
    {
        return brokeLimit;
    }

    public Branch getBranch()
    {
        return branch;
    }

    public LeafType getLeafType()
    {
        return leafType;
    }

    public boolean isBroken()
    {
        return broken;
    }

    public String getClassName()
    {
        return className;
    }

    // helping application classes
    public class Branch{}
    public enum LeafType{
        LEAF,NEEDLES,UNKNOWN
    }
}