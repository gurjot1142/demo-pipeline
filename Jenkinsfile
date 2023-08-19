pipeline {
    agent any
    tools{
        maven 'maven_3_9_2'
    }
    stages{
        stage('Build Maven & Test'){
            steps{
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/gem-gurjotsingh/demoPipeline']])
                bat 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    bat 'docker build -t guru1142/demo-pipeline .'
                }
            }
        }
        stage('Push docker image to Docker Hub'){
            steps{
                script{
                    withCredentials([string(credentialsId: 'dockerhubnewpwd', variable: 'dockerhubpwd')]) {
                      bat 'docker login -u guru1142 -p %dockerhubpwd%'
                   }
                   bat 'docker push guru1142/demo-pipeline'
                }
            }
        }
    }
}
