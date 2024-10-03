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
