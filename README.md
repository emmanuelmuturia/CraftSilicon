# Craft Silicon

![The Craft Silicon Logo](/assets/images/logo/logo.png)

## Overview

This is my solution for the Technical Assessment by Craft Silicon...

## Table of Contents

1. [Background](#1-Background)
2. [Architecture](#2-Architecture)
3. [Screenshots](#3-Screenshots)
4. [Testing](#4-Testing)
5. [Trivia](#5-Trivia)
6. [Credits](#6-Credits)
7. [License](#7-License)

## 1) Background

- This project is an implementation of the Mobile Interview Test offered by Craft Silicon...
- It utilises [The OpenWeather API](https://openweathermap.org/api), specifically the following endpoints:

### a) The Current Weather Endpoint [/data/2.5/weather]

- This endpoint is used to retrieve the current weather details of a given area...

### b) The Forecast Weather Endpoint [/data/2.5/forecast]

- This endpoint is used to retrieve the forecast weather details of a given area...

## 2) Architecture

- Craft Silicon is a multi-module Android app implemented using the Model-View-ViewModel (MVVM) Architectural Pattern...
- It is divided into the following modules:

### a) :app

- This is the main module that houses the Main Activity, Application Class, and NavHost...
- MainActivity acts as the entry-point of the app following the Dependency Injection implementation, while CraftSiliconApplication initialises the app, and the NavHost defines the app's Navigation Hierarchy...

### b) :home

- This module contains the HomeScreen and its ViewModel...
- It is used to display both the Current Weather and Forecast Weather [5 Days] of a given city...

## 3) Screenshots

<div style="text-align: center;">

<table>
  <tr>
    <th>The Splash Screen</th>
    <th>The Login Screen</th>
    <th>The Home Screen</th>
  </tr>
  <tr>
    <td>
      <img src="assets/screenshots/demo/splash_screen.png" alt="The Splash Screen" style="max-width:490px; height:490px;">
    </td>
    <td>
      <img src="assets/screenshots/demo/login_screen.png" alt="The Login Screen" style="max-width:490px; height:490px;">
    </td>
    <td>
      <img src="assets/screenshots/demo/home_screen.png" alt="The Home Screen" style="max-width:490px; height:490px;">
    </td>
  </tr>
</table>

</div>

## 4) Testing

| Test                                                                                                       | Description                               |
|------------------------------------------------------------------------------------------------------------|-------------------------------------------|
| ![The Home Screen ViewModel Test](assets/images/test_screenshots/viewmodel/home_screen_viewmodel_test.png) | This is The Home Screen ViewModel Test... |
| ![The Home Screen UI Test](assets/images/test_screenshots/ui/home_screen_ui_test.png)                      | This is The Home Screen UI Test...        |
| ![The Craft Silicon DAO Test](assets/images/test_screenshots/dao/craft_silicon_dao_test.png)               | This is The Craft Silicon DAO Test...     |

## 5) Trivia

- Craft Silicon has used a hybrid modularisation technique where each of the modules listed above has implemented sub-modules that match the Presentation, Domain, and Data Layers in Android...

### Challenges

## 6) Credits

- Craft Silicon has been built using the following Tools, Technologies, and Libraries:

a] Jetpack Compose

- The app has utilised Google's modern UI toolkit ([Jetpack Compose](https://developer.android.com/jetpack/compose)) for its User Interface that prioritises the Kotlin-first approach of Android App Development (AAD)...

b] Koin

- For Dependency Injection using Kotlin, [Koin](https://insert-koin.io/) has been used in conjunction with:

c] Kotlin Symbol Processing (KSP)

- For faster builds regarding Annotations, [KSP](https://kotlinlang.org/docs/ksp-overview.html) has been implemented as a plugin...

d] Retrofit2

- As a core library, [Retrofit2](https://square.github.io/retrofit/) has been utilised for performing remote calls to the REST API through a level of abstraction...

e] OkHTTP3

- In addition to Retrofit2, [OkHTTP3](https://square.github.io/okhttp/) has also been implemented to aid in configuring the remote calls by providing an Interceptor and specifying the expected data type as JSON...

f] Kotlin Serialization

- During the remote calls, the returned data has been serialized and deserialized using the [Kotlin Serialization Plugin](https://kotlinlang.org/docs/serialization.html)...

g] Splash Screen

- The app has implemented its Splash Screen using Google's [Splash Screen API](https://developer.android.com/develop/ui/views/launch/splash-screen) which uses its custom theme alongside the app's theme...

h] LeakCanary

- To detect and fix memory leaks, [LeakCanary](https://square.github.io/leakcanary/) has been implemented...

i] MockK and Kotlin Coroutines Test

- During testing [MockK](https://mockk.io/) has been used to mimic the dependencies to be tested resulting in a close-to-real test case scenario...
- The Unit Tests used the [Kotlin Coroutines Test](https://kotlinlang.org/api/kotlinx.coroutines/kotlinx-coroutines-test/) library to provide the Coroutine Scopes for the suspending functions that were being tested...

## 7) License

```
MIT License

Copyright (c) 2025 Craft Silicon

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```