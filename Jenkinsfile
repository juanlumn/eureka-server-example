#!groovy

pipeline {
    agent {
        label 'master'
    }
    triggers {
        pollSCM('')
    }
    stages {
        stage('Setup') {
            steps {
                echo 'Giving execute permissions to gradlew'
                sh "chmod 755 gradlew"
            }
        }
        stage('Test And Build') {
            steps {
                echo ' Building jar'
                sh "./gradlew clean build"
                publishHTML(target: [
                        allowMissing: false,
                        alwaysLinkToLastBuild: false,
                        keepAll: false,
                        reportDir: 'build/reports/tests',
                        reportFiles: 'index.html',
                        reportName: 'HTML Report'
                ])
                step([$class: 'JacocoPublisher', classPattern: '**/build/classes/main/com/juanlumn/example'])
            }
        }
        stage('Deploy') {
            steps {
                ansiblePlaybook colorized: true, extras: '-e "jenkins_workspace=${WORKSPACE} app_name=eureka-server-example host_name=Eureka-Server-Example"', installation: 'Ansible 2.2.0', inventory: '/home/ansible/hosts/host', playbook: '/home/ansible/Deploy_Applications.yml', sudoUser: null
            }
        }
    }
}