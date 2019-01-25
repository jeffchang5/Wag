# Stack Overflow Users

This project is an implementation of the specs required by the Procore challenge criteria. The app requires Android 5.1 and above.

### Getting Started

1. Clone the Github repo.
2. Open the project in Android Studio.
3. Build and run the project.

### Goals
* Demonstrate a good understanding of software architecture and tooling that are important in maintaining a modern codebase.
* Use MVVM to separate responsibilities from the view and create more easily tested classes.
* Use Architecture Components as a baseline for introducing Android best practices.
* Sensible file and project organization.
* Demonstrate the use of common Android libraries used commonly for modern codebases.
* Error handling to create better UX for predictable conditions.
* Handle a wide array of device definitions.
* Use dependency injection with Dagger 2 to produce decoupled objects and services. Relying on Dagger- Android to avoid writing boilerplate code.

### Features

* Displays a list of users on the first page of StackOverflow.
* See badges for each user.

### Third Party Libraries

* Picasso is used to load and cache images from the network
* Architecture Components LiveModel is used to have a lifecycle aware (and safe) place to hold data as well as convenient for writing a CLEAN architecture.
* RxJava 2 is used to provide a reactive stream method of presenting of data. It is easier to handle and manipulate different transactions.
* Retrofit is a great network abstraction library to convert JSO to POJO models.
* Dagger 2 is used to reduce boilerplate and create testable services and components.
* Timber is great for logging.