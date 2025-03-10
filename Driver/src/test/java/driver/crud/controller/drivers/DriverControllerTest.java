/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package driver.crud.controller.drivers;

import driver.crud.controller.exceptionhandler.GlobalExceptionHandler;
import driver.crud.dto.drivers.DriverResponseDTO;
import driver.crud.entities.drivers.Driver;
import driver.crud.exceptions.NotFoundException;
import driver.crud.services.driver.DriverService;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import org.springframework.test.context.ContextConfiguration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author jose
 */
@ContextConfiguration(classes = {DriverController.class, DriverService.class, GlobalExceptionHandler.class})
public class DriverControllerTest extends AbstractMvcTest {

    private static final Long DRIVER_ID = 1L;
    private static final String DRIVER_NAME = "driver name";
    private static final int DRIVER_AGE = 21;

    @MockBean
    private DriverService driverService;

    @Test
    @WithMockUser("ADMIN")
    public void testFindAllDrivers() throws Exception {
        // Arrange
        Driver driverEntity = new Driver();
        driverEntity.setAge(DRIVER_AGE);
        driverEntity.setName(DRIVER_NAME);
        driverEntity.setId(DRIVER_ID);
        DriverResponseDTO driverDTO = new DriverResponseDTO(driverEntity);
        when(driverService.findAll()).thenReturn(Collections.singletonList(driverDTO));

        // Act
        mockMvc.perform(get("/v1/drivers"))
                // Assert
                .andExpect(status().isOk())
                .andExpect((result) -> {
                    String json = result.getResponse().getContentAsString();
                    Assertions.assertThat(json).isEqualTo(objectMapper.writeValueAsString(Collections.singletonList(driverDTO)));
                })
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(Collections.singletonList(driverDTO))));
    }

    @Test
    @WithMockUser("ADMIN")
    public void testDeleteDriver() throws Exception {
        // Act
        mockMvc.perform(delete("/v1/drivers/{driverId}", DRIVER_ID)
                .with(csrf()))
                // Assert
                .andExpect(status().isAccepted());
        Mockito.verify(driverService).deleteDriver(DRIVER_ID);
    }

    @Test
    @WithMockUser("ADMIN")
    public void testDeleteDriverWhenDriverDoesNotExists() throws Exception {
        // Arrange
        Mockito.doThrow(NotFoundException.class).when(driverService).deleteDriver(DRIVER_ID);

        // Act
        mockMvc.perform(delete("/v1/drivers/{driverId}", DRIVER_ID)
                .with(csrf()))
                // Assert
                .andExpect(status().isNotFound());
        Mockito.verify(driverService).deleteDriver(DRIVER_ID);
    }
}
