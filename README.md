### Hexlet tests and linter status:
[![Actions Status](https://github.com/ligrena/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/ligrena/java-project-71/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/70c47eb92410d119a17e/maintainability)](https://codeclimate.com/github/ligrena/java-project-71/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/70c47eb92410d119a17e/test_coverage)](https://codeclimate.com/github/ligrena/java-project-71/test_coverage)

# Вычислитель отличий между файлами
Консольное приложение, позволяющее находить отличия между файлами.

### Значения для входа:
* filepath1 - абсолютный путь до 1-го файла
* filepath2 - абсолютный путь до 2-го файла

### Вспомогательный опции:

* -h, --help - выводит описание команды
* -f, --format - позволяет указать возможный формат вывода результата

### Форматы различий

* stylish - вывод всех полей в файлах
* simple - вывод измененых полей в текстовом формате
* json - вывод измененных полей в формате json-файла

### Вывод различий между двумя .json файлами
[![asciicast](https://asciinema.org/a/yCu4LjIRn3QrUiFHd2ciKnrDs.svg)](https://asciinema.org/a/yCu4LjIRn3QrUiFHd2ciKnrDs)

### Вывод различий между двумя .yaml файлами
[![asciicast](https://asciinema.org/a/eF93qqkfdFNt0qh7TWeiTSTpa.svg)](https://asciinema.org/a/eF93qqkfdFNt0qh7TWeiTSTpa)

### Вывод различий между двумя файлами с вложенной структурой
[![asciicast](https://asciinema.org/a/1kJUhZjrjL6V4rUkqLzmY3RuS.svg)](https://asciinema.org/a/1kJUhZjrjL6V4rUkqLzmY3RuS)

### Вывод в структурированном формате, таком как json
[![asciicast](https://asciinema.org/a/GHUwZjbjhemMX4brRDA5cOGJK.svg)](https://asciinema.org/a/GHUwZjbjhemMX4brRDA5cOGJK)