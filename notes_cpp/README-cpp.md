# C++ (C20)

## TABLE OF CONTENTS

- [C++ (C20)](#c-c20)
  - [TABLE OF CONTENTS](#table-of-contents)
  - [REFS:](#refs)
  - [Chapter 1, Getting Started](#chapter-1-getting-started)
    - [compiler in Win-64](#compiler-in-win-64)
    - [BAT PRINT .EXE RETURN CODE](#bat-print-exe-return-code)
    - [HELLO WORLD](#hello-world)
- [STL](#stl)

## REFS:

- Lippman, S., Lajoie, J., Moo, B. (2012) C++ Primer, (5th ed.). US: Addison-Wesley Professional. (C11) (1056pages)

## Chapter 1, Getting Started

### compiler in Win-64

- info:
  - in cygwin, install mingw64-gcc, make tools
  - add C:\cygwin64\bin to %PATH%

### BAT PRINT .EXE RETURN CODE

```bat
echo Exit Code is %errorlevel%
```

### HELLO WORLD

- src: [cp01_hello_world.cpp](./cp01_hello_world.cpp)

```bat
:: to compile
clang -Wall -Wextra -Werror -o outname.exe src.cpp
  :: (choco + clang is much easier to setup, compare to mingw_g++, which is somehow buggy even after setup)
  :: -Wall turns on a bunch of other options [man gcc](https://man7.org/linux/man-pages/man1/gcc.1.html)
  :: -Wextra turns on other warnings not enabled by Wall
  :: -Werror treat warn as error
  :: return 0 success, other vals defined by system
```

# STL

