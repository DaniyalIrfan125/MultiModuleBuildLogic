#include <jni.h>

//
// Created by daniy on 08/10/2024.
//


extern "C"
JNIEXPORT jstring JNICALL
Java_com_myvaultspay_merchantmodule_NativeHooksMerchant_stringFromJNI(JNIEnv *env, jobject thiz) {
    return env->NewStringUTF("Hello from C++ for Module B");
}