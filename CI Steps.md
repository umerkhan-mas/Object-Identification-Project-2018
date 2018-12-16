# Steps For Continuous Integration

1. In order to use travis CI as your Continuous integration platform, add it(travis CI) as one of your GitHub applications.
2. Sign in to Travis CI using your GitHub credentials and add the required repo to travis using its interactive GUI webiste.
3. Add a file called '.travis.yml' into your GitHub repo. This file is used to configure the CI steps.
4. In case of this project, the language used is java. Hence add the following,

* language:java

5. Add your JDK version to the config file.

* jdk: openjdk8

6. Add build scripts depending upon your build version. For example we use ant, hence we add the following lines to build and execute the test cases.

* script: ant build; ant ClassifierTest

7. You can also upload the test case results. For example if you use codecov, you may add the following line,

* after_success: bash <(curl -s https://codecov.io/bash)

8. Add badges depending upon the CI platform you are using. For example in travis CI you may use the following configuration in your readme file,

```![](https://travis-ci.com/<Owner name>/<Project Name>.svg?branch=<Branch Name>)```
 
 For example in case of our Object Identification project,
 
```![](https://travis-ci.com/umerkhan-mas/Object-Identification-Project-2018.svg?branch=master)```

This will give you the followin badge,

![](https://travis-ci.com/umerkhan-mas/Object-Identification-Project-2018.svg?branch=master)
