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
                BuchDTO.builder().titel("Der kleine Prinz").autor("Antoine de Saint-Exupéry").erscheinungsjahr(1943).verfuegbar("J").build(),

                BuchDTO.builder().titel("Die Säulen der Erde").autor("Ken Follett").erscheinungsjahr(1989).verfuegbar("J").build(),
                BuchDTO.builder().titel("Der Herr der Ringe").autor("J.R.R. Tolkien").erscheinungsjahr(1954).verfuegbar("N").build(),
                BuchDTO.builder().titel("Harry Potter und der Stein der Weisen").autor("J.K. Rowling").erscheinungsjahr(1997).verfuegbar("J").build(),
                BuchDTO.builder().titel("Stolz und Vorurteil").autor("Jane Austen").erscheinungsjahr(1813).verfuegbar("J").build(),
                BuchDTO.builder().titel("Die Tribute von Panem").autor("Suzanne Collins").erscheinungsjahr(2008).verfuegbar("J").build(),
                BuchDTO.builder().titel("Der große Gatsby").autor("F. Scott Fitzgerald").erscheinungsjahr(1925).verfuegbar("N").build(),
                BuchDTO.builder().titel("To Kill a Mockingbird").autor("Harper Lee").erscheinungsjahr(1960).verfuegbar("J").build(),
                BuchDTO.builder().titel("Die unendliche Geschichte").autor("Michael Ende").erscheinungsjahr(1979).verfuegbar("J").build(),
                BuchDTO.builder().titel("Der Fänger im Roggen").autor("J.D. Salinger").erscheinungsjahr(1951).verfuegbar("N").build(),
                BuchDTO.builder().titel("Die Göttliche Komödie").autor("Dante Alighieri").erscheinungsjahr(1320).verfuegbar("J").build(),

                BuchDTO.builder().titel("Der Prozess").autor("Franz Kafka").erscheinungsjahr(1925).verfuegbar("J").build(),
                BuchDTO.builder().titel("Der Hobbit").autor("J.R.R. Tolkien").erscheinungsjahr(1937).verfuegbar("N").build(),
                BuchDTO.builder().titel("Brave New World").autor("Aldous Huxley").erscheinungsjahr(1932).verfuegbar("J").build(),
                BuchDTO.builder().titel("Der Graf von Monte Christo").autor("Alexandre Dumas").erscheinungsjahr(1844).verfuegbar("J").build(),
                BuchDTO.builder().titel("Das Parfum").autor("Patrick Süskind").erscheinungsjahr(1985).verfuegbar("N").build(),
                BuchDTO.builder().titel("Anna Karenina").autor("Leo Tolstoi").erscheinungsjahr(1877).verfuegbar("J").build(),
                BuchDTO.builder().titel("Krieg und Frieden").autor("Leo Tolstoi").erscheinungsjahr(1869).verfuegbar("N").build(),
                BuchDTO.builder().titel("Jane Eyre").autor("Charlotte Brontë").erscheinungsjahr(1847).verfuegbar("J").build(),
                BuchDTO.builder().titel("Wuthering Heights").autor("Emily Brontë").erscheinungsjahr(1847).verfuegbar("J").build(),
                BuchDTO.builder().titel("Der goldene Kompass").autor("Philip Pullman").erscheinungsjahr(1995).verfuegbar("N").build(),

                BuchDTO.builder().titel("Middlesex").autor("Jeffrey Eugenides").erscheinungsjahr(2002).verfuegbar("J").build(),
                BuchDTO.builder().titel("Der Distelfink").autor("Donna Tartt").erscheinungsjahr(2013).verfuegbar("N").build(),
                BuchDTO.builder().titel("Lolita").autor("Vladimir Nabokov").erscheinungsjahr(1955).verfuegbar("J").build(),
                BuchDTO.builder().titel("Der Report der Magd").autor("Margaret Atwood").erscheinungsjahr(1985).verfuegbar("J").build(),
                BuchDTO.builder().titel("Das Bildnis des Dorian Gray").autor("Oscar Wilde").erscheinungsjahr(1890).verfuegbar("N").build(),
                BuchDTO.builder().titel("Der Alchemist").autor("Ben Jonson").erscheinungsjahr(1610).verfuegbar("J").build(),
                BuchDTO.builder().titel("Der Schatten des Windes").autor("Carlos Ruiz Zafón").erscheinungsjahr(2001).verfuegbar("J").build(),
                BuchDTO.builder().titel("Der Pate").autor("Mario Puzo").erscheinungsjahr(1969).verfuegbar("N").build(),
                BuchDTO.builder().titel("Das Café am Rande der Welt").autor("John Strelecky").erscheinungsjahr(2003).verfuegbar("J").build(),
                BuchDTO.builder().titel("Der alte Mann und das Meer").autor("Ernest Hemingway").erscheinungsjahr(1952).verfuegbar("J").build(),

                BuchDTO.builder().titel("Per Anhalter durch die Galaxis").autor("Douglas Adams").erscheinungsjahr(1979).verfuegbar("N").build(),
                BuchDTO.builder().titel("Die Bücherdiebin").autor("Markus Zusak").erscheinungsjahr(2005).verfuegbar("J").build(),
                BuchDTO.builder().titel("Der Name des Windes").autor("Patrick Rothfuss").erscheinungsjahr(2007).verfuegbar("N").build(),
                BuchDTO.builder().titel("Der Medicus").autor("Noah Gordon").erscheinungsjahr(1986).verfuegbar("J").build(),
                BuchDTO.builder().titel("Die Entdeckung der Currywurst").autor("Uwe Timm").erscheinungsjahr(1993).verfuegbar("J").build(),
                BuchDTO.builder().titel("Der kleine Hobbit").autor("J.R.R. Tolkien").erscheinungsjahr(1937).verfuegbar("N").build(),
                BuchDTO.builder().titel("Die drei ??? und das Gespensterschloss").autor("Alfred Hitchcock").erscheinungsjahr(1968).verfuegbar("J").build(),
                BuchDTO.builder().titel("Der Schatten").autor("John Katzenbach").erscheinungsjahr(2004).verfuegbar("J").build(),
                BuchDTO.builder().titel("Der Schwarm").autor("Frank Schätzing").erscheinungsjahr(2004).verfuegbar("N").build(),
                BuchDTO.builder().titel("Der Trafikant").autor("Robert Seethaler").erscheinungsjahr(2012).verfuegbar("J").build(),

                BuchDTO.builder().titel("Der Besuch der alten Dame").autor("Friedrich Dürrenmatt").erscheinungsjahr(1956).verfuegbar("J").build(),
                BuchDTO.builder().titel("Der Vorleser").autor("Bernhard Schlink").erscheinungsjahr(1995).verfuegbar("N").build(),
                BuchDTO.builder().titel("Effi Briest").autor("Theodor Fontane").erscheinungsjahr(1896).verfuegbar("J").build(),
                BuchDTO.builder().titel("Der Sandmann").autor("E.T.A. Hoffmann").erscheinungsjahr(1816).verfuegbar("J").build(),
                BuchDTO.builder().titel("Die Blechtrommel").autor("Günter Grass").erscheinungsjahr(1959).verfuegbar("N").build(),
                BuchDTO.builder().titel("Buddenbrooks").autor("Thomas Mann").erscheinungsjahr(1901).verfuegbar("J").build(),
                BuchDTO.builder().titel("Der Zauberberg").autor("Thomas Mann").erscheinungsjahr(1924).verfuegbar("N").build(),
                BuchDTO.builder().titel("Tonio Kröger").autor("Thomas Mann").erscheinungsjahr(1903).verfuegbar("J").build(),
                BuchDTO.builder().titel("Effi Briest").autor("Theodor Fontane").erscheinungsjahr(1896).verfuegbar("J").build(),
                BuchDTO.builder().titel("Der Schimmelreiter").autor("Theodor Storm").erscheinungsjahr(1888).verfuegbar("N").build(),

                BuchDTO.builder().titel("Der Steppenwolf").autor("Hermann Hesse").erscheinungsjahr(1927).verfuegbar("J").build(),
                BuchDTO.builder().titel("Siddhartha").autor("Hermann Hesse").erscheinungsjahr(1922).verfuegbar("J").build(),
                BuchDTO.builder().titel("Narziß und Goldmund").autor("Hermann Hesse").erscheinungsjahr(1930).verfuegbar("N").build(),
                BuchDTO.builder().titel("Das Glasperlenspiel").autor("Hermann Hesse").erscheinungsjahr(1943).verfuegbar("J").build(),
                BuchDTO.builder().titel("Der Ursprung der Welt").autor("Liv Strömquist").erscheinungsjahr(2017).verfuegbar("J").build(),
                BuchDTO.builder().titel("Der Pate").autor("Mario Puzo").erscheinungsjahr(1969).verfuegbar("N").build(),
                BuchDTO.builder().titel("Das Jesus-Video").autor("Andreas Eschbach").erscheinungsjahr(1998).verfuegbar("J").build(),
                BuchDTO.builder().titel("Tintenherz").autor("Cornelia Funke").erscheinungsjahr(2003).verfuegbar("J").build(),
                BuchDTO.builder().titel("Krabat").autor("Otfried Preußler").erscheinungsjahr(1971).verfuegbar("N").build(),
                BuchDTO.builder().titel("Die unendliche Geschichte").autor("Michael Ende").erscheinungsjahr(1979).verfuegbar("J").build(),

                BuchDTO.builder().titel("Die Känguru-Chroniken").autor("Marc-Uwe Kling").erscheinungsjahr(2009).verfuegbar("J").build(),
                BuchDTO.builder().titel("Der Schwarm").autor("Frank Schätzing").erscheinungsjahr(2004).verfuegbar("J").build(),
                BuchDTO.builder().titel("Das Lied von Eis und Feuer").autor("George R. R. Martin").erscheinungsjahr(1996).verfuegbar("N").build(),
                BuchDTO.builder().titel("Die Zwerge").autor("Markus Heitz").erscheinungsjahr(2003).verfuegbar("J").build(),
                BuchDTO.builder().titel("Der Medicus").autor("Noah Gordon").erscheinungsjahr(1986).verfuegbar("J").build(),
                BuchDTO.builder().titel("Die Säulen der Erde").autor("Ken Follett").erscheinungsjahr(1989).verfuegbar("J").build(),
                BuchDTO.builder().titel("Das Parfum").autor("Patrick Süskind").erscheinungsjahr(1985).verfuegbar("N").build(),
                BuchDTO.builder().titel("Der Alchimist").autor("Paulo Coelho").erscheinungsjahr(1988).verfuegbar("J").build(),
                BuchDTO.builder().titel("Die Chroniken von Narnia").autor("C. S. Lewis").erscheinungsjahr(1950).verfuegbar("J").build(),
                BuchDTO.builder().titel("Der Schatten des Windes").autor("Carlos Ruiz Zafón").erscheinungsjahr(2001).verfuegbar("J").build(),

                BuchDTO.builder().titel("Per Anhalter durch die Galaxis").autor("Douglas Adams").erscheinungsjahr(1979).verfuegbar("N").build(),
                BuchDTO.builder().titel("Die Tribute von Panem").autor("Suzanne Collins").erscheinungsjahr(2008).verfuegbar("J").build(),
                BuchDTO.builder().titel("Der Name des Windes").autor("Patrick Rothfuss").erscheinungsjahr(2007).verfuegbar("N").build(),
                BuchDTO.builder().titel("Die Bücherdiebin").autor("Markus Zusak").erscheinungsjahr(2005).verfuegbar("J").build(),
                BuchDTO.builder().titel("Das Spiel der Götter").autor("Bernhard Hennen").erscheinungsjahr(2004).verfuegbar("J").build(),
                BuchDTO.builder().titel("Die Entdeckung der Langsamkeit").autor("Sten Nadolny").erscheinungsjahr(1983).verfuegbar("J").build(),
                BuchDTO.builder().titel("Die unendliche Geschichte").autor("Michael Ende").erscheinungsjahr(1979).verfuegbar("J").build(),
                BuchDTO.builder().titel("Der Kleine Prinz").autor("Antoine de Saint-Exupéry").erscheinungsjahr(1943).verfuegbar("J").build(),
                BuchDTO.builder().titel("Siddhartha").autor("Hermann Hesse").erscheinungsjahr(1922).verfuegbar("J").build(),
                BuchDTO.builder().titel("Der Steppenwolf").autor("Hermann Hesse").erscheinungsjahr(1927).verfuegbar("N").build(),

                BuchDTO.builder().titel("Der Prozess").autor("Franz Kafka").erscheinungsjahr(1925).verfuegbar("J").build(),
                BuchDTO.builder().titel("Faust").autor("Johann Wolfgang von Goethe").erscheinungsjahr(1808).verfuegbar("N").build(),
                BuchDTO.builder().titel("Momo").autor("Michael Ende").erscheinungsjahr(1973).verfuegbar("J").build(),
                BuchDTO.builder().titel("Krabat").autor("Otfried Preußler").erscheinungsjahr(1971).verfuegbar("N").build(),
                BuchDTO.builder().titel("Der Glöckner von Notre-Dame").autor("Victor Hugo").erscheinungsjahr(1831).verfuegbar("J").build(),
                BuchDTO.builder().titel("Don Quijote").autor("Miguel de Cervantes").erscheinungsjahr(1605).verfuegbar("N").build(),
                BuchDTO.builder().titel("Oliver Twist").autor("Charles Dickens").erscheinungsjahr(1838).verfuegbar("J").build(),
                BuchDTO.builder().titel("Die Abenteuer des Sherlock Holmes").autor("Arthur Conan Doyle").erscheinungsjahr(1892).verfuegbar("J").build(),
                BuchDTO.builder().titel("Der Graf von Monte Christo").autor("Alexandre Dumas").erscheinungsjahr(1844).verfuegbar("J").build(),
                BuchDTO.builder().titel("Der Hund von Baskerville").autor("Arthur Conan Doyle").erscheinungsjahr(1902).verfuegbar("N").build()

        );


        List<Buch> buchEntities = buecher.stream()
                .map(buchMapper::toEntity)
                .toList();

        buchRepository.saveAll(buchEntities);
    }
}
