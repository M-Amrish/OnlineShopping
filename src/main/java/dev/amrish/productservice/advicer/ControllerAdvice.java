package dev.amrish.productservice.advicer;

import dev.amrish.productservice.dto.ErrorDTO;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

//This is golbal. This will be called when any exception
// is thrown by any conntroller

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorDTO> handlerNullPointerException(){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMsg("Something when wrong plz try after 15mim...!");

        return new ResponseEntity<>(errorDTO, HttpStatusCode.valueOf(404));
    }

    @ExceptionHandler(IllegalAccessException.class)
    public ResponseEntity<ErrorDTO>  handleInvalidTokenException(){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMsg("Invalid Token");

        return new ResponseEntity<>(errorDTO,
                HttpStatusCode.valueOf(404));
    }
}
