package com.VirtualSchool.vschool.exception;

import com.VirtualSchool.vschool.model.response.UploadResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//@ControllerAdvice
public class UploadException  {

//    @ExceptionHandler(MaxUploadSizeExceededException.class)
//    public ResponseEntity<UploadResponse> handleMaxSizeException(MaxUploadSizeExceededException exc) {
//        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new UploadResponse("File too large!"));
//    }
}
