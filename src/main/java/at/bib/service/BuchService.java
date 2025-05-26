package at.bib.service;

import at.bib.dtos.BuchDTO;
import at.bib.mapper.BuchMapper;
import at.bib.model.Buch;
import at.bib.repositories.BuchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BuchService {

    private final BuchMapper buchMapper;
    private final BuchRepository buchRepository;

    public List<BuchDTO> getAllBooks() {
        return buchRepository.getAllBooks()
                .stream()
                .map(buchMapper::toDto)
                .collect(Collectors.toList());
    }

    public void saveBook(BuchDTO buch) {
        buchRepository.save(buchMapper.toEntity(buch));
    }

    public void deleteBookById(Long id) {
        buchRepository.delete(id);
    }


    public void updateBook(Long id, BuchDTO buchDto) {
        Buch existingBuch = buchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Buch nicht gefunden mit ID " + id));

        // Update Felder
        existingBuch.setTitel(buchDto.getTitel());
        existingBuch.setAutor(buchDto.getAutor());
        existingBuch.setErscheinungsjahr(buchDto.getErscheinungsjahr());
        existingBuch.setVerfuegbar(buchDto.getVerfuegbar());

        // Save = merge (update)
        buchRepository.save(existingBuch);
    }

}
