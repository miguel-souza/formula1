package yasmin.formula1.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import yasmin.formula1.model.ErroBody;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<Object> handleNotFound(NotFoundException ex){
        return new ResponseEntity<>(montarBody("Recurso não encontrado", ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {ErroInternoException.class})
    public ResponseEntity<Object> handleErroInterno(ErroInternoException ex){
        return new ResponseEntity<>(montarBody("Erro interno.", ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ErroBody montarBody(String erro, String descricao){
        ErroBody body = new ErroBody();
        body.setErro(erro);
        body.setDescricao(descricao);
        return body;
    }
}
