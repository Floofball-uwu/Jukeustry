# For installing
MINDUSTRY := $HOME/.local/share/Mindustry

JAVAC := javac
JAVACFLAGS := -g
# Auto-import files in the same package
override JAVACFLAGS += -sourcepath src
# Add .jar libraries
override JAVACFLAGS += -classpath "libs/*"
# Compile against java 8 abi - d8 needs this
override JAVACFLAGS += --release 8

JARFLAGS := -C build/classes .
override JARFLAGS += -C assets .

sources := $(shell find src -type f -name "*.java")
assets := $(shell find assets -type f)
classes := $(patsubst src/%.java, build/classes/%.class, $(sources))

D8 := d8
D8FLAGS := --min-api 14

# Mindustry + arc version to link against
version := v120

all: android

libs: libs/core-release.jar libs/arc-core.jar

libs/core-release.jar:
	@printf "\033[33m> LIB\033[0m\t%s\n" $@
	@mkdir -p libs
	curl 'https://jitpack.io/com/github/Anuken/Mindustry/core/$(version)/core-$(version).jar.sha1' -o $@.sha1 2>/dev/null
	curl 'https://jitpack.io/com/github/Anuken/Mindustry/core/$(version)/core-$(version).jar' -o $@
	@printf "\t%s" "$@" >> $@.sha1
	sha1sum -c $@.sha1
	@rm $@.sha1

libs/arc-core.jar:
	@printf "\033[33m> LIB\033[0m\t%s\n" $@
	curl 'https://jitpack.io/com/github/Anuken/Arc/arc-core/$(version)/arc-core-$(version).jar.sha1' -o $@.sha1 2>/dev/null
	curl 'https://jitpack.io/com/github/Anuken/Arc/arc-core/$(version)/arc-core-$(version).jar' -o $@
	@printf "\t%s" "$@" >> $@.sha1
	sha1sum -c $@.sha1
	@rm $@.sha1

build: JukeboxMod-Desktop.jar
android: build JukeboxMod.jar

build/classes/%.class: src/%.java libs
	@printf "\033[32m> JAVAC\033[0m\t%s\n" $@
	@mkdir -p `dirname $@`
	$(JAVAC) $(JAVACFLAGS) $< -d build/classes

JukeboxMod-Desktop.jar: $(classes) $(assets)
	@printf "\033[33m> JAR\033[0m\t%s\n" $@
	jar -cf $@ $(JARFLAGS) || rm $@

JukeboxMod.jar: JukeboxMod-Desktop.jar
	@printf "\033[33m> D8\033[0m\t%s\n" $@
	$(D8) $(D8FLAGS) --output build $^
	cp ExampleJavaMod-Desktop.jar $@
	cd build; zip -qg ../$@ classes.dex

install: build
	cp JukeboxMod-Desktop.jar $(MINDUSTRY)/mods

clean:
	rm -rf build/classes

reset:
	rm -rf libs build *.jar

help:
	@printf "\033[97;1mAvailable tasks:\033[0m\n"
	@printf "\t\033[32mbuild\033[0m\n"
	@printf "\t  Compile the mod into \033[97;1m%s\033[0m\n" JukeboxMod-Desktop.jar
	@printf "\t\033[32mandroid \033[90m(default)\033[0m\n"
	@printf "\t  Dex the mod into \033[91;1m%s\033[0m\n" JukeboxMod.jar
	@printf "\t  Compatible with PC and Android.\n"
	@printf "\t\033[32minstall\033[0m\n"
	@printf "\t  Install the desktop version to \033[97;1m%s\033[0m\n" $(MINDUSTRY)
	@printf "\t\033[32mclean\033[0m\n"
	@printf "\t  Remove compiled classes.\n"
	@printf "\t\033[31mreset\033[0m\n"
	@printf "\t  Remove compiled classes and downloaded libraries.\n"

.PHONY: all libs build android install clean reset help
