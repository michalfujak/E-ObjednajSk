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

// Native APP Secret Private Key
extern "C"
JNIEXPORT jstring JNICALL
Java_com_michalfujak_example_e_1objednaj_Activity_MainActivity_stringCryptoPrivateKey(JNIEnv *env, jobject thisSecond) {
    //
    AppSecretProtectedSecureKeys *objAppSecret = new AppSecretProtectedSecureKeys();
    return env->NewStringUTF(objAppSecret->getApplicationPrivateKey().c_str());
    // return env->NewStringUTF(objAppSecret->appPrivateKeyRead().c_str());
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
}