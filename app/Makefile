.DEFAULT_GOAL := build-run
run-dist:
	./build/install/app/bin/app $(val1) $(val2)

clean:
	./gradlew clean

build:
	 ./gradlew clean build test

install:
	./gradlew clean installDist

.PHONY: build`