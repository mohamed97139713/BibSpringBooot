package at.bib.controller;

import at.bib.dtos.BuchDTO;
import at.bib.service.BuchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
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
}
