package at.bib.controller;

import at.bib.dtos.BuchDTO;
import at.bib.dtos.BuchPageDTO;
import at.bib.service.BuchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class BuchController {

    @Autowired
    private BuchService buchService;

    @GetMapping
    public String greet() {
        return "Welcome";
    }

    @GetMapping("/books")
    public List<BuchDTO> getUsersList() {
        return buchService.getAllBooks();
    }

    @PostMapping("/books")
    public void addBook(@RequestBody BuchDTO buch) {
        buchService.saveBook(buch);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id) {
        buchService.deleteBookById(id);
    }

    @PutMapping("/books/{id}")
    public void updateBook(@PathVariable Long id, @RequestBody BuchDTO buch) {
        buchService.updateBook(id, buch);
    }

    @GetMapping("/books/paginated/{page}/{size}")
    public BuchPageDTO getBooksPaginatedWithCount(@PathVariable int page, @PathVariable int size) {
        return buchService.getBooksPaginatedWithCount(page, size);
    }
}
