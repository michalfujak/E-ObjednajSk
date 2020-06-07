//
// Created by micha on 7. 6. 2020.
//
#include <jni.h>
#include <string>
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
#include "AppSecretProtectedSecureKeys.h"


// Class AppSecretProtectedSecureKeys

AppSecretProtectedSecureKeys::AppSecretProtectedSecureKeys()
{
    // Construct
    // this->setApplicationPrivateKey(this->APP_PRIVATE_KEY);
    // this->setApplicationPrivateHelperKey(this->APP_PRIVATE_HELPER_KEY);
}

// ~AppSecretProtectedSecureKeys()
//
AppSecretProtectedSecureKeys::~AppSecretProtectedSecureKeys()
{
    // Destruct
}

// appPrivateKeyRead()
//
string AppSecretProtectedSecureKeys::appPrivateKeyRead()
{
    return this->APP_PRIVATE_KEY;
}

// setApplicationPrivateKey(string key)
//
string AppSecretProtectedSecureKeys::setApplicationPrivateKey(string key)
{
    this->appPrivateKey = key;
}

// getApplicationPrivateKey()
//
string AppSecretProtectedSecureKeys::getApplicationPrivateKey()
{
    return this->getApplicationPrivateKey();
}

// setApplicationPrivateHelperKey(string key)
//
string AppSecretProtectedSecureKeys::setApplicationPrivateHelperKey(string key)
{
    this->appPrivateHelperKey = key;
}

// getApplicationPrivateHelperKey()
//
string AppSecretProtectedSecureKeys::getApplicationPrivateHelperKey()
{
    return this->appPrivateHelperKey;
}






















