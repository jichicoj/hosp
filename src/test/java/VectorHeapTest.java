import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorHeapTest {
    VectorHeap<Patient> patientVectorHeap;

    @BeforeEach
    void setUp() {
        patientVectorHeap = new VectorHeap<>();
        patientVectorHeap.add(new Patient("Karla Kant", "Fractura de brazo", "C"));
        patientVectorHeap.add(new Patient("Ronaldo Rosales", "Impacto de bala", "B"));
        patientVectorHeap.add(new Patient("Carlos Cane", "Apendicitis", "A"));
    }

    @Test
    void parent() {
        assertEquals(0, patientVectorHeap.parent(2));
    }

    @Test
    void left() {
        assertEquals(1, patientVectorHeap.left(0));
    }

    @Test
    void right() {
        assertEquals(2, patientVectorHeap.right(0));
    }

    @Test
    void isEmpty() {
        assertEquals(false, patientVectorHeap.isEmpty());
    }

    @Test
    void size() {
        assertEquals(3, patientVectorHeap.size());
    }

    @Test
    void getFirst() {
        assertEquals("Carlos Cane", patientVectorHeap.getFirst().getName());
    }

    @Test
    void remove() {
        assertEquals("Carlos Cane", patientVectorHeap.remove().getName());
    }
}