package telran.range;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BrokenFloorTest {

    private int getMinimalBrokenFloor(BallBrokenFloor bbf) {
        int min = 1;
        int max = Integer.MAX_VALUE;
        int result = -1;
    
        while (min <= max) {
            int mid = (min + max) / 2;
            try {
                bbf.checkFloor(mid);
                min = mid + 1;
            } catch (Exception e) {
                result = mid;
                max = mid - 1;
            }
        }
    
        return result;
    }

@Test
void minimalBrokenFloorTest() {
    int [] floors = {200, 17, 1001, 2000};
    for(int i = 0; i < floors.length; i++) {
        BallBrokenFloor bbf = new BallBrokenFloor(floors[i]);
        assertEquals(bbf.getMinBrokenFloor(), getMinimalBrokenFloor(bbf));
    }
}
}
