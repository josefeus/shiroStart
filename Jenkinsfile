pipeline {
  agent any
  stages {
    stage('build') {
      parallel {
        stage('jacoco') {
          steps {
            jacoco(buildOverBuild: true, runAlways: true, changeBuildStatus: true)
          }
        }

        stage('finished') {
          steps {
            echo 'jacoco done'
          }
        }

      }
    }

  }
}