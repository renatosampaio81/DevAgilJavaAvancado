package br.com.coursera.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TranslateModel {
    private Map<String, String> translations;

    public TranslateModel() {
        translations = new HashMap<>();
        // Carrega as traduções do arquivo.
        loadTranslations();
    }

    private void loadTranslations() {
        try (InputStream is = getClass().getResourceAsStream("/palavras_ptbr_eng.txt");
             InputStreamReader isr = new InputStreamReader(is);
             BufferedReader reader = new BufferedReader(isr)) {

            String line;
            while ((line = reader.readLine()) != null) {
                // Divide a linha em português e inglês usando um espaço como delimitador.
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    // Adiciona a tradução ao mapa.
                    translations.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String translate(String word) {
        // Tenta encontrar a tradução em português.
        String translation = translations.get(word.toLowerCase());

        // Se não encontrar, tenta encontrar em inglês.
        if (translation == null) {
            // Inverte a busca: procura a palavra em inglês e retorna a tradução em português.
            for (Map.Entry<String, String> entry : translations.entrySet()) {
                if (entry.getValue().equalsIgnoreCase(word)) {
                    translation = entry.getKey();
                    break;
                }
            }
        }

        // Se não encontrar em nenhum idioma, retorna a própria palavra.
        if (translation == null) {
            translation = word;
        }

        return translation;
    }
}