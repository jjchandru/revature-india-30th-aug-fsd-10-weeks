pipeline {
	agent any
	stages {
		stage('build') {
			steps {
				withMaven (
				    maven: 'Maven 3.8.2'
				) {
				    bat 'mvn -B -f ./projects/Project1/bank-app/bank-app-rest/pom.xml clean package'
				}
			}
		}
		stage('deploy') {
			steps {
				deploy adapters: [tomcat9 (url: "http://localhost:8080", credentialsId: "tomcat-admin")],
				       war: 'projects/Project1/bank-app/bank-app-rest/target/bank-app-rest.war'
			}
		}
	}
}
