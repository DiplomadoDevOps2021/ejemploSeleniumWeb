pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh "/usr/local/opt/maven/bin/mvn clean"
            }
        }

        stage('test') {
            steps {
                sh "/usr/local/opt/maven/bin/mvn compile"
            }
        }

        stage('test2') {
            steps {
                sh '''
                    /usr/local/opt/maven/bin/mvn test
                '''
            }
        }
    }
}