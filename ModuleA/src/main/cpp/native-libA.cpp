#include <jni.h>
#include <string>



extern "C"
JNIEXPORT jstring JNICALL
Java_com_di_modulea_NativeHooksModuleA_stringFromJNI(JNIEnv *env, jobject thiz) {
    return env->NewStringUTF("Hello from C++ for Module A");
}