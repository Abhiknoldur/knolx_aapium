# UI Testing of knolx Android Application

### This Document covers the E2E Testing Of knolx Android Application Project using Appium

### Pre-requisite:
Appium

Android Studio

Adb cli

Maven

Java
 
TestNG

Allure

### Appium
Appium is an open-source tool for automating native, mobile web, and hybrid applications on iOS mobile, Android mobile, and Windows desktop platforms. Native apps are those written using the iOS, Android, or Windows SDKs. Mobile web apps are web apps accessed using a mobile browser (Appium supports Safari on iOS and Chrome or the built-in 'Browser' app on Android). Hybrid apps have a wrapper around a "webview" -- a native control that enables interaction with web content. Projects like Apache Cordova or Phonegap make it easy to build apps using web technologies that are then bundled into a native wrapper, creating a hybrid app.

Importantly, Appium is "cross-platform": it allows you to write tests against multiple platforms (iOS, Android, Windows), using the same API. This enables code reuse between iOS, Android, and Windows testsuites.

For specific information about what it means for Appium to "support" its platforms, and automation modalities, please see the platform support doc.

### Android Studio
Android Studio is the official integrated development environment (IDE) for Google's Android operating system, built on JetBrains' IntelliJ IDEA software and designed specifically for Android development.It is available for download on Windows, macOS and Linux based operating systems.It is a replacement for the Eclipse Android Development Tools (ADT) as the primary IDE for native Android application development.

Android Studio was announced on May 16, 2013 at the Google I/O conference. It was in early access preview stage starting from version 0.1 in May 2013, then entered beta stage starting from version 0.8 which was released in June 2014.The first stable build was released in December 2014, starting from version 1.0

### Adb cli
Android Debug Bridge (adb) is a versatile command-line tool that lets you communicate with a device. The adb command facilitates a variety of device actions, such as installing and debugging apps, and it provides access to a Unix shell that you can use to run a variety of commands on a device. It is a client-server program that includes three components:

### Maven
Apache Maven is a software project management and comprehension tool. Based on the concept of a project object model (POM), Maven can manage a project's build, reporting and documentation from a central piece of information.

If you think that Maven could help your project, you can find out more information in the "About Maven" section of the navigation: this includes an in-depth description of what Maven is and a list of some of its main features.

This site is separated into the following sections, depending on how you'd like to use Maven.

### Java
Java is a general-purpose programming language that is class-based, object-oriented, and designed to have as few implementation dependencies as possible 

### TestNG
TestNG is a testing framework for the Java programming language created by Cédric Beust and inspired by JUnit and NUnit. The design goal of TestNG is to cover a wider range of test categories: unit, functional, end-to-end, integration, etc., with more powerful and easy-to-use functionalities

## Allure
Allure Commandline is a tool to generate Allure report from test results. Now you can get it installed directly from NPM.

### Steps to Setup this project 

1. Download all the Pre-requisites and setup environment for both Java and Android Studio

2.Clone this Project from the URL : 
        
        git clone https://github.com/KnoldusLabs/UIUXAutomationTest.git
        
3. move knolx-app-e2t-testing directory 
    
        cd knolx-app-e2t-testing/
        
4. To run the test-cases 
    
        mvn test

5. To generate the report

        allure serve target/allure-results
 
This will open the interactive html report for the executed tests