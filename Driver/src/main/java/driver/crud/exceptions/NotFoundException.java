/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package driver.crud.exceptions;

/**
 *
 * @author jose
 */
public class NotFoundException extends ServiceException {

    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }
    
}
