package graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SkewHeapTest {

    SkewHeap instance = new SkewHeap();

    @Test
    void createdHeapIsEmptyTest() {
        assertTrue(instance.empty());
    }

    @Test
    void emptiedHeapIsEmptyTest() throws Exception {
        for (int i = 0; i < 10; i++) {
            instance.add(i);
        }
        for (int i = 0; i < 10; i++) {
            instance.removeMin();
        }
        assertTrue(instance.empty());
    }

    @Test
    void emptiedHeapSizeIsZeroTest() throws Exception {
        for (int i = 0; i < 10; i++) {
            instance.add(i);
        }
        for (int i = 0; i < 10; i++) {
            instance.removeMin();
        }
        assertEquals(0, instance.size());
    }

    @Test
    void addMultipleDistinctElementsTest() {
        for (int i = 0; i < 100; i++) {
            instance.add(i);
        }
        assertEquals(100, instance.size());
    }

    @Test
    void getMinWithOnlyOneExistingElementTest() throws Exception {
        instance.add(-1);
        assertEquals(-1, instance.removeMin());
    }

    @Test
    void tGetMinFromEmptyHeapTest(){
        assertThrows(EmptyHeapException.class, () -> instance.removeMin());
    }

    @Test
    void insertAndGetMinMultipleTimesTest() throws EmptyHeapException {
        for (int i = -99; i < 100; i++) {
            instance.add(i);
        }
        for (int i = -99; i < 100; i++) {
            assertEquals(i, instance.removeMin());
        }
        assertEquals(0, instance.size());
    }

    @Test
    void getMinElementInsertedFirstTest() throws EmptyHeapException {
        for (int i = 0; i < 100; i++) {
            instance.add(i);
        }
        assertEquals(100, instance.size());
    }

    @Test
    void getMinElementInsertedLastTest() throws EmptyHeapException {
        for (int i = 0; i < 100; i++) {
            instance.add(i);
        }
        instance.add(-1);
        assertEquals(-1, instance.removeMin());
    }

    @Test
    void getMinElementInsertedInTheMiddleTest() throws EmptyHeapException {
        for (int i = 50; i < 100; i++) {
            instance.add(i);
        }
        instance.add(33);
        for (int i = 100; i < 150; i++) {
            instance.add(i);
        }
        assertEquals(33, instance.removeMin());
    }

    @Test
    void mergeTest() {
        SkewHeap other = new SkewHeap();
        instance.merge(other);
        assertTrue(instance.empty());
    }


    @Test
    void mergeNonEmptyWithEmptyTest() {
        for (int i = 50; i < 100; i++) {
            instance.add(i);
        }
        SkewHeap other = new SkewHeap();
        instance.merge(other);
        assertEquals(50, instance.size());
    }

    @Test
    void mergeNonEmptyWithNonEmptyTest() {
        for (int i = 0; i < 50; i++) {
            instance.add(i);
        }
        SkewHeap other = new SkewHeap();
        for (int i = 40; i < 90; i++) {
            other.add(i);
        }

        instance.merge(other);

        assertEquals(100, instance.size());
        assertTrue(other.empty());
    }

    @Test
    void testWithReadyAnswer() {
        List<Integer> answer = new ArrayList<Integer>();
        answer.add(5);
        answer.add(3);
        answer.add(1);
        answer.add(4);
        answer.add(2);

        for (int i = 1; i < 6; i++) {
            instance.add(i);
        }
        Assertions.assertEquals(answer, instance.displayHeap());
    }

    @Test
    void testWithReadyAnswer2() {
        List<Integer> answer = new ArrayList<Integer>();
        answer.add(8);
        answer.add(2);
        answer.add(23);
        answer.add(32);
        answer.add(50);

        instance.add(50);
        instance.add(32);
        instance.add(2);
        instance.add(23);
        instance.add(8);

        Assertions.assertEquals(answer, instance.displayHeap());
    }

}
