package br.com.api.infrastructure.resource;

import br.com.api.infrastructure.service.InfrastructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author douglasog87@gmail.com
 * @since 29/12/2016
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class InfrastructureResource {

    @Autowired
    private InfrastructureService infrastructureService;

    @RequestMapping(value = "/v1/infrastructureEngine/getDateTime", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> getDateTime() {
        return new ResponseEntity<>(infrastructureService.getDateTime(), HttpStatus.OK);
    }

}