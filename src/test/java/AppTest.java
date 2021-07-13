import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class AppTest {

    public void testExchangeValues() {
        //given
        int[] firstArray = {1, 5, 7, 8, 2, 5};
        int[] secondArray = {1, 6, 2, 6, 2, 10};
        //when
        int[] expectedFirstArray = {1, 6, 2, 6, 2, 10};
        int[] expectedSecondArray = {1, 5, 7, 8, 2, 5};
        App.exchangeValues(firstArray,secondArray);

        //then
        Assert.assertEquals(firstArray,expectedFirstArray);
        Assert.assertEquals(secondArray,expectedSecondArray);
    }

    public void testExchangeValuesUsingBinaryOperator() {
        //given
        int[] firstArray = {1, 5, 7, 8, 2, 5};
        int[] secondArray = {1, 6, 2, 6, 2, 10};
        //when
        int[] expectedFirstArray = {1, 6, 2, 6, 2, 10};
        int[] expectedSecondArray = {1, 5, 7, 8, 2, 5};
        App.exchangeValues(firstArray,secondArray);

        //then
        Assert.assertEquals(firstArray,expectedFirstArray);
        Assert.assertEquals(secondArray,expectedSecondArray);
    }

    public void testSortAlmostSortedArray() {
        //given
        int[] array = {1, 2, 10, 17, 19, 15, 21, 50};
        //when
        int[] expected = {1, 2, 10, 15, 17, 19, 21, 50};
        App.sortAlmostSortedArray(array);
        Assert.assertEquals(array,expected);
    }

    public void isSubTree_shouldReturnTrue() {
        //given
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right.left = new Node (4);
        tree.right.right = new Node (5);
        Node subtree = new Node(3);
        subtree.left = new Node(4);
        subtree.right = new Node(5);
        Node secondSubtree = new Node(3);
        secondSubtree.left = new Node(4);
        //when
        boolean actual = App.isSubTree(tree,subtree);
        //then
        Assert.assertTrue(actual);
    }

    public void isSubTree_shouldReturnFalse() {
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right.left = new Node (4);
        tree.right.right = new Node (5);
        Node subtree = new Node(3);
        subtree.left = new Node(4);
        subtree.right = new Node (10);
        //when
        boolean actual = App.isSubTree(tree,subtree);
        //then
        Assert.assertFalse(actual);
    }
}