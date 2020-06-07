//
// Created by micha on 7. 6. 2020.
//

using namespace std;

#ifndef E_OBJEDNAJ_APPSECRETPROTECTEDSECUREKEYS_H
#define E_OBJEDNAJ_APPSECRETPROTECTEDSECUREKEYS_H


class AppSecretProtectedSecureKeys
{
public:
    AppSecretProtectedSecureKeys();
    ~AppSecretProtectedSecureKeys();
    string appPrivateKeyRead();
    string setApplicationPrivateKey(string key);
    string getApplicationPrivateKey();
    string setApplicationPrivateHelperKey(string key);
    string getApplicationPrivateHelperKey();

private:
    string appPrivateKey;
    string appPrivateHelperKey;
    string APP_PRIVATE_KEY = "AeDfGnKaPdSgVkXp2s5v8ytB?EplMbQe";
    string APP_PRIVATE_HELPER_KEY = "AeDCGnKxPdSgVkXp2t5v8ytB?EDlMbQe";
};


#endif //E_OBJEDNAJ_APPSECRETPROTECTEDSECUREKEYS_H
