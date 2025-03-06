/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package driver.crud.services.driver;

import driver.crud.dto.drivers.DriverResponseDTO;
import driver.crud.dto.drivers.NewDriverRequestDTO;
import driver.crud.dto.drivers.UpdateDriverRequestDTO;
import driver.crud.entities.drivers.Driver;
import driver.crud.exceptions.DuplicatedEntityException;
import driver.crud.exceptions.NotFoundException;
import driver.crud.exceptions.ServiceException;
import driver.crud.repositories.DriverRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jose
 */
@Service
@Slf4j
@Transactional(rollbackFor = ServiceException.class)
public class DriverServiceImpl implements DriverService {

    private DriverRepository driverRepository;

    @Autowired
    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public DriverResponseDTO createDriver(NewDriverRequestDTO newDriver) {
        Driver newDriverEntity = new Driver();
        newDriverEntity.setAge(newDriver.getAge());
        newDriverEntity.setName(newDriver.getName());

        newDriverEntity = driverRepository.save(newDriverEntity);

        return new DriverResponseDTO(newDriverEntity);
    }

    @Override
    public List<DriverResponseDTO> findAll() {
        return driverRepository.findAll()
                .stream()
                //.map(driver -> new DriverResponseDTO(driver))
                .map(DriverResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteDriver(Long id) throws NotFoundException {
        Optional<Driver> driverToDelete = driverRepository.findById(id);
        if (driverToDelete.isEmpty()) {
            throw new NotFoundException(String.format("Driver with Id: %s not found", id));
        }
        driverRepository.deleteById(id);
    }

    public DriverResponseDTO updateDriver(Long id, UpdateDriverRequestDTO dataToUpdate) throws ServiceException {
        Driver driverToUpdate = driverRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Driver with Id: %s not found", id)));
        /*Driver driverToUpdate = driverRepository.findDuplicatedByNameAndId(id, dataToUpdate.getName()).
                stream().
                findFirst()
                .orElseThrow(() -> new NotFoundException(String.format("Driver with Id: %s not found", id)));*/

        Optional<Driver> duplicatedDriver = driverRepository.findFirstByNameAndNotId(id, dataToUpdate.getName());

        if (duplicatedDriver.isPresent()) {
            throw new DuplicatedEntityException(String.format("Driver with name: %s already exists", dataToUpdate.getName()));
        }

        driverToUpdate.setName(dataToUpdate.getName());
        driverToUpdate.setAge(dataToUpdate.getAge());
        
        driverRepository.save(driverToUpdate);

        return new DriverResponseDTO(driverToUpdate);
    }
}
