#include <jni.h>

//
// Created by daniy on 08/10/2024.
//

extern "C"
JNIEXPORT jstring JNICALL
Java_com_di_moduleb_NativeHooksModuleB_stringFromJNI(JNIEnv *env, jobject thiz) {
    return env->NewStringUTF("Hello from C++ for Module B");
}