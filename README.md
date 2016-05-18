# Overview

This is starter template for writing Android apps using **Clean architecture**. You can download it, modify it and start building your apps on top of it. Most of the boilerplate code for writing your first view, presenter and interactor is already written and you just need to implement your own logic. I wrote a [detailed guide] on how to write apps using this pattern but this README contains the summary.

This starter app supports **API 15 and above**.

This template uses **regular Java** instead of RxJava and does not use Dagger. Although I recommend Dagger, the reason for this is that I did not want to add more complexity as the architecture itself is probably complex enough to understand. If you prefer RxJava and Dagger then you can look at an awesome project called [Android-CleanArchitecture] that also inspired me to create this.

To see a sample app using Clean Architecture you can look [here].

## Some of the Libraries included

 - [Android Support Library] for backwards compatibility.
 - [Timber] for logging.
 - [Butterknife] for view injection.
 - [Retrofit] for network code.
 - [JUnit] and [Mockito] for testing.
 - [Findbugs] for finding bugs, *duh*.


# License

`MIT`

[detailed guide]: <https://medium.com/p/a-detailed-guide-on-developing-android-apps-using-the-clean-architecture-pattern-d38d71e94029>
[here]: <https://github.com/dmilicic/android-clean-sample-app>
[How to]: <https://stackoverflow.com/questions/16804093/android-studio-rename-package>
[Butterknife]: <https://github.com/JakeWharton/butterknife>
[Timber]: <https://github.com/JakeWharton/timber>
[Android Support Library]: <https://developer.android.com/tools/support-library/index.html>
[JUnit]: <https://github.com/junit-team/junit/wiki/Download-and-Install>
[Mockito]: <http://site.mockito.org/>
[Retrofit]: <https://square.github.io/retrofit/>
[Findbugs]: <http://findbugs.sourceforge.net/>
[DBFlow]: <https://github.com/Raizlabs/DBFlow>
[SharedPreferences]: <http://developer.android.com/training/basics/data-storage/shared-preferences.html>
[ContentProviders]: <http://developer.android.com/guide/topics/providers/content-providers.html>

[Android-CleanArchitecture]: <https://github.com/android10/Android-CleanArchitecture>
