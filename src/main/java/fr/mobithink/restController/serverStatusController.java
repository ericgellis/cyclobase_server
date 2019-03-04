package fr.mobithink.restController;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by athiel on 10/02/2017.
 */

@RestController
@RequestMapping(value = "/mobithink/velo/server" )
public class serverStatusController {

    /**
     *
     * GET. wake up server
     *
     *
     * @return  "success" or null
     *
     *
     */
    @GetMapping(path = "/wakeup", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<Void> wakeup() {
    	
       return new ResponseEntity<>(null, new HttpHeaders(), org.springframework.http.HttpStatus.OK);

    }
}
