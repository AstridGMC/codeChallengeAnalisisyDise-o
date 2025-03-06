/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package driver.crud.services.driver;

import driver.crud.dto.drivers.DriverResponseDTO;
import driver.crud.dto.drivers.NewDriverRequestDTO;
import driver.crud.dto.drivers.UpdateDriverRequestDTO;
import driver.crud.exceptions.ServiceException;
import java.util.List;

/**
 *
 * @author jose
 */
public interface DriverService {

    DriverResponseDTO createDriver(NewDriverRequestDTO newDriver);

    List<DriverResponseDTO> findAll();

    void deleteDriver(Long id) throws ServiceException;

    DriverResponseDTO updateDriver(Long id, UpdateDriverRequestDTO dataToUpdate)
            throws ServiceException;
}
