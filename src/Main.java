import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // úkol 3
        /*Path vetySoubor = Path.of("src/data/text_ke_kontrole.txt");
        Path vystupniSoubor = Path.of("src/data/text_cenzura.txt");
        Path cenzurovaneSlova = Path.of("src/data/zakazana_slova.txt");

        List<String> zakazanaSlova = Files.readAllLines(cenzurovaneSlova);
        String text = Files.readString(vetySoubor);
        for (String slova : zakazanaSlova) {
            String slovaFinal = slova.trim().toLowerCase();
            if (slovaFinal.isEmpty()) {
                continue;
            }
            String hvezdicky = "";
            for (int i = 0; i < slovaFinal.length(); i++) {
                hvezdicky += "*";
            }
            text = text.replace(slovaFinal, hvezdicky);
        }
        Files.writeString(Path.of(vystupniSoubor.toUri()), text);*/

        //úkol 2
        Path vstupniSoubor = Path.of("src/data/slova_opravene.txt");
        Path statistikaSouboru = Path.of("src/data/statistika.txt");

        List<String> radky = Files.readAllLines(vstupniSoubor);
        List<String> slova = new ArrayList<>();

        for (String radek : radky) {
            slova.add(radek);
        }
        int pocetSlov = slova.size();
        int celkovaDelka = 0;
        int maxDelka = 0;
        int minDelka = 999999;

        for (String s : slova) {
            int delka = s.length();
            celkovaDelka = celkovaDelka + delka;
            if (delka > maxDelka) {
                maxDelka = delka;
            }
            if (delka < minDelka) {
                minDelka = delka;
            }
        }
        double prumer = (double) celkovaDelka / pocetSlov;
        String nejdelsiSlovo = "";
        String nejkratsiSlovo = "";
        for (String s : slova) {
            if (s.length() == maxDelka) {
                nejdelsiSlovo += s + "";
            }
            if (s.length() == minDelka) {
                nejkratsiSlovo += s + "";
            }
        }
        String vysledek = "počet slov: " + pocetSlov + " průměrná délka " + prumer + " nejdelší slovo: " + nejdelsiSlovo + " nejkratší slovo: " + nejkratsiSlovo;
        Files.writeString(statistikaSouboru, vysledek);

    }
}