package com.pw.leiloeiro.api.Services;

import com.pw.leiloeiro.api.Domains.Image.Image;
import com.pw.leiloeiro.api.Infra.Exception.NotFound;
import com.pw.leiloeiro.api.Repositories.ImageRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    private final ImageRepository imageRepository;


    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Transactional
    public Image create(@Valid Image image){
        return imageRepository.save(image);
    }

    public List<Image> search(){
        return imageRepository.findAll();
    }
    public Image update(Image image) {
        Image imgBanco = buscarPorId(image.getId_img());
        imgBanco.setName_image(image.getName_image());
        return imageRepository.save(imgBanco);
    }

    public void delete(Long id){
        Image imgBanco = buscarPorId(id);
         imageRepository.delete(imgBanco);
    }

    public Image buscarPorId(Long id) {
        return imageRepository.findById(id)
                .orElseThrow(() -> new NotFound("Imagem não encontrada para edição"));
    }
}
