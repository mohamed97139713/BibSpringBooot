package at.bib;

import at.bib.dtos.BuchDTO;
import at.bib.mapper.BuchMapper;
import at.bib.model.Buch;
import at.bib.repositories.BuchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class BibApplication implements CommandLineRunner {


    @Autowired
    BuchRepository buchRepository;
    @Autowired
    private BuchMapper buchMapper;

    public static void main(String[] args) {
        SpringApplication.run(BibApplication.class, args);
    }

    @Override
    public void run(String... args) {

//        BuchDTO buchDTO = BuchDTO.builder()
//                .titel("Kimbo")
//                .autor("Kimbo")
//                .erscheinungsjahr(2004)
//                .verfuegbar("J")
//                .build();
//
//        Buch buch = buchMapper.toEntity(buchDTO);
//        System.out.println();
//        buchRepository.save(buch);
            List<BuchDTO> buecher = List.of(
                    BuchDTO.builder().titel("Der Alchimist").autor("Paulo Coelho").erscheinungsjahr(1988).verfuegbar("J").build(),
                    BuchDTO.builder().titel("Schatten des Windes").autor("Carlos Ruiz Zafón").erscheinungsjahr(2001).verfuegbar("J").build(),
                    BuchDTO.builder().titel("1984").autor("George Orwell").erscheinungsjahr(1949).verfuegbar("N").build(),
                    BuchDTO.builder().titel("Die Entdeckung der Langsamkeit").autor("Sten Nadolny").erscheinungsjahr(1983).verfuegbar("J").build(),
                    BuchDTO.builder().titel("Momo").autor("Michael Ende").erscheinungsjahr(1973).verfuegbar("J").build(),
                    BuchDTO.builder().titel("Der Steppenwolf").autor("Hermann Hesse").erscheinungsjahr(1927).verfuegbar("N").build(),
                    BuchDTO.builder().titel("Der Name der Rose").autor("Umberto Eco").erscheinungsjahr(1980).verfuegbar("J").build(),
                    BuchDTO.builder().titel("Die Verwandlung").autor("Franz Kafka").erscheinungsjahr(1915).verfuegbar("J").build(),
                    BuchDTO.builder().titel("Faust").autor("Johann Wolfgang von Goethe").erscheinungsjahr(1808).verfuegbar("N").build(),
                    BuchDTO.builder().titel("Der kleine Prinz").autor("Antoine de Saint-Exupéry").erscheinungsjahr(1943).verfuegbar("J").build()
            );

            List<Buch> buchEntities = buecher.stream()
                    .map(buchMapper::toEntity)
                    .toList();

            buchRepository.saveAll(buchEntities);
    }
}
