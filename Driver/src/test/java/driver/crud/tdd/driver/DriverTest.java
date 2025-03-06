/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package driver.crud.tdd.driver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jose
 */
public class DriverTest {
    
    private static final int NUMBER_A = 5;
    private static final int NUMBER_B = 2;
    private static final int EXPECTED_SUM = 7;
    private static final int EXPECTED_SUBS = 3;
    
    @Test
    void testSumOfTwoNumbers() {
        // Arrange
        Driver driver = new Driver();
        
        // Act
        int result = driver.sum(NUMBER_A, NUMBER_B);
        
        // Assert
        assertEquals(EXPECTED_SUM, result);
    }
    
    @Test
    void testSubstractTwoNumbers() {
        // Arrange
        Driver driver = new Driver();
        
        // Act
        int result = driver.subs(NUMBER_A, NUMBER_B);
        
        // Assert
        assertEquals(EXPECTED_SUBS, result);
    }
}
