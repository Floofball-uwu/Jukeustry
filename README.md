# Jukebox Mod
Adds jukeboxes to the game. Thats it. May or may not add more in the future.



## Compiling
JDK 8.

### Windows
Plain Jar: `gradlew build`\
Dexify Plain Jar: `gradlew dexify`\
Build Plain & Dexify Jar: `gradlew buildDex`

### *nix
Plain Jar: `./gradlew build`\
Dexify Plain Jar: `./gradlew dexify`\
Build Plain & Dexify Jar: `./gradlew buildDex`

Plain Jar is for JVMs (desktop).\
Dexed Jar is for ARTs (Android). This requires `dx` on your path (Android build-tools).\
These two are separate in order to decrease size of mod download.
