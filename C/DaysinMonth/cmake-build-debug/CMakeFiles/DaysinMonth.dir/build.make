# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.15

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /cygdrive/c/Users/emonc/.CLion2019.2/system/cygwin_cmake/bin/cmake.exe

# The command to remove a file.
RM = /cygdrive/c/Users/emonc/.CLion2019.2/system/cygwin_cmake/bin/cmake.exe -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /cygdrive/i/All-Code/C/DaysinMonth

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /cygdrive/i/All-Code/C/DaysinMonth/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/DaysinMonth.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/DaysinMonth.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/DaysinMonth.dir/flags.make

CMakeFiles/DaysinMonth.dir/main.c.o: CMakeFiles/DaysinMonth.dir/flags.make
CMakeFiles/DaysinMonth.dir/main.c.o: ../main.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/cygdrive/i/All-Code/C/DaysinMonth/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/DaysinMonth.dir/main.c.o"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/DaysinMonth.dir/main.c.o   -c /cygdrive/i/All-Code/C/DaysinMonth/main.c

CMakeFiles/DaysinMonth.dir/main.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/DaysinMonth.dir/main.c.i"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /cygdrive/i/All-Code/C/DaysinMonth/main.c > CMakeFiles/DaysinMonth.dir/main.c.i

CMakeFiles/DaysinMonth.dir/main.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/DaysinMonth.dir/main.c.s"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /cygdrive/i/All-Code/C/DaysinMonth/main.c -o CMakeFiles/DaysinMonth.dir/main.c.s

# Object files for target DaysinMonth
DaysinMonth_OBJECTS = \
"CMakeFiles/DaysinMonth.dir/main.c.o"

# External object files for target DaysinMonth
DaysinMonth_EXTERNAL_OBJECTS =

DaysinMonth.exe: CMakeFiles/DaysinMonth.dir/main.c.o
DaysinMonth.exe: CMakeFiles/DaysinMonth.dir/build.make
DaysinMonth.exe: CMakeFiles/DaysinMonth.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/cygdrive/i/All-Code/C/DaysinMonth/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking C executable DaysinMonth.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/DaysinMonth.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/DaysinMonth.dir/build: DaysinMonth.exe

.PHONY : CMakeFiles/DaysinMonth.dir/build

CMakeFiles/DaysinMonth.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/DaysinMonth.dir/cmake_clean.cmake
.PHONY : CMakeFiles/DaysinMonth.dir/clean

CMakeFiles/DaysinMonth.dir/depend:
	cd /cygdrive/i/All-Code/C/DaysinMonth/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /cygdrive/i/All-Code/C/DaysinMonth /cygdrive/i/All-Code/C/DaysinMonth /cygdrive/i/All-Code/C/DaysinMonth/cmake-build-debug /cygdrive/i/All-Code/C/DaysinMonth/cmake-build-debug /cygdrive/i/All-Code/C/DaysinMonth/cmake-build-debug/CMakeFiles/DaysinMonth.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/DaysinMonth.dir/depend

