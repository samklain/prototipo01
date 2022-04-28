package com.prototipo02.samflix.controller;

import com.prototipo02.samflix.domain.Prototipo;
import com.prototipo02.samflix.service.PrototipoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.prototipo02.samflix.util.DateUtil;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("samflix")
@Log4j2
@RequiredArgsConstructor
//@AllArgsConstructor
public class PrototipoController {
    private final DateUtil dateUtil;
    private final PrototipoService prototipoService;

    //localhost:8080/prototipo/list
    @GetMapping
    public ResponseEntity<List<Prototipo>> list(){
        log.info(dateUtil.formatLocalDateTimeToDataBaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(prototipoService.listAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Prototipo> findById(@PathVariable long id){
        return ResponseEntity.ok(prototipoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Prototipo> save(@RequestBody Prototipo prototipo) {
        prototipoService.save(prototipo);
        return new ResponseEntity<>(prototipoService.save(prototipo), HttpStatus.CREATED);
    }
}
