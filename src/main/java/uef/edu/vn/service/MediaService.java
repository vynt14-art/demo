package uef.edu.vn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uef.edu.vn.model.Media;
import uef.edu.vn.repository.MediaRepository;

@Service
public class MediaService {

    @Autowired
    private MediaRepository mediaRepository;

    public Integer saveImagePath(
            String imagePath,
            String fileType) {

        return mediaRepository.saveImagePath(
                imagePath,
                fileType);
    }

    public List<Media> findByType(
            String fileType) {

        return mediaRepository.findByType(
                fileType);
    }
}
