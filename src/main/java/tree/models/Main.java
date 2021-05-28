package tree.models;

import tree.models.abstracts.Tree;
import tree.models.extend.ConiferTree;
import tree.models.extend.LeafyTree;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("\n/// START\n");

        Tree leafyTree=new LeafyTree();
        double additionalPotential1=42.5;
        int temperature1=30;
        leafyTree.growUp(additionalPotential1,temperature1);

        System.out.println("\n/// BREAK\n");

        Tree coniferTree=new ConiferTree();
        int additionalPotential2=999;
        double temperature2=-39.9;
        coniferTree.growUp(additionalPotential2,temperature2);


        System.out.println("\n/// STOP\n");

    }
}
