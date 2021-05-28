package tree.models.extend;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import tree.models.abstracts.Tree;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

class ConiferTreeTest {

    @Test
    void treeHeightIncrease()
    {
        Tree coniferTree=new ConiferTree();
        ((ConiferTree) coniferTree).treeHeightIncrease();
    }

    @Test
    void writeAllConeList()
    {
        Tree coniferTree=new ConiferTree();
        List<ConiferTree.Cone> cones = new ArrayList<>();
        cones.add(new ConiferTree.Cone("DefaultCone"));
        cones.add(new ConiferTree.Cone("DefaultCone"));
        cones.add(new ConiferTree.Cone("BadCone"));
        cones.add(new ConiferTree.Cone("GreatCone"));
        ((ConiferTree) coniferTree).writeAllConeList(cones);
    }

    @Test
    void getConeExist()
    {
        Tree coniferTree=new ConiferTree();
        List<ConiferTree.Cone> cones = new ArrayList<>();

        ConiferTree.Cone cone1=new ConiferTree.Cone("DefaultCone");
        ConiferTree.Cone cone2=new ConiferTree.Cone("DefaultCone");
        ConiferTree.Cone cone3=new ConiferTree.Cone("BadCone");
        ConiferTree.Cone cone4=new ConiferTree.Cone("GreatCone");

        cones.add(cone1);
        cones.add(cone2);
        cones.add(cone3);
        cones.add(cone4);

        ((ConiferTree) coniferTree).setConeList(cones);

        Optional<ConiferTree.Cone> expected=Optional.of(cone1);
        Optional<ConiferTree.Cone> result=((ConiferTree) coniferTree).getCone("DefaultCone");

        Assert.assertEquals(expected,result);
    }
    @Test
    void getConeNull()
    {
        Tree coniferTree=new ConiferTree();
        List<ConiferTree.Cone> cones = new ArrayList<>();

        ((ConiferTree) coniferTree).setConeList(cones);

        Optional<ConiferTree.Cone> expected=Optional.empty();
        Optional<ConiferTree.Cone> result=((ConiferTree) coniferTree).getCone("DefaultCone");

        Assert.assertEquals(expected,result);
    }

    @Test
    void goTreesJuiceInteger() throws Exception
    {
        double random=(new Random().nextDouble())*1000;

        int additionalPotential=3234;
        Tree coniferTree=new ConiferTree()
        {
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

                //double random=(new Random().nextDouble())*1000;
                double growthPotential=random+additionalPotentialDouble;

                System.out.println(className+" Puszczam soki z korzeni z potencjalem do rozrostu : "+growthPotential);
                return growthPotential;
            }
        };

        double expected=random+additionalPotential;
        double result= ((ConiferTree)coniferTree).goTreesJuice(additionalPotential);//(double) coniferTree.goTreesJuice(additionalPotential);
        Assert.assertTrue(expected==result);
    }
    @Test
    void goTreesJuiceDouble() throws Exception
    {
        double random=(new Random().nextDouble())*1000;

        double additionalPotential=51.999;
        Tree coniferTree=new ConiferTree()
        {
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

                //double random=(new Random().nextDouble())*1000;
                double growthPotential=random+additionalPotentialDouble;

                System.out.println(className+" Puszczam soki z korzeni z potencjalem do rozrostu : "+growthPotential);
                return growthPotential;
            }
        };

        double expected=random+additionalPotential;
        double result= ((ConiferTree)coniferTree).goTreesJuice(additionalPotential);
        Assert.assertTrue(expected==result);
    }
    @Test
    void goTreesJuiceFloat() throws Exception
    {
        double random=(new Random().nextDouble())*1000;

        float additionalPotential=575.37f;
        Tree coniferTree=new ConiferTree()
        {
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

                //double random=(new Random().nextDouble())*1000;
                double growthPotential=random+additionalPotentialDouble;

                System.out.println(className+" Puszczam soki z korzeni z potencjalem do rozrostu : "+growthPotential);
                return growthPotential;
            }
        };

        double expected=random+additionalPotential;
        double result= ((ConiferTree)coniferTree).goTreesJuice(additionalPotential);
        Assert.assertTrue(expected==result);
    }

    @Test
    void leafGrowth()
    {
        Tree coniferTree=new ConiferTree();
        double growthPotential=123.456;
        int expected = 2500 * (int) growthPotential;
        int result = ((ConiferTree) coniferTree).leafGrowth(growthPotential);
        Assert.assertEquals(result,expected);
    }

    @Test
    void toBloomIntegerMinus50Less() throws Exception
    {
        Tree coniferTree=new ConiferTree();
        int needlesAmount=3400;
        int temperature=-55;

        List <ConiferTree.Cone> expected=new ArrayList<>();

        for(int i=0;i<5;i++)
        {
            expected.add(new ConiferTree.Cone("BadCone"));
        }
        ConiferTree.Cone.ID=1;
        List<ConiferTree.Cone> result = ((ConiferTree) coniferTree).toBloom(needlesAmount,temperature);
        Assert.assertEquals(expected.toString(),result.toString());
    }
    @Test
    void toBloomIntegerMinus50Over() throws Exception
    {
        Tree coniferTree=new ConiferTree();
        int needlesAmount=3400;
        int temperature=25;

        List <ConiferTree.Cone> expected=new ArrayList<>();
        ConiferTree.Cone.ID=1;

        for(int i=0;i<((Integer) needlesAmount/1000);i++)
        {
            expected.add(new ConiferTree.Cone("DefaultCone"));
        }
        ConiferTree.Cone.ID=1;
        List<ConiferTree.Cone> result = ((ConiferTree) coniferTree).toBloom(needlesAmount,temperature);// (List<ConiferTree>) coniferTree.toBloom(needlesAmount,temperature);
        Assert.assertEquals(expected.toString(),result.toString());
    }
    @Test
    void toBloomDoubleMinus50Less() throws Exception
    {
        Tree coniferTree=new ConiferTree();
        int needlesAmount=3000;
        double temperature=-55.5;

        List <ConiferTree.Cone> expected=new ArrayList<>();
        ConiferTree.Cone.ID=1;

        for(int i=0;i<5;i++)
        {
            expected.add(new ConiferTree.Cone("BadCone"));
        }
        ConiferTree.Cone.ID=1;
        List<ConiferTree.Cone> result = ((ConiferTree) coniferTree).toBloom(needlesAmount,temperature);
        Assert.assertEquals(expected.toString(),result.toString());
    }
    @Test
    void toBloomDoubleMinus50Over() throws Exception
    {
        Tree coniferTree=new ConiferTree();
        int needlesAmount=17000;
        double temperature=80.98;

        List <ConiferTree.Cone> expected=new ArrayList<>();
        ConiferTree.Cone.ID=1;
        for(int i=0;i<((Integer) needlesAmount/1000);i++)
        {
            expected.add(new ConiferTree.Cone("DefaultCone"));
        }
        ConiferTree.Cone.ID=1;
        List<ConiferTree.Cone> result= ((ConiferTree)coniferTree).toBloom(needlesAmount,temperature);
        Assert.assertEquals(expected.toString(),result.toString());
    }
    @Test
    void toBloomFloatMinus50Less() throws Exception
    {
        Tree coniferTree=new ConiferTree();
        int needlesAmount=50;
        float temperature=-51.4f;

        List <ConiferTree.Cone> expected=new ArrayList<>();
        ConiferTree.Cone.ID=1;
        for(int i=0;i<5;i++)
        {
            expected.add(new ConiferTree.Cone("BadCone"));
        }
        ConiferTree.Cone.ID=1;
        List<ConiferTree.Cone> result= ((ConiferTree)coniferTree).toBloom(needlesAmount,temperature);
        Assert.assertEquals(expected.toString(),result.toString());
    }
    @Test
    void toBloomFloatMinus50Over() throws Exception
    {
        Tree coniferTree=new ConiferTree();
        int needlesAmount=99;
        float temperature=14.575f;

        List <ConiferTree.Cone> expected=new ArrayList<>();

        for(int i=0;i<((Integer) needlesAmount/1000);i++)
        {
            expected.add(new ConiferTree.Cone("DefaultCone"));
        }
        // ConiferTree.Cone.ID=1;
        List<ConiferTree.Cone> result= ((ConiferTree) coniferTree).toBloom(needlesAmount,temperature);
        Assert.assertEquals(expected.toString(),result.toString());
    }

    @Test
    void rootIncrease()
    {
        Tree coniferTree=new ConiferTree();
        ((ConiferTree)coniferTree).rootIncrease(null);
    }
}