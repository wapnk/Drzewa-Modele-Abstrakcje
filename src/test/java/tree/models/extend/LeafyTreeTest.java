package tree.models.extend;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import tree.models.abstracts.Tree;
import java.util.Optional;
import java.util.Random;

class LeafyTreeTest
{

    @Test
    void breakTreeExceptionTest()
    {
        Tree leafyTree=new LeafyTree();
        try
        {
            ((LeafyTree) leafyTree).breakTree();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }
    @Test
    void goTreesJuiceInteger() throws Exception
    {
        Tree leafyTree=new LeafyTree();
        int additionalPotential=154;
        int result = ((LeafyTree) leafyTree).goTreesJuice(additionalPotential);
        int expected= ((LeafyTree) leafyTree).getJuiceAmount() * ((LeafyTree) leafyTree).getJuiceClass() + additionalPotential;
        Assert.assertEquals(expected,result);
    }
    @Test
    void goTreesJuiceDouble() throws Exception
    {
        Tree leafyTree=new LeafyTree();
        double additionalPotential=57.5;
        int result = ((LeafyTree) leafyTree).goTreesJuice(additionalPotential);
        int expected= ((LeafyTree) leafyTree).getJuiceAmount() * ((LeafyTree) leafyTree).getJuiceClass() + (int)additionalPotential;
        Assert.assertEquals(expected,result);
    }
    @Test
    void goTreesJuiceFloat() throws Exception
    {
        Tree leafyTree=new LeafyTree();
        float additionalPotential=98.3f;
        int result = ((LeafyTree) leafyTree).goTreesJuice(additionalPotential);
        int expected= ((LeafyTree) leafyTree).getJuiceAmount() * ((LeafyTree) leafyTree).getJuiceClass() + (int)additionalPotential;
        Assert.assertEquals(expected,result);
    }

    @Test
    void leafGrowth()
    {
        int random=(new Random().nextInt(100)%50)+50;
        Tree leafyTree=new LeafyTree()
        {
            @Override
            protected Integer leafGrowth(Object growthPotential)
            {
                // int random=(new Random().nextInt(100)%50)+50; // metoda identyczna jak w domysle bez tej linijki
                int leafAmount= (Integer)growthPotential*random;
                System.out.println(className+" Ilosc lisci na drzewie : "+leafAmount);
                return leafAmount;
            }
        };
        int growthPotential=1500;
        int expected=growthPotential*random;
        int result = ((LeafyTree)leafyTree).leafGrowth(growthPotential);
        Assert.assertEquals(expected,result);
    }

    @Test
    void toBloomIntegerLess0Temperature() throws Exception
    {
        Tree leafyTree=new LeafyTree();
        int leafAmount=4723;
        int temperature=-20;
        Optional<LeafyTree.Apples> expected=Optional.empty();
        Optional<LeafyTree.Apples> result= ((LeafyTree) leafyTree).toBloom(leafAmount,temperature);
        Assert.assertEquals(expected,result);
    }
    @Test
    void toBloomIntegerOptimalTemperature() throws Exception
    {
        Tree leafyTree=new LeafyTree();
        int leafAmount=4723;
        int temperature=20;

        int applesAmount = temperature*leafAmount;
        LeafyTree.Apples apples = new LeafyTree.Apples(applesAmount);

        Optional<LeafyTree.Apples> expected=Optional.of(apples);
        Optional<LeafyTree.Apples> result= ((LeafyTree) leafyTree).toBloom(leafAmount,temperature);

        Assert.assertTrue(result.isPresent() &&
                expected.get().toString().matches
                        (result.get().toString()));
    }
    @Test
    void toBloomIntegerOver70Temperature() throws Exception
    {
        Tree leafyTree=new LeafyTree();
        int leafAmount=4723;
        int temperature=100;
        Optional<LeafyTree.Apples> expected=Optional.empty();
        Optional<LeafyTree.Apples> result= ((LeafyTree) leafyTree).toBloom(leafAmount,temperature);
        Assert.assertEquals(expected,result);
    }
    @Test
    void toBloomDoubleLess0Temperature() throws Exception
    {
        Tree leafyTree=new LeafyTree();
        int leafAmount=10;
        double temperature=-22.432;
        Optional<LeafyTree.Apples> expected=Optional.empty();
        Optional<LeafyTree.Apples> result= ((LeafyTree) leafyTree).toBloom(leafAmount,temperature);
        Assert.assertEquals(expected,result);
    }
    @Test
    void toBloomDoubleOptimalTemperature() throws Exception
    {
        Tree leafyTree=new LeafyTree();
        int leafAmount=9451;
        double temperature=31.9;

        int applesAmount = (int)temperature*leafAmount;
        LeafyTree.Apples apples = new LeafyTree.Apples(applesAmount);

        Optional<LeafyTree.Apples> expected=Optional.of(apples);
        Optional<LeafyTree.Apples> result= ((LeafyTree) leafyTree).toBloom(leafAmount,temperature);

        Assert.assertTrue(result.isPresent() &&
                expected.get().toString().matches
                        (result.get().toString()));
    }
    @Test
    void toBloomDoublerOver70Temperature() throws Exception
    {
        Tree leafyTree=new LeafyTree();
        int leafAmount=123;
        double temperature=190.75;
        Optional<LeafyTree.Apples> expected=Optional.empty();
        Optional<LeafyTree.Apples> result= ((LeafyTree) leafyTree).toBloom(leafAmount,temperature);
        Assert.assertEquals(expected,result);
    }
    @Test
    void toBloomFloatLess0Temperature() throws Exception
    {
        Tree leafyTree=new LeafyTree();
        int leafAmount=9999;
        float temperature=-90.7895f;
        Optional<LeafyTree.Apples> expected=Optional.empty();
        Optional<LeafyTree.Apples> result= ((LeafyTree) leafyTree).toBloom(leafAmount,temperature);
        Assert.assertEquals(expected,result);
    }
    @Test
    void toBloomFloatOptimalTemperature() throws Exception
    {
        Tree leafyTree=new LeafyTree();
        int leafAmount=500;
        float temperature=22.22f;

        int applesAmount = (int)temperature*leafAmount;
        LeafyTree.Apples apples = new LeafyTree.Apples(applesAmount);

        Optional<LeafyTree.Apples> expected=Optional.of(apples);
        Optional<LeafyTree.Apples> result= ((LeafyTree) leafyTree).toBloom(leafAmount,temperature);

        Assert.assertTrue(result.isPresent() &&
                expected.get().toString().matches
                        (result.get().toString()));
    }
    @Test
    void toBloomFloatOver70Temperature() throws Exception
    {
        Tree leafyTree=new LeafyTree();
        int leafAmount=1;
        float temperature=100.1f;
        Optional<LeafyTree.Apples> expected=Optional.empty();
        Optional<LeafyTree.Apples> result= ((LeafyTree) leafyTree).toBloom(leafAmount,temperature);
        Assert.assertEquals(expected,result);
    }

    @Test
    void rootIncrease()
    {
        Tree leafyTree=new LeafyTree();
        ((LeafyTree) leafyTree).rootIncrease(null);
    }
}