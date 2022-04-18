# Book a room

## Clean architecture with 3 layers
- Data (for database, API and preferences code)
- Domain (for business logic and models)
- App (for UI logic, with [MVI](https://www.raywenderlich.com/817602-mvi-architecture-for-android-tutorial-getting-started))


## Other useful features
- Dependency injection (with [Hilt](http://google.github.io/hilt/))
- Reactive programming with [RXJAVA](https://reactivex.io/)
- Google [Material Design](https://material.io/blog/android-material-theme-color) library
- Quick cached Image loading (with [Picasso](https://square.github.io/picasso/))
- Networking (with [Retrofit](https://square.github.io/retrofit/))
- Flat layout hierarchy (with [Constraint layouts](https://developer.android.com/jetpack/androidx/releases/constraintlayout))
- Multi Screen Segmentation (with [Fragments](https://developer.android.com/jetpack/androidx/releases/fragment))
- Navigation (with [Navigation Library](https://developer.android.com/guide/navigation/navigation-migrate))
- Android lifecyle aware components (with [Lifecycle](https://developer.android.com/jetpack/androidx/releases/lifecycle))
- Fluid list loading (with [Recycler View](https://developer.android.com/jetpack/androidx/releases/recyclerview))
- Data Persistence (with [Room](https://developer.android.com/jetpack/androidx/releases/room))
- Data surviving configuration changes (with [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel))
- Type safe dependency management (with [Kotlin DSL](https://kotlinlang.org/docs/type-safe-builders.html))
- Android architecture components to share ViewModels during configuration changes


# Getting started

### Script
1. Clone this repository preferably with Android Studio
2. Build project and then run application. In the situation where you are asked about trusting the application please do select *yes*
3. Please make sure you are on the `main` branch as that has all the latest changes.

# Notes
- Book a room has offline support. Data is retrieved from remote when data is established and saved.

# Future Improvements
- Network notification when data is restored.
- Make UI Improvements and possibly introducing [compose](https://developer.android.com/jetpack/androidx/releases/compose)
- Introduce some nice error pages and not rely on toasts.

# Issues faced
- Run out of time to implement all that was needed. With more time I would have implemented more instrumentation test the fragments and unit tests for data repositories and viewModels
- added filtering options for meeting rooms 


