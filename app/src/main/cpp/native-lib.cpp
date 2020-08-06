#include <jni.h>
#include <string>

#include "AppSecretProtectedSecureKeys.h"

// namespace
using namespace std;

extern "C" JNIEXPORT jstring JNICALL
Java_com_michalfujak_example_e_1objednaj_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}


// native APP Secret Public Helper Key
extern "C"
JNIEXPORT jstring JNICALL
Java_com_michalfujak_example_e_1objednaj_Activity_MainActivity_stringHelperPublicKey(JNIEnv *env, jobject thiz)
{
    // std::string publicHelperKey = "AeDfGnKaPdSgVkXp5s5v8ytB?EplMbQr";
    // return env->NewStringUTF(publicHelperKey.c_str());
}

// Match value x + y
extern "C"
JNIEXPORT jobject JNICALL
Java_com_michalfujak_example_e_1objednaj_Activity_MainActivity_MatchRandomValue(JNIEnv *env, jobject thiz, jobject x, jobject y)
{
    // TODO: implement MatchRandomValue()
}extern "C"
JNIEXPORT jstring JNICALL
Java_com_michalfujak_example_e_1objednaj_Activity_MainActivity_adminDialogLoginAuthLTE_1Protected(JNIEnv *env, jobject thiz, jstring second_pass, jstring primary_pass) {
    // Admin.Dialog.Login.Auth
    // Porovnanie define predprocesora...
    bool returnPasswordRandom[5];
    //
    // returnPasswordRandom = { true, true, false, false, true }
    // jbooleanArray secterPassword;
    // return *env->NewBooleanArray()

// native public application key
}extern "C"
JNIEXPORT jstring JNICALL
Java_com_michalfujak_example_e_1objednaj_Activity_MainActivity_generatePublicApplicationKey(JNIEnv *env, jobject thiz)
{
    // Call public key
    AppSecretProtectedSecureKeys *objAppSecret = new AppSecretProtectedSecureKeys();
    return env->NewStringUTF(objAppSecret->getApplicationPrivateKey().c_str());
}