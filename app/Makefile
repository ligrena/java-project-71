.DEFAULT_GOAL := build-run
run-dist:
	./build/install/app/bin/app $(val1) $(val2)

run-f-json-format-test:
	./build/install/app/bin/app -f json ./src/test/resources/fileStylish1.json ./src/test/resources/fileStylish2.json

clean:
	./gradlew clean

build:
	 ./gradlew clean build test

install:
	./gradlew clean installDist

test:
	./gradlew test

.PHONY: build`