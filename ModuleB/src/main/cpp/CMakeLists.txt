
cmake_minimum_required(VERSION 3.10.2)

# Create a shared library
add_library(native-libB SHARED native-libB.cpp)

# Specify the libraries you want to link to your native library
find_library(log-lib log)

# Link the native library with the log library
target_link_libraries(native-libB ${log-lib})
