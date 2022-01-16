package pl.beatahumeniuk.core.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.beatahumeniuk.core.model.dto.LawsuitDTO;
import pl.beatahumeniuk.core.model.entity.Lawsuit;
import pl.beatahumeniuk.core.service.LawsuitsService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LawsuitsController {

    private final LawsuitsService lawsuitsService;

    @GetMapping
    public ResponseEntity<List<LawsuitDTO>> findAll(){
        return ResponseEntity.ok(lawsuitsService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LawsuitDTO> getOneById(@PathVariable("id") Long id){
        return ResponseEntity.ok(lawsuitsService.getOneById(id));
    }

    @GetMapping("/signature")
    public ResponseEntity<LawsuitDTO> getOneBySignature(@RequestParam("signature") String signature){
        return ResponseEntity.ok(lawsuitsService.getOneBySignature(signature));
    }

    @PostMapping
    public ResponseEntity<LawsuitDTO> createLawsuit(@RequestBody LawsuitDTO lawsuitDTO) {
        return ResponseEntity.ok(lawsuitsService.createLawsuit(lawsuitDTO));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<LawsuitDTO> updateLawsuit(@PathVariable("id") Long id, @RequestBody LawsuitDTO lawsuitDTO) {
        return ResponseEntity.ok(lawsuitsService.updateLawsuit(id, lawsuitDTO));
    }
}
