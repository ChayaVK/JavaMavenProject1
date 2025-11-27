pipeline {
    agent any
    tools {
        maven 'Maven'           // Define Maven tool name from Jenkins global config
        jdk   'JDK25'           // Define JDK version installed in Jenkins
    }

    environment {
        PATH = "$MAVEN_HOME/bin:$PATH"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master',
                    url: 'https://github.com/ChayaVK/JavaMavenProject1.git'
            }
        }

        stage('Install Dependencies & Build') {
            steps {
                bat 'mvn clean install -DskipTests'
            }
        }

        stage('Run Selenium TestNG Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Archive Test Results') {
            steps {
                junit 'target/surefire-reports/*.xml'     // TestNG XML results
                archiveArtifacts artifacts: 'target/**/*.html', allowEmptyArchive: true
            }
        }

        // ---- OPTIONAL: Allure Reporting ----
        // stage('Allure Report') {
        //     steps {
        //         allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
        //     }
        // }

    }

    post {
        always {
            echo "Pipeline execution finished."
        }
        failure {
            echo "Build failed! Check test results."
        }
    }
}
