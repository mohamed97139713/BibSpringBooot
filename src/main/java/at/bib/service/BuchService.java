package at.bib.service;

import at.bib.dtos.BuchDTO;
import at.bib.dtos.BuchPageDTO;
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

    public List<BuchDTO> getBooksPaginated(int page, int size) {
        return buchRepository.getBooksPaginated(page, size)
                .stream()
                .map(buchMapper::toDto)
                .collect(Collectors.toList());
    }

    public BuchPageDTO getBooksPaginatedWithCount(int page, int size) {
        List<BuchDTO> content = getBooksPaginated(page, size);
        long totalItems = countBooks();
        int totalPages = (int) Math.ceil((double) totalItems / size);

        BuchPageDTO pageDTO = new BuchPageDTO();
        pageDTO.setContent(content);
        pageDTO.setPage(page);
        pageDTO.setSize(size);
        pageDTO.setTotalItems(totalItems);
        pageDTO.setTotalPages(totalPages);

        return pageDTO;
    }

    public long countBooks() {
        return buchRepository.countBooks();
    }
}
