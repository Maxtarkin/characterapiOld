package org.max.controllers;

import org.max.models.dto.CharacterModelDto;
import org.max.models.dto.CharacterModelUpdateAndSaveDto;
import org.max.services.CharacterServiceLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CharacterController {

    private final CharacterServiceLogic characterService;

    @Autowired
    CharacterController(CharacterServiceLogic characterService) {
        this.characterService = characterService;
    }

    @PostMapping("/characters")
    public ResponseEntity<?> save(@RequestBody CharacterModelUpdateAndSaveDto modelUpdateAndSaveDto) {
        long id = characterService.save(modelUpdateAndSaveDto);
        return ResponseEntity.ok().body("Character created with id: " + id);
    }

    @GetMapping("/characters/{id}")
    public CharacterModelDto get(@PathVariable("id") long id) {
        return characterService.get(id);
    }

    @PutMapping("/characters/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody CharacterModelUpdateAndSaveDto modelUpdateAndSaveDto) {
        return new ResponseEntity<>(characterService.update(id, modelUpdateAndSaveDto), HttpStatus.OK);
    }

    @DeleteMapping("/characters/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        return new ResponseEntity<>(characterService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/characters")
    public List<CharacterModelDto> listSortedByParam(@RequestParam(required = false) String param) {
        return characterService.listSortedByParam(param);
    }

}
