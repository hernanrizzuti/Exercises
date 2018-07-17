package rizzutih;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import rizzutih.Exercises.BinaryTree;
import rizzutih.Exercises.Node;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BinaryTreeTest {

    private BinaryTree tree;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        tree = new BinaryTree();
    }

    @Test
    public void testAddAddsTheRootElementToTheTreeWhenThereIsNotElement() {
        assertEquals(50, tree.add(50).data);
    }

    @Test
    public void testAddAddsAChildNodeToTheLeftWhenThereRootIsGreaterThanChildNode() {
        tree.add(50);
        assertEquals(25, tree.add(25).leftChild.data);
    }

    @Test
    public void testAddAddsAChildNodeToTheRightWhenThereRootIsSmallerThanChildNode() {
        tree.add(50);
        tree.add(25);
        assertEquals(75, tree.add(75).rightChild.data);
    }

    @Test
    public void testAddAddsAChildNodeToTheLeftWhenTheSubTreeIsGreaterThanChildNode() {
        tree.add(50);
        tree.add(25);
        tree.add(75);
        assertEquals(15, tree.add(15).leftChild.leftChild.data);
    }

    @Test
    public void testAddAddsAChildNodeToTheRightWhenTheSubTreeIsSmallerThanChildNode() {
        tree.add(50);
        tree.add(25);
        tree.add(75);
        tree.add(15);
        tree.add(30);
        assertEquals(30, tree.add(30).leftChild.rightChild.data);
    }

    @Test
    public void testAddAddsAChildNodeToTheRightWhenTheSubTreeOfTheRootIsSmallerThanChildNode() {
        tree.add(50);
        tree.add(25);
        tree.add(75);
        tree.add(15);
        tree.add(30);
        assertEquals(100, tree.add(100).rightChild.rightChild.data);
    }

    @Test
    public void testTraverseReturnsOneNumberOnlyWhenRootIsTheOnlyNumberInTree(){
        tree.add(50);
        assertEquals(50, tree.traverse().get(0).data);

    }

    @Test
    public void testTraverseReturnsTwoNumbersWhenRootContainsASubTree(){
        tree.add(50);
        tree.add(25);
        List<Node> nodes = tree.traverse();
        System.out.println(nodes);
        assertEquals(25, nodes.get(0).data);
        assertEquals(50, nodes.get(1).data);
    }
    @Test
    public void testTraverseReturnsTreeNumbersWhenRootContainsSubTrees(){
        tree.add(50);
        tree.add(25);
        tree.add(75);
        List<Node> nodes = tree.traverse();
        System.out.println(nodes);
        assertEquals(25, nodes.get(0).data);
        assertEquals(50, nodes.get(1).data);
        assertEquals(75, nodes.get(2).data);
    }

    @Test
    public void testTraverseReturns4NumbersWhenRootContains3SubTreesOnTheLeftAnd1SubtreeOnTheRight(){
        tree.add(50);
        tree.add(25);
        tree.add(75);
        tree.add(10);
        List<Node> nodes = tree.traverse();
        System.out.println(nodes);
        assertEquals(10, nodes.get(0).data);
        assertEquals(25, nodes.get(1).data);
        assertEquals(50, nodes.get(2).data);
        assertEquals(75, nodes.get(3).data);
    }

    @Test
    public void testTraverseReturns0NumbersWhenTreeContainsZero(){
        List<Node> nodes = tree.traverse();
        System.out.println(nodes);
        assertEquals(0, nodes.size());
    }

    @Test
    public void testTraverseReturns1NumbersWhenTreeContinsRootOnly(){
        tree.add(50);
        List<Node> nodes = tree.traverse();
        System.out.println(nodes);
        assertEquals(50, nodes.get(0).data);
    }

    @Test
    public void testTraverseReturns5NumbersWhenRootContains3SubTreesOnTheLeftAnd2SubtreeOnTheRight(){
        tree.add(200);
        tree.add(20);
        tree.add(10);
        tree.add(40);
        System.out.println(tree.add(35).data);
        List<Node> nodes = tree.traverse();
        System.out.println(nodes);
        assertEquals(10, nodes.get(0).data);
        assertEquals(20, nodes.get(1).data);
        assertEquals(35, nodes.get(2).data);
        assertEquals(40, nodes.get(3).data);
        assertEquals(200, nodes.get(4).data);
    }
}
