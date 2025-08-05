package com.pw.leiloeiro.api.Controllers;

import com.pw.leiloeiro.api.DTO.ResponseAnyDTO;
import com.pw.leiloeiro.api.Domains.Image.Image;
import com.pw.leiloeiro.api.Services.ImageService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.Collections;

@Controller
@RequestMapping(value = "/images")
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping
    public ResponseEntity<ResponseAnyDTO> create(@Valid @RequestBody Image image){
        imageService.create(image);
        return ResponseEntity.ok().body(new ResponseAnyDTO(200, "", "Imagem cadastrada com sucesso", Collections.emptyList()));
    }
    @GetMapping
    public ResponseEntity<ResponseAnyDTO> searchAll(){
        return ResponseEntity.ok().body(new ResponseAnyDTO(200, "","", imageService.search()));
    }

    @PutMapping
    public ResponseEntity<ResponseAnyDTO> edit(@RequestBody Image image){
        Image img = imageService.update(image);
        if(img !=null){
            return ResponseEntity.ok().body(new ResponseAnyDTO(200, "", "Categoria atualizada com sucesso", Collections.emptyList()));
        }
        return  null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseAnyDTO> delete(@PathVariable("id") Long id){
        imageService.delete(id);
        return ResponseEntity.ok().body(new ResponseAnyDTO(200, "","",Collections.emptyList()));
    }

}
