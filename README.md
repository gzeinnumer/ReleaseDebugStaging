# ReleaseDebugStaging

```java
if (BuildConfig.BUILD_TYPE.equals("release")) {
    textView.setText("release" + " " + BuildConfig.IS_DEBUG);
} else if (BuildConfig.BUILD_TYPE.equals("staging")){
    textView.setText("staging" + " " + BuildConfig.IS_DEBUG);
} else if (BuildConfig.BUILD_TYPE.equals("debug")){
    textView.setText("debug" + " " + BuildConfig.IS_DEBUG);
}
```

```gradle
android {

    ...

    buildTypes {
        release {
            buildConfigField "boolean", "IS_DEBUG", "false"
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'

            applicationVariants.all { variant ->
                variant.outputs.all {
                    def flavor = variant.name
                    def versionName = variant.versionName
                    outputFileName = "${appName}_${versionName}.${formattedDate}_${flavor}.apk"
                }
            }
        }
        staging  {
            buildConfigField "boolean", "IS_DEBUG", "true"
            minifyEnabled false
//            manifestPlaceholders = [app_name:"AppNameStaging"]

            applicationVariants.all { variant ->
                variant.outputs.all {
                    def flavor = variant.name
                    def versionName = variant.versionName
                    outputFileName = "${appName}_${versionName}.${formattedDate}_${flavor}.apk"
                }
            }
        }
        debug {
            buildConfigField "boolean", "IS_DEBUG", "true"
            minifyEnabled false
//            manifestPlaceholders = [app_name:"AppNameDebug"]

            applicationVariants.all { variant ->
                variant.outputs.all {
                    def flavor = variant.name
                    def versionName = variant.versionName
                    outputFileName = "${appName}_${versionName}.${formattedDate}_${flavor}.apk"
                }
            }
        }
    }
}
```

---

```
Copyright 2022 M. Fadli Zein
```